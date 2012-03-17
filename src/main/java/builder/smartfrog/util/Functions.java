package builder.smartfrog.util;

import hudson.FilePath;

import java.io.File;
import java.io.IOException;

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
    
}
