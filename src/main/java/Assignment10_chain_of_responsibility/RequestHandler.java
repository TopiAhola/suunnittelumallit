package Assignment10_chain_of_responsibility;

public class RequestHandler extends MessageHandler {

       public RequestHandler(){
        super();
    }


    @Override
    public String handle(Message message) {
        if(message.getMessageType().equals(Message.MessageType.CONTACT_REQUEST)) {
            return "Our representative will contact you shortly." ;

        } else if (this.next != null) {
            return this.next.handle(message);

        } else  {
            return "Null handler in chain" ;
        }
    }
}