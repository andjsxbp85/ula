import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    strict = true,
    features = {"/Users/anjas.muhammad/Desktop/ULA_Automation_Anjas/ula/src/test/resources/features/amazon/Sign In.feature"},
    plugin = {"json:/Users/anjas.muhammad/Desktop/ULA_Automation_Anjas/ula/target/cucumber-parallel/3.json"},
    monochrome = false,
        tags = "not @sequence"
    )
public class Parallel03IT {
}