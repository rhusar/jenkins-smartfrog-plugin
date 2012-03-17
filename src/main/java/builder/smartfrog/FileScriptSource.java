package builder.smartfrog;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;
import hudson.model.Hudson;

/**
 * 
 * @author vjuranek
 *
 */
public class FileScriptSource extends ScriptSource {

    private String scriptPath;
    
    @DataBoundConstructor
    public FileScriptSource(String scriptName, String scriptPath){
        this.scriptName = scriptName;
        this.scriptPath = scriptPath;
    }
    
    public String getScriptPath() {
        return scriptPath;
    }
    
    public String getDefaultScriptPath() {
        return scriptPath;
    }
    
    public DescriptorImpl getDescriptor(){
        return (DescriptorImpl)Hudson.getInstance().getDescriptor(getClass());
    }
    
    @Extension
    public static class DescriptorImpl extends ScriptSourceDescriptor{
        public String getDisplayName() {
            return "String script source";
        }
    }

}
