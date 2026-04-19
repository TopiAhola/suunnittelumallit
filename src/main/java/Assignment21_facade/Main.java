package Assignment21_facade;


import java.io.IOException;

/**
 * The method should send a HTTP GET request to the given URL, retrieve the JSON response, and extract the value of the given attribute name from the JSON.
 *
 * Should the URL be invalid or the HTTP request fail, the method should throw an IOException.
 *
 * If the attribute is not found, the method should throw an IllegalArgumentException. If there are multiple attributes with the same name, the method should return the value of the first one found.
 *
 * Finally, demonstrate that the Chuck Norris joke can still be retrieved using your facade. Also, show how the facade works with another API of your choice (e.g. https://api.fxratesapi.com/latest for the latest foreign exchange rates).
 */
public class Main{
    public static void main(String[] args) {

        Facade facade = new Facade();
        try {
            String result = facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "value"
            );
            System.out.println(result);


        } catch (IOException e) {
            System.out.println("URL is invalid or the HTTP request failed");

        } catch (IllegalArgumentException e2) {
            System.out.println("Attribute not found in JSON");

        } catch (Exception e3) {
            e3.printStackTrace();
        }

        //https://api.fxratesapi.com/latest
        try {
            String result = facade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest",
                    "EUR"
            );
            System.out.printf("Rate of USD to EUR: %s", result);


        } catch (IOException e) {
            System.out.println("URL is invalid or the HTTP request failed");

        } catch (IllegalArgumentException e2) {
            System.out.println("Attribute not found in JSON");

        } catch (Exception e3) {
            e3.printStackTrace();
        }

    }
}