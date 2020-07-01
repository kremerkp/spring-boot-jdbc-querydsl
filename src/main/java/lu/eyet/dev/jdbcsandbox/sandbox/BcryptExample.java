package lu.eyet.dev.jdbcsandbox.sandbox;

import org.mindrot.jbcrypt.BCrypt;

public class BcryptExample {

    public static void main(String args[]) {
        String psw = BCrypt.hashpw("myPassword", BCrypt.gensalt());
        System.out.println(psw);
        Boolean isValid = BCrypt.checkpw("mySecretPassword", psw);
        System.out.println(isValid);
        psw = BCrypt.hashpw("mySecretPassword", BCrypt.gensalt(12));
        System.out.println(psw);
        isValid = BCrypt.checkpw("mySecretPassword", psw);
        System.out.println(isValid);
    }

}