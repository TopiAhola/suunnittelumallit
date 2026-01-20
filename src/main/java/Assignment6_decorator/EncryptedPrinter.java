package Assignment6_decorator;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.datatype.DatatypeFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptedPrinter extends PrinterDecorator{

    private SecretKey secretKey;

    public EncryptedPrinter(Printer printer){
        super(printer);
        try {
            SecureRandom secureRandom = new SecureRandom();
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, secureRandom);
            this.secretKey = keyGenerator.generateKey();

            //print key
            String encodedKey = Base64.getEncoder().encodeToString(this.secretKey.getEncoded());
            System.out.println("Encrypted printer has key: "+encodedKey );

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void print(String message){

    }

}
