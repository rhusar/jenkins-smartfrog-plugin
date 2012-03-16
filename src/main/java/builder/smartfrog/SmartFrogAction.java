/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package builder.smartfrog;

import hudson.Launcher;
import hudson.Proc;
import hudson.model.Action;
import hudson.model.Build;
import hudson.model.LargeText;
import hudson.model.AbstractBuild;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;

import java.util.Map;
import java.util.Vector;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import builder.smartfrog.util.LineFilterOutputStream;

/**
 *
 * @author Dominik Pospisil
 */
public class SmartFrogAction implements Action, Runnable {

   private static final String nl = System.getProperty("line.separator");
    
   private String host;
   private State state = State.STARTING;
   private AbstractBuild<?,?> build;
   
   private transient SmartFrogBuilder builder;
   private transient Proc proc;
   private transient Thread execThread;
   private transient Vector<SmartFrogActionListener> listeners = new Vector<SmartFrogActionListener>();
   private transient Launcher launcher;
   private transient PrintStream log;
   
   public enum State { STARTING, RUNNING, FINISHED, FAILED };
   
   private class SFFilterOutputStream extends LineFilterOutputStream {

      private OutputStreamWriter os;
      
      public SFFilterOutputStream(OutputStream out) {
         super(out);
         os = new OutputStreamWriter(out);
      }
      protected void writeLine(String line) {
         
         if (line.startsWith("SmartFrog ready")) setState(State.RUNNING);
         
         int idx = line.indexOf("[TerminateHook]");
         if (idx > -1) {
            String compName = line.substring(line.indexOf('[', idx + 15) + 1);
            compName = compName.substring(0, compName.indexOf(']') );
            if (compName.endsWith(builder.getScriptName())) {
               builder.componentTerminated(! line.contains("ABNORMAL"));
            }
         }
         
         try {
            os.write(line);
            os.write(nl);
            os.flush();
         } catch (IOException ioe) {
            
         }
      }
      
   }
   
   public SmartFrogAction(SmartFrogBuilder builder, String host) {
      this.builder = builder;
      this.host = host;                
   }
   
   public void perform(final AbstractBuild<?, ?> build, final Launcher launcher) {
      this.build = build;
      this.launcher = launcher;      
      
      String[] cl = builder.buildDaemonCommandLine(host);      
      
      Map<String,String> env = build.getEnvVars();
      try {         
         log = new PrintStream(new SFFilterOutputStream(new FileOutputStream(getLogFile())));
         proc = launcher.launch(cl, env, log, build.getParent().getWorkspace());
         execThread = new Thread(this, "SFDaemon - " + host);
         execThread.start();
      } catch (IOException ioe) {
         
      }
      
   }

   public String getIconFileName() {
      return "/plugin/org.jboss.hudson.smartfrog/icons/smartfrog24.png";
   }

   public String getDisplayName() {
      return "sfDaemon - " + host;
   }

   public String getUrlName() {
      return "console-" + host;
   }

   public AbstractBuild<?,?> getOwnerBuild() {
       return build;
   }
   
   public boolean isBuilding() {
      return (state != State.FAILED) && (state != State.FINISHED);
   }

    public String getHost() {
        return host;
    }
   
    public File getLogFile() {
        return new File(build.getRootDir(), host + ".log");
    }
 
    /**
     * Handles incremental log output.
     */
    public void doProgressiveLog( StaplerRequest req, StaplerResponse rsp) throws IOException {
        new LargeText(getLogFile(),!isBuilding()).doProgressText(req,rsp);
    }
    
    private void setState(State s) {
       if (this.getState() == s) return;
       this.state = s;
       for (SmartFrogActionListener l : listeners) l.stateChanged(this,getState());
    }
    
    public void addStateListener(SmartFrogActionListener l) {
       listeners.add(l);
    }

    public void removeStateListener(SmartFrogActionListener l) {
       listeners.remove(l);
    }

   public State getState() {
      return state;
   }

   public PrintStream getLogAsText() {
       return log;
   }

   public Reader getLogReader() throws IOException {
      File logFile = getLogFile();
      return new FileReader(logFile);
   }
   
   public void run() {
      // wait for proccess to finish
      try
      {
         proc.join();
      } catch (IOException ex) {
         setState(State.FAILED);
         return;
      } catch (InterruptedException ex) {
         setState(State.FAILED);
         return;
      }
      setState(State.FAILED);  
   }
   
   public void interrupt() {
      String[] cl = builder.buildStopDaemonCommandLine(host);      
      try {
         launcher.launch(cl, build.getEnvVars(), log, build.getParent().getWorkspace()).join();
         execThread = new Thread(this, "SFDaemon - " + host);
         execThread.start();
      } catch (IOException ioe) {         
      } catch (InterruptedException ioe) {
          
      }
   }
      
   
}
