package builder.smartfrog;

import hudson.Extension;
import hudson.FilePath;
import hudson.model.AbstractBuild;
import hudson.model.Hudson;

import java.io.File;
import java.io.IOException;

import org.kohsuke.stapler.DataBoundConstructor;

/**
 * 
 * @author vjuranek
 *
 */
public class StringScriptSource extends ScriptSource {
    
    private final String scriptContent;
    private transient File tmpScriptFile;
    
    @DataBoundConstructor
    public StringScriptSource(String scriptName, String scriptContent){
        this.scriptName = scriptName;
        this.scriptContent = scriptContent;
    }
    
    public String getScriptContent() {
        return scriptContent;
    }
    
    @Override
    public void createScriptFile(AbstractBuild<?,?> build) throws InterruptedException, IOException {
        FilePath path = createDefaultScriptFile(scriptContent, build);
        tmpScriptFile = new File(path.getRemote());
    }
    
    public String getDefaultScriptPath(){
        return tmpScriptFile.getPath();
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
