package Utils;

public interface database {
    //URL
    String _mainURL = "https://www.amazon.com/";

    //SSH & DB Credential
    //SSH
    String _sshHost = "xxx.xxx.xxx.xxx";
    String _sshUser = "xxxxx";
    String _sshSudoPass = "xxxxx";
    String _sshKeyPath = "src/test/resources/lib/id_rsa";
    String _sshProdUser = "xxx";
    int _sshProdPort = 1234;
    String _sshProdHost = "xxx.xxx.xxx.xxx";
    //DB
    String _dbHost = "xx.xxx.xx.xxx";
    int _dbPort = 3306;
    String _dbUser = "xxxxx";
    String _dbPass = "xxxxx";
    String _dbName = "xxxxx";
    String _dbDriverName = "com.mysql.jdbc.Driver";
}
