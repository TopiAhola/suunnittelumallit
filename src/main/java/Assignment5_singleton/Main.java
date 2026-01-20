package Assignment5_singleton;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();

        logger.write("Rivi 1");
        logger.write("Rivi 2");
        logger.setFileName("Uusi tiedosto.txt");
        logger.write("Uusi rivi 1");
        logger.write("Uusi rivi 2");
        logger.close();


    }
}
