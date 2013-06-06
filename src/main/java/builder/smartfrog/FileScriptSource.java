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
public class FileScriptSource extends ScriptSource {

    private String scriptPath;
    private File tmpScriptFile;
    
    @DataBoundConstructor
    public FileScriptSource(String scriptName, String scriptPath){
        this.scriptName = scriptName;
        this.scriptPath = scriptPath;
    }
    
    public String getScriptPath() {
        return scriptPath;
    }
    
    public String getDefaultScriptPath() {
        if(tmpScriptFile != null)
            return tmpScriptFile.getPath();
        return scriptPath;
    }
    
    @Override
    public void createScriptFile(AbstractBuild<?,?> build) throws InterruptedException, IOException {
        FilePath fp = new FilePath(build.getWorkspace(), getScriptPath());
        String scriptContent = fp.readToString(); // TODO not very safe, if e.g. some malicious user provide path to huge file
        FilePath path = createDefaultScriptFile(scriptContent, build);
        tmpScriptFile = new File(path.getRemote());
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
