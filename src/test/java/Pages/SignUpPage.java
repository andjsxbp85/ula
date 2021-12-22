package Pages;

import Utils.WebExe;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends WebExe {
    @FindBy(css="#ap_customer_name") WebElement iptFullName;
    @FindBy(css="#ap_email") WebElement iptEmail;
    @FindBy(css="#ap_password") WebElement iptPassword;
    @FindBy(css="#ap_password_check") WebElement iptReEnterPassword;
    @FindBy(css="input#continue") WebElement btnContinue;
    @FindBy(css="i.a-icon.a-icon-logo[aria-label='Amazon']") WebElement imgAmazonLogo;
    @FindBy(css="#ap_register_form h1") WebElement hdrCreateAccount;
    @FindBy(css="label[for='ap_customer_name']") WebElement lblFullName;
    @FindBy(css="label[for='ap_email']") WebElement lblEmail;
    @FindBy(css="label[for='ap_password']") WebElement lblPassword;
    @FindBy(css="label[for='ap_password_check']") WebElement lblReEnterPassword;
    @FindBy(xpath="//*[@id='ap_password']/parent::div//*[contains(text(),'Passwords must be at least 6 characters')]") WebElement txtInitialPassAlert;
    @FindBy(css="#authportal-main-section .a-alert-warning.a-spacing-base h4") WebElement hdrAlertMessage;
    @FindBy(css="#auth-customerName-missing-alert .a-alert-content") WebElement txtAlertInvalidName;
    @FindBy(xpath="//*[@id='ap_email']/ancestor::div[2]//*[@role='alert' and @style='display: block;']") WebElement txtAlertInvalidEmail;
    @FindBy(xpath="//*[@id='ap_password']/ancestor::div[2]//*[@role='alert' and @style='display: block;']") WebElement txtAlertInvalidPass;
    @FindBy(xpath="//*[@id='ap_password_check']/ancestor::div[1]//*[@role='alert' and @style='display: block;']") WebElement txtAlertInvalidRePassword;

    public void inputFullName(String fullName){
        waitingForPresenceOfElement(iptFullName,5000,100);
        sendKeys(iptFullName, fullName, 5);
    }

    public void inputEmail(String email){
        waitingForPresenceOfElement(iptEmail,5000,100);
        sendKeys(iptEmail, email, 5);
    }

    public void inputPassword(String password){
        waitingForPresenceOfElement(iptPassword,5000,100);
        sendKeys(iptPassword, password, 5);
    }

    public void inputRePassword(String rePassword){
        waitingForPresenceOfElement(iptReEnterPassword,5000,100);
        sendKeys(iptReEnterPassword, rePassword, 5);
    }

    public void clickButtonContinue(){
        waitingForPresenceOfElement(btnContinue,5000,100);
        click(btnContinue, 5);
    }

    public void assertionCurrentPageIsSignInPage(){
        String urlSignUp = "www.amazon.com/ap/register";
        int maxWait = 5;
        while(!getDriver().getCurrentUrl().contains(urlSignUp)){
            try{Thread.sleep(1000);} catch (InterruptedException e){}
            maxWait--;
        }

        if(maxWait==0) Assert.fail();
    }

    public void assertionCurrentPageIsVerificationPage(){
        String urlSignUp = "www.amazon.com/ap/cvf/request";
        int maxWait = 8;
        while(!getDriver().getCurrentUrl().contains(urlSignUp)){
            try{Thread.sleep(1000);} catch (InterruptedException e){}
            maxWait--;
        }

        if(maxWait==0) Assert.fail();
    }

    public void assertionSignUpPageView(boolean... initialLoadPage){
        waitingForPresenceOfElement(iptFullName,5000,100);
        waitingForPresenceOfElement(iptEmail,5000,100);
        waitingForPresenceOfElement(iptPassword,5000,100);
        waitingForPresenceOfElement(iptReEnterPassword,5000,100);
        waitingForPresenceOfElement(btnContinue,5000,100);

        Assert.assertTrue(iptFullName.isDisplayed());
        Assert.assertTrue(iptEmail.isDisplayed());
        Assert.assertTrue(iptPassword.isDisplayed());
        Assert.assertTrue(iptReEnterPassword.isDisplayed());
        Assert.assertTrue(btnContinue.isDisplayed());
        Assert.assertTrue(imgAmazonLogo.isDisplayed());
        Assert.assertTrue(hdrCreateAccount.isDisplayed());
        Assert.assertTrue(lblFullName.isDisplayed());
        Assert.assertTrue(lblEmail.isDisplayed());
        Assert.assertTrue(lblPassword.isDisplayed());
        Assert.assertTrue(lblReEnterPassword.isDisplayed());
        if(initialLoadPage[0]) Assert.assertTrue(txtInitialPassAlert.isDisplayed());
    }

    public void assertionAlertWarnMessage(String msg){
        waitingForPresenceOfElement(hdrAlertMessage, 10000,100);
        Assert.assertTrue(hdrAlertMessage.isDisplayed());
        Assert.assertTrue(getText(hdrAlertMessage,5).equals(msg));
    }

    public void assertionAlertInvalidName(String msg){
        waitUntilVisible(txtAlertInvalidName, 10000,100);
        Assert.assertTrue(txtAlertInvalidName.isDisplayed());
        Assert.assertTrue(getText(txtAlertInvalidName,5).contains(msg));
    }

    public void assertionAlertInvalidEmail(String msg){
        waitUntilVisible(txtAlertInvalidEmail, 10000,100);
        Assert.assertTrue(txtAlertInvalidEmail.isDisplayed());
        Assert.assertTrue(getText(txtAlertInvalidEmail,5).contains(msg));
    }

    public void assertionAlertInvalidPassword(String msg){
        waitUntilVisible(txtAlertInvalidPass, 10000,100);
        Assert.assertTrue(txtAlertInvalidPass.isDisplayed());
        Assert.assertTrue(getText(txtAlertInvalidPass,5).contains(msg));
    }

    public void assertionAlertInvalidRePassword(String msg){
        waitUntilVisible(txtAlertInvalidRePassword, 10000,100);
        Assert.assertTrue(txtAlertInvalidRePassword.isDisplayed());
        Assert.assertTrue(getText(txtAlertInvalidRePassword,5).contains(msg));
    }
}
