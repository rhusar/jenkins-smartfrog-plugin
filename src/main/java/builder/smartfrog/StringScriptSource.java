package builder.smartfrog;

import java.io.File;
import java.io.IOException;

import hudson.Extension;
import hudson.FilePath;
import hudson.model.AbstractBuild;
import hudson.model.Hudson;

import org.kohsuke.stapler.DataBoundConstructor;

/**
 * 
 * @author vjuranek
 *
 */
public class StringScriptSource extends ScriptSource {

    private static final String DEFAULT_SCRIPT_NAME = "deployScript";
    private static final String DEFAULTSCRIPT_SUFFIX = ".sf";
    
    private final String scriptContent;
    private transient File defaultScriptFile;
    
    @DataBoundConstructor
    public StringScriptSource(String scriptName, String scriptContent){
        this.scriptName = scriptName;
        this.scriptContent = scriptContent;
    }
    
    public String getScriptContent() {
        return scriptContent;
    }
    
    public void createDefaultScriptFile(AbstractBuild<?,?> build) throws InterruptedException, IOException {
        FilePath path = build.getWorkspace().createTextTempFile(DEFAULT_SCRIPT_NAME, DEFAULTSCRIPT_SUFFIX, scriptContent, true);
        defaultScriptFile = new File(path.getRemote());
    }
    
    public String getDefaultScriptPath(){
        return defaultScriptFile.getPath();
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
