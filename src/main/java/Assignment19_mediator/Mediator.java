package Assignment19_mediator;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Mediator extends Application{

    Map<String,Client> clients;

    @Override
    public void start(Stage stage) throws Exception {

        clients = new HashMap<>(Map.of(
               "Client1", new Client("Client1", this),
                "Client2", new Client("Client2", this),
                "Client3", new Client("Client3", this)

        ));

        for (Client c : clients.values() ) {

        }

    }

    public boolean relayMessage(Message message){
        if (clients.containsKey(message.receiver)){
            return clients.get(message.receiver).receiveMessage(message);

        } else {
            return false;
        }

    }



}
