package Assignment10_chain_of_responsibility;

public class FeedbackHandler extends MessageHandler {

    public FeedbackHandler() {
        super();
    }

    @Override
    public String handle(Message message) {
        if(message.getMessageType().equals(Message.MessageType.GENERAL_FEEDBACK)) {
            return "Thank you for your feedback." ;

        } else if (this.next != null) {
            return this.next.handle(message);

        } else  {
            return "Null handler in chain" ;
        }
    }

}