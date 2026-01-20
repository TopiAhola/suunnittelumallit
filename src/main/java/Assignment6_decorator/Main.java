package Assignment6_decorator;

public class Main {
    public static void main(String[] args) {

        Printer basicPrinter = new BasicPrinter();

        EncryptedPrinter ep = new EncryptedPrinter(basicPrinter);

        ep.print("Helloo");

    }
}
