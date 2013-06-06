package builder.smartfrog;

import static org.junit.Assert.assertEquals;
import hudson.model.FreeStyleBuild;
import hudson.model.BooleanParameterDefinition;
import hudson.model.FreeStyleProject;
import hudson.model.ParameterDefinition;
import hudson.model.ParametersDefinitionProperty;
import hudson.model.StringParameterDefinition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

public class StringScriptSourceTest {
    
    @Rule
    public JenkinsRule j = new JenkinsRule();
    
    @Test
    public void expandBuildParams() throws IOException, ExecutionException, InterruptedException {
        FreeStyleProject project = j.createFreeStyleProject();
        ParameterDefinition stringParDef = new StringParameterDefinition("TestStringParam", "My test string parameter", "String description");
        ParameterDefinition boolParDef = new BooleanParameterDefinition("TestBooleanParam", true, "Bool description");
        project.addProperty(new ParametersDefinitionProperty(stringParDef, boolParDef));
        FreeStyleBuild build = project.scheduleBuild2(0).get();
        
        String script = "My test script with string param of with value ${TestStringParam} and boolean param with value ${TestBooleanParam}";
        StringScriptSource ss = new StringScriptSource("testScript", script);
        ss.createDefaultScriptFile(build);
        BufferedReader br = new BufferedReader(new FileReader(ss.getDefaultScriptPath()));
        String actualScrtipt = br.readLine();
        br.close();
        assertEquals("My test script with string param of with value My test string parameter and boolean param with value true",actualScrtipt);
    }

}
