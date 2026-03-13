package Assignment12_proxy;

import Assignment12_proxy.documents.DocumentInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AccessControlService {

    // <Username, Set<allowed document ids> >
    HashMap<String, Set<Integer>> accessRights;

    //singleton instance
    static AccessControlService instance;

    public static AccessControlService getInstance(){
        return instance;
    }

    private AccessControlService() {
        this.accessRights = new HashMap<String, Set<Integer>>();
    }

    public boolean isAllowed(String username, int documentId){
        return accessRights.get(username).contains(documentId);
    }

    public void giveAccess(String username, int documentId){

    }

    public void removeAccess(String username, int documentId){

    }




}
