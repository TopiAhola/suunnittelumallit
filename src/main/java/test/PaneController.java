package test;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class PaneController {

    @FXML
    Pane rootPane;

    @FXML
    Button button;

    @FXML
    Label label;

    public void initialize(){
        //label = new Label("Button has been pressed");

        button.setOnAction(
                (e)-> {
                    System.out.println("Button click");
                    rootPane.getChildren().add(label);
                }
        );
    }


}
