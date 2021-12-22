package Pages;

import Utils.WebExe;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends WebExe {
    @FindBy(css="#ap_email") WebElement emailInput;
    @FindBy(css="input#continue") WebElement continueButton;
    @FindBy(css="[role='img'][aria-label='Amazon']") WebElement amazonLogo;
    @FindBy(xpath="//h1[contains(text(),'Sign-In')]") WebElement signInHeader;
    @FindBy(xpath="//label[contains(text(),'Email or mobile phone number')]") WebElement emailPhoneNumberLabel;
    @FindBy(xpath = "//*[@id='legalTextRow']") WebElement agreementText;
    @FindBy(xpath = "//span[contains(text(),'Need help?')]") WebElement hyperlinkNeedHelp;
    @FindBy(css="#ap_password") WebElement passwordInput;
    @FindBy(css="input#signInSubmit") WebElement buttonSignIn;
    @FindBy(css="#auth-error-message-box h4") WebElement headerAlertErrorLogin;
    @FindBy(css="#auth-error-message-box span") WebElement wordingAlertErrorLogin;
    @FindBy(css="#auth-email-missing-alert .a-alert-content") WebElement missingEmailAlert;
    @FindBy(css="#auth-password-missing-alert .a-alert-content") WebElement missingPasswordAlert;
    @FindBy(css="#createAccountSubmit") WebElement buttonCreateAmazonAccount;

    public void inputEmailOrPhonenumberUser(String emailOrPhoneNumber){
        waitingForPresenceOfElement(emailInput,5000,100);
        sendKeys(emailInput,emailOrPhoneNumber,5);
    }

    public void clickButtonContinue(){
        waitingForPresenceOfElement(continueButton,5000,100);
        click(continueButton,5);
    }

    public void inputPasswordUser(String password){
        waitingForPresenceOfElement(passwordInput,6000,100);
        sendKeys(passwordInput,password,5);
    }

    public void clickButtonSignIn(){
        waitingForPresenceOfElement(buttonSignIn,5000,100);
        click(buttonSignIn,5);
    }

    public void clickButtonCreateAmazonAccount(){
        waitingForPresenceOfElement(buttonCreateAmazonAccount,10000,100);
        click(buttonCreateAmazonAccount,5);
    }

    public void assertLoginPageView(){
        waitingForPresenceOfElement(emailInput,5000,100);
        waitingForPresenceOfElement(continueButton,5000,100);

        Assert.assertTrue(emailInput.isDisplayed());
        Assert.assertTrue(continueButton.isDisplayed());
        Assert.assertTrue(amazonLogo.isDisplayed());
        Assert.assertTrue(signInHeader.isDisplayed());
        Assert.assertTrue(emailPhoneNumberLabel.isDisplayed());
        Assert.assertTrue(agreementText.isDisplayed());
        Assert.assertTrue(hyperlinkNeedHelp.isDisplayed());
    }

    public void assertionCurrentPageIsSignInPage(){
        String urlSignIn = "https://www.amazon.com/ap/signin";
        int maxWait = 5;
        while(!getDriver().getCurrentUrl().contains(urlSignIn)){
            try{Thread.sleep(1000);} catch (InterruptedException e){}
            maxWait--;
        }

        if(maxWait==0) Assert.fail();
    }

    public void assertionErrorSignIn(String headerAlert, String wordingAlert){
        waitingForPresenceOfElement(headerAlertErrorLogin,5000,100);
        waitingForPresenceOfElement(wordingAlertErrorLogin,5000,100);

        Assert.assertTrue(headerAlertErrorLogin.isDisplayed());
        Assert.assertTrue(wordingAlertErrorLogin.isDisplayed());
        Assert.assertTrue(getText(headerAlertErrorLogin,5).contains(headerAlert));
        Assert.assertTrue(getText(wordingAlertErrorLogin,5).contains(wordingAlert));
    }

    public void assertEmailInvalid(String msg){
        waitingForPresenceOfElement(missingEmailAlert,10000,100);

        Assert.assertTrue(missingEmailAlert.isDisplayed());
        Assert.assertTrue(getText(missingEmailAlert,4).contains(msg));
    }

    public void assertPasswordInvalid(String msg){
        waitingForPresenceOfElement(missingPasswordAlert,10000,100);

        Assert.assertTrue(missingPasswordAlert.isDisplayed());
        Assert.assertTrue(getText(missingPasswordAlert,4).contains(msg));
    }
}
