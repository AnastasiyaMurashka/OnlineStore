package runners;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import util.TestRunnerWithListener;


@RunWith(TestRunnerWithListener.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps",
        tags = "@login"
)

public class LoginRunnerTest {
}
