package builder.smartfrog;

import hudson.DescriptorExtensionList;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.model.Hudson;

/**
 * Base class for various script sources.
 * 
 * @author vjuranek
 *
 */
public abstract class ScriptSource implements Describable<ScriptSource> {
        
    protected String scriptName;

    public String getScriptName() {
        return scriptName;
    }
    
    public abstract String getDefaultScriptPath();
    
    public static DescriptorExtensionList<ScriptSource,ScriptSource.ScriptSourceDescriptor> all() {
        return Hudson.getInstance().getDescriptorList(ScriptSource.class);
    }
    
    public static abstract class ScriptSourceDescriptor extends Descriptor<ScriptSource> {
    }

}
