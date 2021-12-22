import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        //features = "src/test/resources/features/"
        strict = true,
        features = {
                //"classpath:features/DigitalProduct/ButtonRetryDigitalpayment.feature",
                //"classpath:features/Register.feature",
                // "classpath:features/LoginBangkokok.feature:13",
                //"classpath:features/LoginBangkokok.feature:16"
                //"classpath:features/DigitalProduct/DompetPulsa.feature",
                //"classpath:features/BankTransfer/BankInquiry/InquiryAccNumPermata.feature",
                //"classpath:features/BankTransfer/BankInquiry/InquiryAccNumMega.feature",
                //"classpath:features/BankTransfer/InternalWithdrawalTransfer/BeneficiaryNameFlip.feature"
                //"classpath:features/BankTransfer/BankStatement/Danamon.feature:8"
                //"classpath:features/BankTransfer/BankStatement/DBSBank.feature:20"
                //"classpath:features/BankTransfer/UAT/Muamalat.feature"
                "/Users/anjas.muhammad/Desktop/ULA_Automation_Anjas/ula/src/test/resources/features/Sign In.feature"
        }
        ,plugin = {"json:/Users/anjas.muhammad/Desktop/ULA_Automation_Anjas/ula/target/cucumber-parallel/1.json"}
        ,tags = "not @sequence"
)

public class TestSuite {
}

/*
import org.junit.runner.RunWith;

        import io.cucumber.junit.CucumberOptions;
        import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        strict = true,
        features = {"/Users/macbook/Desktop/Android/Shopee Cucumber/src/test/resources/features/Register.feature"},
        plugin = {"json:/Users/macbook/Desktop/Android/Shopee Cucumber/target/cucumber-parallel/1.json"},
        monochrome = false,
        tags = "not @sequence",
        glue = {"Tests"})
public class TestSuite {
}
*/