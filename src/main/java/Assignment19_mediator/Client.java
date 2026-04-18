package Assignment19_mediator;


import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;

/**
 * Within the window, there should be:
 *
 * a text area that displays all messages sent and received by the user, together with the username of the sender/recipient.
 * a text field where the user can type a message to send to other users.
 * a text field or other component that allows the user to select the recipient of the message.
 * a button that sends the message to the selected recipient.
 */
public class Client extends Application {



    String name;
    Mediator mediator;
    ArrayList<Message> messages;

    Stage window;
    Message selectedMessage;
    ListView<VBox> messageList;

    TextField receiverInput;
    TextArea messageInput;


    public  Client (String name, Mediator mediator, Stage stage){
        this.name = name;
        this.mediator = mediator;
        this.messages = new ArrayList<>();

        this.window = stage;
        this.window.setScene();

        this.refreshMessageView();
        this.refreshSendingView();

    }

    public boolean receiveMessage(Message message){
        try {
            message.received = new Date();
            messages.add(message);
            refreshMessageView();
            return true;

        } catch (Exception e){
            return false;
        }

    }

    private void refreshMessageView(){
        //VBox for listing
        messageList.getItems().clear();

        //make rows from states add to list
        for (Message m : this.messages) {

            //make a row
            Label messageHeader = new Label();
            Text messageText = new Text();
            VBox listRow = new VBox(messageHeader, messageText);
            //HBox listRow = new HBox();

            //set texts for list item
            if ( m.sender.equals(name)) {

            } else {
                messageHeader.setText(String.format("From: %s  %s", m.sender, m.received) );
            }

            //action for clicking row
            listRow.setOnMouseClicked((e) -> {
                this.selectedMessage = m;
                System.out.println("Selected message: " + m);
            });

            this.messageList.getItems().add(listRow);
        }


    }

    private void refreshSendingView(){



    }

    private void sendMessage(Message message){
        if (this.mediator.relayMessage(message)){
            this.messages.add(message);
            refreshMessageView();


            refreshSendingView();
        } else {

        }

    }










}
