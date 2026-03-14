package Assignment12_proxy;

import Assignment12_proxy.documents.DocumentInterface;

import java.util.*;

public class AccessControlService {

    // <Username, Set<allowed document ids> >
    HashMap<String, Set<Integer>> accessRights;

    //singleton instance
    static AccessControlService instance;

    public static AccessControlService getInstance(){
        if(instance == null) instance = new AccessControlService();
        return instance;
    }

    private AccessControlService() {
        this.accessRights = new HashMap<String, Set<Integer>>();
    }

    public boolean isAllowed(String username, int documentId){
        return accessRights.get(username) != null && accessRights.get(username).contains(documentId);
    }

    public void giveAccess(String username, int documentId){
        if (this.accessRights.get(username) == null){
            this.accessRights.put(username, new HashSet<Integer>());
            this.accessRights.get(username).add(documentId);

        } else {
            this.accessRights.get(username).add(documentId);

        }
    }

    public void removeAccess(String username, int documentId){

    }




}
