package builder.smartfrog.util;

import hudson.model.BuildListener;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class ConsoleLogger {
    
    private final BuildListener listener;
    private final SmartFrogConsoleAnnotator annotator;
    
    public ConsoleLogger(BuildListener listener){
        this.listener = listener;
        this.annotator = new SmartFrogConsoleAnnotator(this.listener.getLogger());
    }

    public BuildListener getListener(){
        return listener;
    }
    
    public PrintStream getLogger(){
        return listener.getLogger();
    }
    
    // needs to be synchronized as log is accessed from multiple threads
    public synchronized void logAnnot(String message){
        byte[] msg = (message + "\n").getBytes(Charset.defaultCharset());
        try{
            annotator.eol(msg,msg.length);
        } catch(IOException e){
            listener.getLogger().println("Problem with writing into console log: " + e.getMessage());
        }
    }
    
    public synchronized void log(String message){
        listener.getLogger().println(message);
    }
}
