package builder.smartfrog.util;

import hudson.Extension;
import hudson.MarkupText;
import hudson.console.ConsoleAnnotationDescriptor;
import hudson.console.ConsoleAnnotator;
import hudson.console.ConsoleNote;

/**
 * 
 * @author vjuranek
 *
 */
public class SmartFrogConsoleNote  extends ConsoleNote {
    
    @Override
    public ConsoleAnnotator annotate(Object context, MarkupText text, int charPos){
        if(text.getText().contains("ERROR"))
            text.addMarkup(0,text.length(),"<span style=\"font-weight: bold; color:red\">","</span>");
        if(text.getText().contains("INFO"))
            text.addMarkup(0,text.length(),"<span style=\"color:#993300\">","</span>");
        return null;
    }
    
    @Extension
    public static final class DescriptorImpl extends ConsoleAnnotationDescriptor {
        public String getDisplayName() {
            return "Smart Frog errors";
        }
    }

}
