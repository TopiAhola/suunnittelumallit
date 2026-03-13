package Assignment12_proxy.documents;

import Assignment12_proxy.AccessDeniedException;
import Assignment12_proxy.User;

import java.util.Date;

public class Document implements DocumentInterface {
    public int id;
    public Date creationDate;
    protected String content;
    boolean isProtected;

    public Document(int id, String content) {
        this.id = id;
        this.creationDate = new Date();
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getContent(User user) throws AccessDeniedException {
        if ( isProtected ) {
            throw new AccessDeniedException("Attempt to access content past proxy!");

        } else {
            return content;
        }
    }
}
