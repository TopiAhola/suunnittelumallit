package Assignment10_chain_of_responsibility;



public class MessageHandler implements HandlerInterface {

    MessageHandler next;

    public MessageHandler(){
    }

    public String handle(Message message){
        return "Handle is not implemented";
    };

    public MessageHandler getNext(){
        return next;
    };

    public void setNext(MessageHandler next){
        this.next = next;
    };


}
