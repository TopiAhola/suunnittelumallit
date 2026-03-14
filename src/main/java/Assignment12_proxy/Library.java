package Assignment12_proxy;

import Assignment12_proxy.documents.Document;
import Assignment12_proxy.documents.DocumentInterface;
import Assignment12_proxy.documents.DocumentProxy;

import java.util.HashMap;

public class Library {

    private HashMap<Integer, DocumentInterface> documents;

    public Library(){
        this.documents = new HashMap<Integer, DocumentInterface>();
    }



    public int newDocument(String content, boolean isProtected){
        //get free id
        int highestId = documents.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);

        if(isProtected) {
            Document realDocument = new Document(highestId + 1, content);
            DocumentInterface proxyDocument = new DocumentProxy(realDocument);

            documents.put(realDocument.id, proxyDocument);
            return proxyDocument.getId();

        } else {
            Document realDocument = new Document(highestId + 1, content);

            documents.put(realDocument.id, realDocument);
            return  realDocument.getId();
        }
    }

    public DocumentInterface get(int id){
        return documents.get(id);
    }

}
