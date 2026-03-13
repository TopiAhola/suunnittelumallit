package Assignment12_proxy.documents;

import Assignment12_proxy.AccessControlService;
import Assignment12_proxy.AccessDeniedException;
import Assignment12_proxy.User;

import java.util.Date;

public class DocumentProxy implements DocumentInterface {
    private Document realDocument;

    public String getContent(User user) throws AccessDeniedException {
        if (AccessControlService.getInstance().isAllowed(user.getUsername(), realDocument.id)) {
            return realDocument.content;

        } else {
            throw new AccessDeniedException("User " + user.getUsername() + " not allowed to access document " + realDocument.getId());

        }

    }

    @Override
    public int getId() {
        return realDocument.id;
    }

    @Override
    public Date getCreationDate() {
        return realDocument.creationDate;
    }




}
