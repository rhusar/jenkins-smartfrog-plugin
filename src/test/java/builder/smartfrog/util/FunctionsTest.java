package builder.smartfrog.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FunctionsTest {
    
    @Test
    public void buildCmdLine() {
        String[] cmds = {"bash", "-xe", "runSF.sh", "testHost"};
        String cmdLine = Functions.cmdArrayToString(cmds);
        assertEquals("bash -xe runSF.sh testHost", cmdLine);
    }

}
