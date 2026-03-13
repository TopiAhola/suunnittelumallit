package Assignment11_memento.guistate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;
    private Stage historyWindow;
    private int historySelected;

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);


        Label label = new Label("Press Ctrl-Z to undo the last change.");
        Label label2 = new Label("Press Ctrl-Y to redo the last change.");
        label.setPadding(insets);

        //Button to history window
        Button historyButton = new Button("History");
        historyButton.setPadding(insets);
        historyButton.setOnAction(e -> {
            if(e.getEventType() == ActionEvent.ACTION) {
                System.out.println("History button clicked");
                showHistoryWindow();
            }
        });

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox, label, label2, historyButton);
        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);

        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                // Ctrl-Z: undo
                System.out.println("Undo key combination pressed");
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                //redo
                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });

        //historywindow TODO: methods to update
        historyWindow = new Stage();
        historySelected = 0;


        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
        historyWindow.setScene(getHistoryWindowContent());
    }

    public void showHistoryWindow() {
        //Stage historyWindow = new Stage();
        historyWindow.setTitle("History");
        historySelected = 0; //reset selection

        historyWindow.setScene(getHistoryWindowContent());
        historyWindow.show();
    }


    public Scene getHistoryWindowContent(){
        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        //button area for ui
        Button loadHistoryButton = new Button("Load");
        loadHistoryButton.setOnAction( (e)->{controller.loadHistory(historySelected); });
        Label loadExplainer = new Label("Select history and click Load");
        Label currentIndexLabel = new Label("Current history index: " +controller.getCurrentHistoryIndex());
        //Label selectedIndexLabel = new Label("Selected history: "+historySelected);
        VBox buttonArea = new VBox(loadExplainer, currentIndexLabel, loadHistoryButton);
        buttonArea.setPadding(insets);

        //VBox for listing histories
        ListView<HBox> historyList = new ListView<>();

        int currentHistoryIndex = controller.getCurrentHistoryIndex();
        Map<Integer,IMemento> history = controller.getHistory();

        //clear previou

        //make rows from states add to list
        for(int index : history.keySet()) {
            Memento state = (Memento) history.get(index);
            String options = Arrays.toString(state.getOptions());
            boolean selected = state.isSelected();
            Date date = state.getTimestamp();

            Label infoLabel = new Label("Index: " +index +" State: " +options +" "+ selected);
            Label dateLabel = new Label(date.toString());
            VBox tableRow = new VBox(infoLabel, dateLabel);

            //make a row of data
            HBox listRow = new HBox(tableRow);
            //TODO: set selected index to variable for Load method

            listRow.setOnMouseClicked((e)-> {
                historySelected = index;
                System.out.println("Selected index: "+historySelected);


            });

            //historyList.getItems().add(listCell);
            historyList.getItems().add(listRow);
        }


        //VBox layout for window
        VBox historyWindowLayout = new VBox(buttonArea, historyList);
        historyWindowLayout.setPadding(insets);

        //set layout to scene
        Scene historyScene = new Scene(historyWindowLayout);
        return historyScene;

    }

}
