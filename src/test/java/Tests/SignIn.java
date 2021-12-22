package Tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import Steps.SignInStep;

public class SignIn {
    @Steps SignInStep SignInStep;

    @Given("user membuka halaman utama Amazon")
    public void user_membuka_halaman_utama_Amazon() {
        SignInStep.user_membuka_halaman_utama_Amazon();
    }

    @When("user mengklik button account di top navigation bar")
    public void user_menekan_button_Masuk_di_pojok_kanan_atas_halaman_utama() {
        SignInStep.user_menekan_button_Masuk_di_pojok_kanan_atas_halaman_utama();
    }

    @Then("user akan diarahkan ke halaman utama login")
    public void user_akan_diarahkan_ke_halaman_utama_login(){
        SignInStep.user_akan_diarahkan_ke_halaman_utama_login();
    }

    @When("user melakukan hovering mouse ke button account di top navigation bar")
    public void user_melakukan_hovering_mouse_ke_button_account_di_top_navigation_bar(){
        SignInStep.user_melakukan_hovering_mouse_ke_button_account_di_top_navigation_bar();
    }

    @When("user mengklik button Sign In pada account nav bar")
    public void user_mengklik_button_Sign_In_pada_account_nav_bar(){
        SignInStep.user_mengklik_button_Sign_In_pada_account_nav_bar();
    }

    @When("user mengisi email field dengan email yang valid")
    public void user_mengisi_email_field_dengan_email_yang_valid(){
        SignInStep.user_mengisi_email_field_dengan_email_yang_valid();
    }

    @When("user mengklik button Continue")
    public void user_mengklik_button_Continue(){
        SignInStep.user_mengklik_button_Continue();
    }

    @When("user mengisi password field dengan password yang valid")
    public void user_mengisi_password_field_dengan_password_yang_valid(){
        SignInStep.user_mengisi_password_field_dengan_password_yang_valid();
    }

    @When("user mengisi password field dengan password yang invalid")
    public void user_mengisi_password_field_dengan_password_yang_invalid(){
        SignInStep.user_mengisi_password_field_dengan_password_yang_invalid();
    }

    @When("user mengklik button Sign In di halaman login")
    public void user_mengklik_button_Sign_In_di_halaman_login(){
        SignInStep.user_mengklik_button_SignIn();
    }

    @Then("user akan diarahkan ke home page dengan account name {string}")
    public void user_akan_diarahkan_ke_home_page(String name){
        SignInStep.user_akan_diarahkan_ke_home_page();
        SignInStep.assertionHomepageView(name);
    }

    @Then("user tetap berada di halaman Sign In isi password")
    public void user_tetap_berada_di_halaman_Sign_In_isi_password(){
        SignInStep.user_tetap_berada_di_halaman_Sign_In_isi_password();
    }

    @Then("user akan mendapatkan alert error header {string} dan pesan {string}")
    public void user_akan_mendapatkan_alert_error_header_string_dan_pesan_string(String header, String msg){
        SignInStep.user_akan_mendapatkan_alert_error_header_string_dan_pesan_string(header, msg);
    }

    @When("user membiarkan email field kosong dan tidak terisi")
    @When("user membiarkan password field kosong dan tidak terisi")
    public void user_membiarkan_email_or_password_field_kosong_dan_tidak_terisi(){
        //Nothing to do
    }

    @Then("user mendapati alert error email invalid {string}")
    public void user_mendapati_alert_error_email_invalid_string(String msg){
        SignInStep.user_mendapati_alert_error_email_invalid_string(msg);
    }

    @Then("user mendapati alert error password invalid {string}")
    public void user_mendapati_alert_error_password_invalid_string(String msg){
        SignInStep.user_mendapati_alert_error_password_invalid_string(msg);
    }
}
