package builder.smartfrog.util;

import static org.junit.Assert.assertEquals;
import hudson.MarkupText;

import org.junit.Test;

public class SmartFrogConsoleNoteTest {

    @Test
    public void annotateConsoleOutput() {
        SmartFrogConsoleNote note = new SmartFrogConsoleNote();
        MarkupText error = new MarkupText("2013-06-11 08:33:14,001 ERROR some serious message");
        note.annotate(null, error, 0);
        assertEquals("<span style=\"font-weight: bold; color:red\">2013-06-11 08:33:14,001 ERROR some serious message</span>", error.toString(false));
        MarkupText info = new MarkupText("2013-06-11 08:33:14,001 INFO some not so serious message");
        note.annotate(null, info, 0);
        assertEquals("<span style=\"color:#993300\">2013-06-11 08:33:14,001 INFO some not so serious message</span>", info.toString(false));
    }
    
}
