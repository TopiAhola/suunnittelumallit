package Assignment19_mediator;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
public class Client {



    String name;
    Mediator mediator;
    ArrayList<Message> messages;

    Stage window;
    Scene scene;
    Message selectedMessage;

    ListView<HBox> messageList;
    VBox inputArea;
    TextField receiverInput;



    public  Client (String name, Mediator mediator, Stage stage){
        this.name = name;
        this.mediator = mediator;
        this.messages = new ArrayList<>();

        this.messageList = getMessageView();
        this.inputArea = getSendingBox();
        this.scene = new Scene(new VBox(messageList, inputArea) );

        //show window
        this.window = stage;
        this.window.setScene(this.scene);
        this.window.setTitle(name);
        this.window.show();

    }

    public boolean receiveMessage(Message message){
        try {
            System.out.println("Received:" +message);
            message.received = new Date();
            this.messages.add(message);
            refreshMessages();
            return true;

        } catch (Exception e){
            return false;
        }

    }

    private  ListView<HBox> getMessageView(){
        //VBox for listing
        //messageList.getItems().clear();

        ListView<HBox> newMessageList = new ListView<>();

        //make rows from states add to list
        for (Message m : this.messages) {

            System.out.println(m);

            //make a row
            Label messageHeader = new Label();
            Text messageText = new Text();
            VBox listRowElements = new VBox(messageHeader, messageText);
            HBox listRow = new HBox(listRowElements);

            //set texts for list item
            if ( m.sender.equals(name)) {
                messageHeader.setText(String.format("You to %s  %s", m.receiver, m.sent) );
                listRow.setStyle("b-fx-background-color:blue");
            } else {
                messageHeader.setText(String.format("From: %s  %s", m.sender, m.received) );
            }
            messageText.setText(m.message);



            //action for clicking row
            listRow.setOnMouseClicked((e) -> {
                this.selectedMessage = m;
                if (!m.sender.equals(this.name) ) {
                    this.receiverInput.setText(m.sender);
                }
                System.out.println("Selected message: " + m);
            });

            newMessageList.getItems().add(listRow);
        }
        return newMessageList;
    }

    private VBox getSendingBox(){

        this.receiverInput = new TextField();
        receiverInput.setPromptText("Receiver");

        TextArea messageInput = new TextArea();
        messageInput.setPromptText("your message here...");

        Button sendbutton = new Button("Send");
        sendbutton.setOnAction(
                (e)-> {
                    this.sendMessage(new Message(this.receiverInput.getText(), this.name, messageInput.getText()));
        }
        );

        Button clearButton = new Button("Clear");
        clearButton.setOnAction(
                (e)-> {
                    receiverInput.setText("");
                    messageInput.setText("");
                }
        );

        HBox bottomBar = new HBox(sendbutton, clearButton);
        bottomBar.setPrefWidth(100);
        Insets insets10 = new Insets(10, 10, 10, 10);
        bottomBar.setPadding(insets10);

        VBox inputArea = new VBox(receiverInput, messageInput, bottomBar);
        inputArea.setPadding(insets10);

        return inputArea;

    }

    private void refreshGui(){
        this.messageList = getMessageView();
        this.inputArea = getSendingBox();
        this.scene = new Scene(new VBox(messageList, inputArea) );

        //show window
        this.window.setScene(this.scene);
        this.window.setTitle(name);
        this.window.show();

        window.show();
    }

    private void refreshMessages(){
        this.messageList = getMessageView();
        this.scene = new Scene(new VBox(messageList, inputArea) );

        //show window
        this.window.setScene(this.scene);
        this.window.setTitle(name);
        this.window.show();

        window.show();
    }



    private void sendMessage(Message message){
        if (this.mediator.relayMessage(message)){
            this.messages.add(message);
            refreshGui();
            System.out.println("Message sent");
        } else {

        }

    }










}
