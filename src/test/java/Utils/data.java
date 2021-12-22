package Utils;

public interface data extends database{
    //=============== Data Input ===============
    String user = "andjsxbp85";
    String email = "anjas@alterra.id";
    String pass = "12345678";
    String name = "Anjas Muhammad Bangun";
    String prog = "Java";
    String acc = "true";
    //============== Status Device =============
    String fileApk = "selendroid-test-app-0.11.0.apk";
    String deviceName ="AndroidAutomation";
    String deviceID = "emulator-5554";
    String packages = "io.selendroid.testapp";
    String activity = "io.selendroid.testapp.HomeScreenActivity";
    String url = "http://0.0.0.0:4723/wd/hub";
    //String url = "http://127.0.0.1:4723/wd/hub";

    //============= Elemen Awal dan Fill ============
    String buttonAwal = "android:id/button1";
    String buttDaftar = "io.selendroid.testapp:id/startUserRegistration";
    String fillUser = "io.selendroid.testapp:id/inputUsername";
    String fillEmail = "io.selendroid.testapp:id/inputEmail";
    String fillPass="io.selendroid.testapp:id/inputPassword";
    String fillName ="io.selendroid.testapp:id/inputName";
    String selProg = "io.selendroid.testapp:id/input_preferedProgrammingLanguage";
    String pickProg = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"";
    String boxAcc = "io.selendroid.testapp:id/input_adds";
    String buttRegis = "io.selendroid.testapp:id/btnRegisterUser";
    //============== Akhir Validasi ==============
    String boxRegister = "io.selendroid.testapp:id/buttonRegisterUser";
    String validName = "io.selendroid.testapp:id/label_name_data";
    String validUser ="io.selendroid.testapp:id/label_username_data";
    String validPass = "io.selendroid.testapp:id/label_password_data";
    String validEmail = "io.selendroid.testapp:id/label_email_data";
    String validProg = "io.selendroid.testapp:id/label_preferedProgrammingLanguage_data";
    String validAcc = "io.selendroid.testapp:id/label_acceptAdds_data";
    //========== Pesan Error =============
    String errName = "Nama Tidak Sesuai";
    String errUser = "Username Tidak Sesuai";
    String errPass = "Password Tidak Sesuai";
    String errMail = "Email Tidak Sesuai";
    String errProg = "Bahasa Pemrograman Tidak Sesuai";
    String errAcc = "User Tidak Menyetujui Kebijakan";
}
