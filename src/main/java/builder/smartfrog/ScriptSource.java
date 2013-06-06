package builder.smartfrog;

import hudson.DescriptorExtensionList;
import hudson.FilePath;
import hudson.model.Describable;
import hudson.model.AbstractBuild;
import hudson.model.Descriptor;
import hudson.model.Hudson;
import hudson.model.ParametersAction;

import java.io.IOException;

/**
 * Base class for various script sources.
 * 
 * @author vjuranek
 *
 */
public abstract class ScriptSource implements Describable<ScriptSource> {
    
    protected static final String DEFAULT_SCRIPT_NAME = "deployScript";
    protected static final String DEFAULTSCRIPT_SUFFIX = ".sf";
        
    protected String scriptName;

    public String getScriptName() {
        return scriptName;
    }
    
    public abstract String getDefaultScriptPath();
    
    public abstract void createScriptFile(AbstractBuild<?,?> build) throws InterruptedException, IOException;
    
    public FilePath createDefaultScriptFile(String scriptContent, AbstractBuild<?,?> build) throws InterruptedException, IOException {
        String script = scriptContent;
        ParametersAction pa = build.getAction(ParametersAction.class);
        if(pa != null)
            script = pa.substitute(build, script);
        FilePath path = build.getWorkspace().createTextTempFile(DEFAULT_SCRIPT_NAME, DEFAULTSCRIPT_SUFFIX, script, true);
        return path;
    }
    
    public static DescriptorExtensionList<ScriptSource,ScriptSource.ScriptSourceDescriptor> all() {
        return Hudson.getInstance().getDescriptorList(ScriptSource.class);
    }
    
    public static abstract class ScriptSourceDescriptor extends Descriptor<ScriptSource> {
    }

}
