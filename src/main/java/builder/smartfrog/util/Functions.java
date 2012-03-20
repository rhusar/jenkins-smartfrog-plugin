package builder.smartfrog.util;

import hudson.FilePath;

import java.io.File;
import java.io.IOException;

/**
 * 
 * @author vjuranek
 *
 */
public class Functions {

    public static String convertWsToCanonicalPath(FilePath workspace){
        String workspacePath = "";
        try {
            workspacePath = (new File(workspace.toURI())).getCanonicalPath();
        } catch(IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return workspacePath;
    }
    
    public static String cmdArrayToString(String[] cmds){
        String cmd = "";
        for(String c : cmds){
            cmd += c + " ";
        }
        return cmd.substring(0, cmd.length()-1);
    }
}
