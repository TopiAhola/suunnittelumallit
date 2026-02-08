package Assignment10_chain_of_responsibility;

import static Assignment10_chain_of_responsibility.Message.MessageType.*;


public class Main {
    public static void main(String[] args) {

        //create handlers
        MessageHandler claimHandler = new ClaimHandler();
        MessageHandler requestHandler = new RequestHandler();
        MessageHandler suggestionHandler = new SuggestionHandler();
        MessageHandler feedBackHandler = new FeedbackHandler();

        //chain handlers
        claimHandler.setNext(requestHandler);
        requestHandler.setNext(suggestionHandler);
        suggestionHandler.setNext(feedBackHandler);


        //create messages
        Message[] messages = new Message[]{
                new Message(COMPENSATION_CLAIM,"Give money back!","Arg@angry.com"),
                new Message(CONTACT_REQUEST,"Call me sometime, ok?","Nophonenumber@?.fi"),
                new Message(DEVELOPMENT_SUGGESTION,"Delete your program.", "Email@email.com"),
                new Message(GENERAL_FEEDBACK,"I have nothing to say!!!!!","Somebody@somewhere.com"),
                new Message(COMPENSATION_CLAIM, "Product ruined my life.","Help@email.com")
        };

        //test handling for messages
        System.out.println("Tests:");
        for (Message message : messages) {
            System.out.println("Message: "+ message.getMessageContent());
            System.out.println("Response: "+claimHandler.handle(message));
        }

       /* //test setting next handler to null
        claimHandler.setNext(null);
        System.out.println("\n\nTests with broken chain:");
        for (Message message : messages) {
            System.out.println("Message: "+ message.getMessageContent());
            System.out.println("Response: "+claimHandler.handle(message));
        }*/

    }
}
