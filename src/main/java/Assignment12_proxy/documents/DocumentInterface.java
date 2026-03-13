package Assignment12_proxy.documents;

import Assignment12_proxy.AccessDeniedException;
import Assignment12_proxy.User;

import java.util.Date;

public interface DocumentInterface {
        public int getId() ;
        public Date getCreationDate() ;
        public String getContent(User user) throws AccessDeniedException;
}
