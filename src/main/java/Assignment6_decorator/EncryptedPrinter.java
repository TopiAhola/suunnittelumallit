package Assignment6_decorator;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.datatype.DatatypeFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import static javax.crypto.Cipher.ENCRYPT_MODE;
import static javax.crypto.Cipher.DECRYPT_MODE;


public class EncryptedPrinter extends PrinterDecorator{

    private SecretKey secretKey;

    public EncryptedPrinter(Printer printer){
        super(printer);
        try {
            SecureRandom secureRandom = new SecureRandom();
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, secureRandom);
            this.secretKey = keyGenerator.generateKey();

            /*//print key
            String encodedKey = Base64.getEncoder().encodeToString(this.secretKey.getEncoded());
            System.out.println("Encrypted printer has key: "+encodedKey );*/

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void print(String message){
        try {
            //initialize cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(ENCRYPT_MODE, this.secretKey);
            //convert String to byte[] then encrypt
            byte[] cryptedByteArray = cipher.doFinal(message.getBytes());
            //encode to String for printing
            String cryptedText = Base64.getEncoder().encodeToString(cryptedByteArray);

            this.printer.print( cryptedText );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String decrypt(String encryptedText) {
        try {

            //print key
            String encodedKey = Base64.getEncoder().encodeToString(this.secretKey.getEncoded());
            System.out.println("Encrypted printer has key: "+encodedKey );

            //test decryption
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(DECRYPT_MODE, this.secretKey);
            byte[] plainTextByteArray = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            return new String(plainTextByteArray);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
