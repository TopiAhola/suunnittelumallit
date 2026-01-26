package Assignment6_decorator;

public class Main {
    public static void main(String[] args) {

        Printer basicPrinter = new BasicPrinter();
        XMLPrinter xmlPrinter = new XMLPrinter(basicPrinter);
        CapitalPrinter capitalPrinter = new CapitalPrinter(xmlPrinter);
        EncryptedPrinter encryptedPrinter = new EncryptedPrinter(capitalPrinter);
        encryptedPrinter.print("Helloo");


        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");



    }
}
