package Assignment19_mediator;

import java.util.Date;

public class Message {
    String receiver;
    String sender;
    String message;
    Date sent;
    Date received;

    public Message(String receiver, String sender, String message) {
        this.receiver = receiver;
        this.sender = sender;
        this.message = message;
        this.sent = new Date();
    }

    @Override
    public String toString(){
        return String.format("To: %s From: %s Message: %s - %s - %s",receiver,sender,message,sent,received);
    }
}
