package Assignment22_command;

import Assignment18_prototype.Book;
import Assignment18_prototype.Controller;
import Assignment18_prototype.Recommendation;
import Assignment22_command.commands.GenerateCodeCommand;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class Gui extends Application {

    Editor editor;
    private Stage stage;


    //Commands
    MoveCursorUpCommand moveCursorUpCommand;
    MoveCursorDownCommand moveCursorDownCommand;
    MoveCursorLeftCommand moveCursorLeftCommand;
    MoveCursorRightCommand moveCursorRightCommand;
    TogglePixelCommand togglePixelCommand;
    GenerateCodeCommand generateCodeCommand;

    public void start(Stage stage) {
        this.stage = stage;
        this.stage.setTitle("Pixel Editor");

        this.editor = new Editor(8, 8);

        this.moveCursorUpCommand = new MoveCursorUpCommand(this.editor);
        this.moveCursorDownCommand = new MoveCursorDownCommand(this.editor);
        this.moveCursorLeftCommand = new MoveCursorLeftCommand(this.editor);
        this.moveCursorRightCommand = new MoveCursorRightCommand(this.editor);
        this.togglePixelCommand = new TogglePixelCommand(this.editor);
        this.generateCodeCommand = new GenerateCodeCommand(this.editor);
        updateGui();
    }

    public void updateGui() {
        this.stage.setScene(getUpdatedScene());
        this.stage.show();
    }

    public void newEditor(int width, int height) {
        this.editor = new Editor(width, height);

        this.moveCursorUpCommand.setEditor(this.editor);
        this.moveCursorDownCommand.setEditor(this.editor);
        this.moveCursorLeftCommand.setEditor(this.editor);
        this.moveCursorRightCommand.setEditor(this.editor);
        this.togglePixelCommand.setEditor(this.editor);
        this.generateCodeCommand.setEditor(this.editor);


        updateGui();
    }

    public Scene getUpdatedScene() {

        //topbar with buttons
        Label infoLabel = new Label("Use shift + arrow keys to move selected pixel.\nUse space to toggle pixel.\nClick 'Generate Code' button to print pixel map to console.");
        Button generateCodeButton = new Button("Generate Code");
        generateCodeButton.setOnAction(e -> {
            this.generateCodeCommand.execute();
        });
        Label newEditorLabel = new Label("New Pixel Map:");
        TextField widthTextField = new TextField();
        widthTextField.setPromptText("width");
        TextField heightTextField = new TextField();
        heightTextField.setPromptText("height");
        Button newEditorButton = new Button("Create New");
        newEditorButton.setOnAction(e -> {
            try {
                int width = Integer.parseInt(widthTextField.getText());
                int height = Integer.parseInt(heightTextField.getText());
                this.newEditor(width, height);
                updateGui();
            } catch (Exception ex) {
                System.out.println("Bad input");
            }

        });

        //pane holding canvas with pixels on it
        Pane pixelMapPane = new Pane(getPixelCanvas());
        pixelMapPane.setFocusTraversable(true);
        pixelMapPane.setMinWidth(pixelMapPane.getWidth());
        pixelMapPane.setMinHeight(pixelMapPane.getHeight());


        //size window to fit canvas
        this.stage.setMinWidth(pixelMapPane.getWidth());
        this.stage.setMinHeight(pixelMapPane.getHeight());

        //put elemts to root
        VBox root = new VBox(infoLabel, newEditorLabel, widthTextField, heightTextField, newEditorButton, pixelMapPane, generateCodeButton );

        //size root to fit canvas
        root.setMinWidth(pixelMapPane.getWidth());
        root.setMinHeight(pixelMapPane.getHeight());

        //set reziable

        //create scene
        Scene scene = new Scene(root);


        //set key commands for window
        scene.setOnMouseClicked(mouseEvent -> {
                    System.out.println(mouseEvent.getButton());
                }
        );

        root.addEventHandler(KeyEvent.KEY_TYPED, event -> {
                System.out.println(event.getCode() );
            }
        );

        root.requestFocus();
        root.setOnKeyPressed(
                (e) -> {
                    System.out.println(e.getCode());
                    switch (e.getCode()) {
                        case SPACE:
                            this.togglePixelCommand.execute();
                            updateGui();
                            break;
                        case UP:
                            this.moveCursorUpCommand.execute();
                            updateGui();
                            break;
                        case DOWN:
                            this.moveCursorDownCommand.execute();
                            updateGui();
                            break;
                        case LEFT:
                            this.moveCursorLeftCommand.execute();
                            updateGui();
                            break;
                        case RIGHT:
                            this.moveCursorRightCommand.execute();
                            updateGui();
                            break;
                        default:
                            break;
                    }

                }
        );

        return scene;
    }

    private Canvas getPixelCanvas(){
        int width = editor.getCursorXMax() + 1; //cursor postition starts from 0...
        int height = editor.getCursorYMax() +1;

        int pixelSize = 100;

        Canvas canvas = new Canvas(width  * pixelSize, height * pixelSize);
        canvas.setHeight((height + 1) * pixelSize);
        canvas.setWidth((width +1) * pixelSize);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //draw pixels
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = editor.getPixelArt()[y][x];
                System.out.print(pixel);
                if (pixel == 0) {
                    gc.setFill(Color.BLACK);
                } else if (pixel == 1) {
                    gc.setFill(Color.WHITE);
                }
                gc.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
                gc.stroke();
            }
        }

        //draw cursor square
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.RED);
        gc.setLineWidth(5);
        gc.rect(editor.getCursorX() * pixelSize, editor.getCursorY() * pixelSize, pixelSize, pixelSize);
        gc.stroke();



        return canvas;
    }






    class MoveCursorUpCommand implements Command {
        Editor editor;

        public MoveCursorUpCommand(Editor editor) {
            this.editor = editor;
        }

        public void execute() {
            System.out.println("Execute MoveCursorUpCommand");
            editor.moveCursorUpCommand();
        }

        public void setEditor(Editor editor) {
            this.editor = editor;
        }
    }

    class MoveCursorDownCommand implements Command {
        Editor editor;

        public MoveCursorDownCommand(Editor editor) {
            this.editor = editor;
        }

        public void execute() {
            System.out.println("Execute MoveCursorDownCommand");
            this.editor.moveCursorDownCommand();
        }

        public void setEditor(Editor editor) {
            this.editor = editor;
        }
    }

    class MoveCursorLeftCommand implements Command {
        Editor editor;

        public MoveCursorLeftCommand(Editor editor) {
            this.editor = editor;
        }

        public void execute() {
            System.out.println("Execute MoveCursorLeftCommand");
            editor.moveCursorLeftCommand();
        }

        public void setEditor(Editor editor) {
            this.editor = editor;
        }
    }

    class MoveCursorRightCommand implements Command {
        Editor editor;

        public MoveCursorRightCommand(Editor editor) {
            this.editor = editor;
        }

        public void execute() {
            System.out.println("Execute MoveCursorRightCommand");
            editor.moveCursorRightCommand();
        }

        public void setEditor(Editor editor) {
            this.editor = editor;
        }
    }

    class TogglePixelCommand implements Command {
        Editor editor;

        public TogglePixelCommand(Editor editor) {
            this.editor = editor;
        }

        public void execute() {
            System.out.println("Execute TogglePixelCommand");
            editor.togglePixelCommand();
        }

        public void setEditor(Editor editor) {
            this.editor = editor;
        }
    }

    class GenerateCodeCommand implements Command {
        Editor editor;

        public GenerateCodeCommand(Editor editor) {
            this.editor = editor;
        }

        public void execute() {
            System.out.println("Execute GenerateCodeCommand");
            editor.generateCodeCommand();
        }

        public void setEditor(Editor editor) {
            this.editor = editor;
        }
    }




}
