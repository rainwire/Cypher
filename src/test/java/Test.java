/**
 * Created by adlerd on 3/2/17.
 */

import static java.lang.System.err;

import com.cypher.encryption.CryptoImplementation;
import com.cypher.encryption.KeyFile;

@SuppressWarnings("Duplicates")
public class Test {
    private static KeyFile keyFile;
    private static CryptoImplementation cryptoImpl;
    private static final String password = "1234567812345678";
    private static final String salt = "wTmg4qj8dNszs2ji";
    private static final String str = "test";
    private static final String a = null;


    private static String encrypted;
    private static String temp;

    public static void main(String... args) throws Exception {

        testStringEncrypt();
        testStringDecrypt();
    }

    // TEST ENCRYPTION
    private static void testStringEncrypt() throws Exception{
        cryptoImpl = new CryptoImplementation(str);
        keyFile = new KeyFile(password, 1);
//        keyFile.setSalt(salt);
        encrypted = cryptoImpl.encryptString(keyFile);

        err.printf("%n[DEBUG] <Test> Encrypted String: %s%n", encrypted);
    }

    // TEST DECRYPTION
    private static void testStringDecrypt() throws Exception{
        String decrypted = cryptoImpl.decryptString(encrypted, keyFile);

        err.printf("%n[DEBUG] <Test> Decrypted String: %s%n", decrypted);
    }
}
