package Assignment12_proxy;

import Assignment12_proxy.documents.Document;
import Assignment12_proxy.documents.DocumentInterface;

import java.util.HashMap;

public class Library {

    private HashMap<Integer, DocumentInterface> documents;

    public int newDocument(String content, boolean isProtected){
        //get free id
        int highestId = documents.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);

        DocumentInterface realDocument = new Document(highestId+1, content);

    }

}
