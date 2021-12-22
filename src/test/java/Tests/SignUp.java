package Tests;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import Steps.SignUpStep;
import org.apache.commons.lang3.RandomStringUtils;

public class SignUp {
    @Steps SignUpStep SignUpStep;

    @When("user mengklik button 'Create your Amazon account'")
    public void user_mengklik_button_Create_your_Amazon_account(){
        SignUpStep.user_mengklik_button_Create_your_Amazon_account();
    }

    @When("user mengisi email field dengan email yang telah terdaftar")
    public void user_mengisi_email_field_dengan_email_yang_telah_terdaftar(){
        String name = RandomStringUtils.random(15,true,false);
        String existingEmail = System.getenv("valid_email");
        String existingPassword = System.getenv("valid_password");
        SignUpStep.userMengisiSignUpForm(name, existingEmail, existingPassword, existingPassword, true);
    }

    @When("user membiarkan seluruh field pada form sign up kosong dan mengklik button \"Continue\"")
    public void user_membiarkan_seluruh_field_pada_form_sign_up_kosong_dan_mengklik_button_Continue(){
        SignUpStep.userMengisiSignUpForm("", "", "", "", true);
    }

    @When("user membiarkan field {} pada halaman sign up kosong")
    public void user_membiarkan_field_the_only_one_empty_field_pada_halaman_sign_up_kosong(String field){
        String name = field.toLowerCase().contains("name") ? "" : RandomStringUtils.random(15,true,false);
        String email = field.toLowerCase().contains("email") ? "" : "newmail"+RandomStringUtils.random(8,true,true)+"@gmail.com";
        String password = field.toLowerCase().contains("password") ? "" : RandomStringUtils.random(15,true,false);
        String rePassword = field.toLowerCase().contains("re-enter pass") ? "" : (password.equals("")? RandomStringUtils.random(15,true,false) : password);
        SignUpStep.userMengisiSignUpForm(name, email, password, rePassword, true);
    }

    @When("user mengisi field re-enter password yang berbeda dengan field password")
    public void user_mengisi_field_re_enter_password_yang_berbeda_dengan_field_password(){
        String name = RandomStringUtils.random(15,true,false);
        String email = RandomStringUtils.random(8,true,true)+"@gmail.com";
        String password = RandomStringUtils.random(15,true,false);
        String rePassword = RandomStringUtils.random(10,true,false);

        SignUpStep.userMengisiSignUpForm(name, email, password, rePassword, true);
    }

    @When("user mengisi email dengan format yang invalid")
    public void user_mengisi_email_dengan_format_yang_invalid(){
        String name = RandomStringUtils.random(15,true,false);
        String email = RandomStringUtils.random(8,true,true);
        String password = RandomStringUtils.random(15,true,false);
        String rePassword = password;

        SignUpStep.userMengisiSignUpForm(name, email, password, rePassword, true);
    }

    @When("user mengisi seluruh field sign up form dengan benar dan sesuai")
    public void user_mengisi_seluruh_field_sign_up_form_dengan_benar_dan_sesuai(){
        String name = RandomStringUtils.random(15,true,false);
        String email = RandomStringUtils.random(8,true,true)+"@gmail.com";
        String password = RandomStringUtils.random(15,true,false);
        String rePassword = password;

        SignUpStep.userMengisiSignUpForm(name, email, password, rePassword, true);
    }

    @Then("user akan diarahkan ke halaman utama sign up")
    public void user_akan_diarahkan_ke_halaman_utama_sign_up(){
        SignUpStep.user_akan_diarahkan_ke_halaman_utama_sign_up(true);
    }

    @Then("user akan mendapatkan pesan kegagalan sign up {string}")
    public void user_akan_mendapatkan_pesan_kegagalan_sign_up_string(String msg){
        SignUpStep.assertionAlertWarnMessage(msg);
    }

    @Then("user tetap berada di halaman Sign Up")
    public void user_tetap_berada_di_halaman_Sign_Up(){
        SignUpStep.user_akan_diarahkan_ke_halaman_utama_sign_up(false);
    }

    @Then("seluruh alert error tiap field pada halaman sign up ditampilkan")
    public void seluruh_alert_error_tiap_field_pada_halaman_sign_up_ditampilkan(){
        SignUpStep.assertionAlertInvalidInputFiled("Enter your name","Enter your email or mobile phone number","Minimum 6 characters required","");
    }

    @Then("alert error pada halaman sign up untuk field {} akan ditampilkan")
    public void alert_error_pada_halaman_sign_up_untuk_field_the_only_one_empty_field_akan_ditampilkan(String field){
        String errName = field.toLowerCase().contains("name") ? "Enter your name" : "";
        String errEmail = field.toLowerCase().contains("email") ? "Enter your email or mobile phone number" : "";
        errEmail = field.toLowerCase().contains("wrong format") ? "Wrong or Invalid email address or mobile phone number. Please correct and try again." : errEmail;
        String errPass = field.toLowerCase().contains("password") ? "Enter your password" : "";
        String errRePass = field.toLowerCase().contains("re-enter pass empty") ? "Type your password again" : "";
        errRePass = field.toLowerCase().contains("unmatch") ? "Passwords must match" : errRePass;

        SignUpStep.assertionAlertInvalidInputFiled(errName,errEmail,errPass,errRePass);
    }

    @Then("user diarahkan ke halaman verifikasi email")
    public void  user_diarahkan_ke_halaman_verifikasi_email(){
        SignUpStep.assertionCurrentPageIsVerificationPage();
    }
}
