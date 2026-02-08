package Assignment10_chain_of_responsibility;

public class SuggestionHandler extends MessageHandler {

    public SuggestionHandler() {
        super();
    }

    @Override
    public String handle(Message message) {
        if(message.getMessageType().equals(Message.MessageType.DEVELOPMENT_SUGGESTION)) {
            return "Thank you for your feedback." ;

        } else if (this.next != null) {
            return this.next.handle(message);

        } else  {
            return "Null handler in chain" ;
        }
    }


}