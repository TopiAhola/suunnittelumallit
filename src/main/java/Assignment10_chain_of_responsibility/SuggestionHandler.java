package Assignment10_chain_of_responsibility;

public class SuggestionHandler extends MessageHandler {

    public SuggestionHandler() {
        super();
    }

    @Override
    public String handle(Message message) {
        if(message.getMessageType().equals(Message.MessageType.DEVELOPMENT_SUGGESTION)) {
            return "We will consider your suggestion to: " +message.getMessageContent() ;

        } else if (this.next != null) {
            return this.next.handle(message);

        } else  {
            return "Null handler in chain" ;
        }
    }


}