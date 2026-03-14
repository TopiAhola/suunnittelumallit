package Assignment12_proxy;

import Assignment12_proxy.documents.DocumentInterface;

public class Main {
    public static void main(String[] args) {


        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        //add unprotected documents
        int[] documentIds = new int[10];
        for (int i = 1; i < 11; i++) {
            documentIds[i-1] = library.newDocument("Text " + i, false);
        }

        //add protected documents
        int[] protectedDocumentIds = new int[10];
        for (int i = 1; i < 11; i++) {
            protectedDocumentIds[i-1] = library.newDocument("Protected Text " + i, true);
        }

        //make users
        User user1 = new User("user1");
        User user2 = new User("user2");

        //user1 can access protected documents that have even id number
        for (int id : protectedDocumentIds) {
            if(id % 2 == 0) acs.giveAccess(user1.getUsername(), id);
        }

        //user2 can access all protected documents
        for (int id : protectedDocumentIds) {
            acs.giveAccess(user2.getUsername(), id);
        }

        //try accessing documents with user 1 this should throw exceptions
        for (int i : documentIds) {
            try {
                System.out.println(library.get(i).getContent(user1));
            } catch (AccessDeniedException e) {
                System.out.println("Exception message: " +e.getMessage());
            }

        }
        for (int i : protectedDocumentIds) {
            try {
                System.out.println(library.get(i).getContent(user1));
            } catch (AccessDeniedException e) {
                System.out.println("Exception message: " + e.getMessage());
            }
        }

        //try accessing documents with user 2
        for (int i : documentIds) {
            try {
                System.out.println(library.get(i).getContent(user2));
            } catch (AccessDeniedException e) {
                System.out.println("Exception message: " +e.getMessage());
            }

        }
        for (int i : protectedDocumentIds) {
            try {
                System.out.println(library.get(i).getContent(user2));
            } catch (AccessDeniedException e) {
                System.out.println("Exception message: " +e.getMessage());
            }
        }



    }
}
