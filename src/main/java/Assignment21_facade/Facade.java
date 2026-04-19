package Assignment21_facade;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


/**
 * The method should send a HTTP GET request to the given URL, retrieve the JSON response, and extract the value of the given attribute name from the JSON.
 *
 * Should the URL be invalid or the HTTP request fail, the method should throw an IOException.
 *
 * If the attribute is not found, the method should throw an IllegalArgumentException. If there are multiple attributes with the same name, the method should return the value of the first one found.
 *
 * Finally, demonstrate that the Chuck Norris joke can still be retrieved using your facade. Also, show how the facade works with another API of your choice (e.g. https://api.fxratesapi.com/latest for the latest foreign exchange rates).
 */
public class Facade {


    private JokeClient jokeClient;

    public Facade(){
    }


    String getAttributeValueFromJson(String urlString, String attributeName) throws Exception {
        String jsonResult = getJsonFromApi(urlString);
        System.out.println(jsonResult);
        return extractAttributeFromJson(jsonResult,attributeName);
    };


    private String getJsonFromApi(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }



    private String extractAttributeFromJson(String json, String attribute) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String, Object>>(){} );
        //System.out.println(map);

        //recursive flat mapper
        Map<String, String> flatKeyMap = recursiveFlatten(map);

        return flatKeyMap.getOrDefault(attribute, "attribute not found...");
    }

     public Map<String,String> recursiveFlatten(Map<String,Object> map){
        Map<String,String> returnMap = new HashMap<>();
        for(String key : map.keySet()) {
            //if more child maps
            if ( map.get(key) instanceof Map ) {
                //flatten then return
                returnMap.putAll(recursiveFlatten( (Map<String, Object>) map.get(key) ));

            } else  {
                returnMap.put(key ,map.get(key).toString() );
            }
        }
        return returnMap;
    }


}
