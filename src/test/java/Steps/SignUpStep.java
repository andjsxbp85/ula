package Steps;

import Pages.SignInPage;
import Pages.SignUpPage;

public class SignUpStep {
    Pages.SignInPage SignInPage;
    Pages.SignUpPage SignUpPage;

    public void user_mengklik_button_Create_your_Amazon_account(){
        SignInPage.clickButtonCreateAmazonAccount();
    }

    public void user_akan_diarahkan_ke_halaman_utama_sign_up(boolean initialLoadPage){
        SignUpPage.assertionCurrentPageIsSignInPage();
        SignUpPage.assertionSignUpPageView(initialLoadPage);
    }

    public void userMengisiSignUpForm(String fullName, String email, String password, String rePassword, Boolean clickButtonContinue){
        if(fullName!="") SignUpPage.inputFullName(fullName);
        if(email!="") SignUpPage.inputEmail(email);
        if(password!="") SignUpPage.inputPassword(password);
        if(rePassword!="") SignUpPage.inputRePassword(rePassword);
        if(clickButtonContinue) SignUpPage.clickButtonContinue();
    }

    public void assertionAlertWarnMessage(String msg){
        SignUpPage.assertionAlertWarnMessage(msg);
    }

    public void assertionAlertInvalidInputFiled(String errName, String errEmail, String errPass, String errRePass){
        if(errName!="") SignUpPage.assertionAlertInvalidName(errName);
        if(errEmail!="") SignUpPage.assertionAlertInvalidEmail(errEmail);
        if(errPass!="") SignUpPage.assertionAlertInvalidPassword(errPass);
        if(errRePass!="") SignUpPage.assertionAlertInvalidRePassword(errRePass);
    }

    public void assertionCurrentPageIsVerificationPage(){
        SignUpPage.assertionCurrentPageIsVerificationPage();
    }
}
