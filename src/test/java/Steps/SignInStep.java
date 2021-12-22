package Steps;

import org.apache.commons.lang3.RandomStringUtils;

public class SignInStep {
    Pages.HomePage HomePage;
    Pages.SignInPage SignInPage;

    public void user_membuka_halaman_utama_Amazon(){
        HomePage.open();
    }

    public void user_menekan_button_Masuk_di_pojok_kanan_atas_halaman_utama(){
        HomePage.clickAccountNavBar();
    }

    public void user_akan_diarahkan_ke_halaman_utama_login(){
        SignInPage.assertLoginPageView();
    }

    public void user_melakukan_hover_mouse_ke_account_nav_bar(){
        HomePage.hoveringMouseToAccountNavBar();
    }

    public void user_mengklik_button_Sign_In(){
        HomePage.clickButtonSignInFromDropDownAccountNavBar();
    }

    public void user_melakukan_hovering_mouse_ke_button_account_di_top_navigation_bar(){
        HomePage.hoveringMouseToAccountNavBar();
    }

    public void user_mengklik_button_Sign_In_pada_account_nav_bar(){
        HomePage.clickButtonSignInFromDropDownAccountNavBar();
    }

    public void user_mengisi_email_field_dengan_email_yang_valid(){
        String email = System.getenv("valid_email");
        SignInPage.inputEmailOrPhonenumberUser(email);
    }

    public void user_mengklik_button_Continue(){
        SignInPage.clickButtonContinue();
    }

    public void user_mengisi_password_field_dengan_password_yang_valid(){
        String password = System.getenv("valid_password");
        SignInPage.inputPasswordUser(password);
    }

    public void user_mengisi_password_field_dengan_password_yang_invalid(){
        String randomPassword = RandomStringUtils.random(15, true, true);
        SignInPage.inputPasswordUser(randomPassword);
    }

    public void user_mengklik_button_SignIn(){
        SignInPage.clickButtonSignIn();
    }

    public void user_akan_diarahkan_ke_home_page(){
        HomePage.assertionCurrentPageIsHomePage();
    }

    public void assertionHomepageView(String name){
        HomePage.assertionHomepageView(name);
    }

    public void user_tetap_berada_di_halaman_Sign_In_isi_password(){
        SignInPage.assertionCurrentPageIsSignInPage();
    }

    public void user_akan_mendapatkan_alert_error_header_string_dan_pesan_string(String header, String msg){
        SignInPage.assertionErrorSignIn(header, msg);
    }

    public void user_mendapati_alert_error_email_invalid_string(String msg){
        SignInPage.assertEmailInvalid(msg);
    }

    public void user_mendapati_alert_error_password_invalid_string(String msg){
        SignInPage.assertPasswordInvalid(msg);
    }
}
