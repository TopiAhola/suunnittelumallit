package Assignment10_chain_of_responsibility;

public class ClaimHandler extends MessageHandler {


    public ClaimHandler(){
        super();
    }


    @Override
    public String handle(Message message) {
        if(message.getMessageType().equals(Message.MessageType.COMPENSATION_CLAIM)) {
            return (Math.random() > 0.5) ? "Your claim has been compensated." : "Your claim has been rejected." ;

        } else if (this.next != null) {
            return this.next.handle(message);

        } else  {
            return "Null handler in chain" ;
        }
    }





}
