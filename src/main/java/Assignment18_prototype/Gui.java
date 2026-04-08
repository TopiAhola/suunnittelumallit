package Assignment18_prototype;

import Assignment11_memento.guistate.ColorBox;
import Assignment11_memento.guistate.Memento;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.*;

import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Date;

public class Gui extends Application {


    Controller controller = new Controller();


    private Stage recommendationWindow;
    private Stage bookWindow;
    private Book bookSelected;
    private Recommendation recommendationSelected;

    List<Book> books;
    List<Recommendation> recommendations;


    public void start(Stage stage) {

        recommendationWindow = new Stage();
        bookWindow = new Stage();
        recommendationWindow.setTitle("Recommendations");
        bookWindow.setTitle("Books");

        books = controller.getBooks();
        recommendations = controller.getRecommendations();

        updateGui();
        }


        public void updateGui() {
            //reload lists
            books = controller.getBooks();
            recommendations = controller.getRecommendations();

            recommendationWindow.setScene(getRecommendationListContent());
            bookWindow.setScene(getBookListContent());
            recommendationWindow.show();
            bookWindow.show();
        }


        public Scene getRecommendationListContent(){
            // Insets for margin and padding
            Insets insets = new Insets(10, 10, 10, 10);


            //button area for ui
            Button cloneRecButton = new Button("Clone recommendation");
            cloneRecButton.setOnAction((e) -> {
                if (recommendationSelected != null){
                    //clone and select
                    recommendationSelected = controller.cloneRecommendation(recommendationSelected);
                    controller.addRecommendation(recommendationSelected);
                }
                updateGui();
            });

            Button deleteRecButton = new Button("Delete recommendation");
            deleteRecButton.setOnAction((e) -> {
                System.out.println("Delete rec");
                if (recommendationSelected != null){
                    controller.removeRecommendation(recommendationSelected);
                    recommendationSelected = null;
                }
                updateGui();
            });

            Label loadExplainer = new Label("Select recommendation to see books!");
            String name = recommendationSelected != null ? recommendationSelected.getName() : "none";
            Label currentIndexLabel = new Label("Selected: " +name);


            //VBox for listing
            ListView<HBox> recList = new ListView<>();

            //VBox for listing
            ListView<HBox> booksInRec = new ListView<>();

            //make rows from states add to list
            for (Recommendation rec : recommendations) {

                //make a row of data
                Label infoLabel = new Label("Name: " + rec.getName() + " Target audience: " + rec.getTargetAudience());
                VBox tableRow = new VBox(infoLabel);
                HBox listRow = new HBox(tableRow);

                listRow.setOnMouseClicked((e) -> {
                    recommendationSelected = rec;
                    System.out.println("Selected recommendation: " + rec);


                });

                recList.getItems().add(listRow);
            }


            //VBox for buttons
            VBox buttonArea = new VBox(loadExplainer, currentIndexLabel, cloneRecButton, deleteRecButton);
            buttonArea.setPadding(insets);

            //Hbox layout for window
            HBox parallelLists = new HBox(recList, booksInRec);
            parallelLists.setPrefWidth(800);
            recList.setPrefWidth(400);
            booksInRec.setPrefWidth(400);

            //Vbox for recs
            VBox recWindowlayout = new VBox(buttonArea, parallelLists);
            recWindowlayout.setPadding(insets);

            //set layout to scene
            return new Scene(recWindowlayout);
        }

        public Scene getBookListContent(){
            // Insets for margin and padding
            Insets insets = new Insets(10, 10, 10, 10);

            //button area for ui
            Button addBookButton = new Button("Add book");
            addBookButton.setOnAction((e) -> {

            });

            Button deleteBookButton = new Button("Delete book");
            deleteBookButton.setOnAction((e) -> {
                System.out.println("Delete book");
                if (bookSelected != null){
                    controller.removeBook(bookSelected);
                    bookSelected = null;
                }
                updateGui();
            });

            Label loadExplainer = new Label("Books");

            String selectedTitle = bookSelected != null ? bookSelected.getTitle() : "none";
            Label currentIndexLabel = new Label("Selected book: " + selectedTitle);
            VBox buttonArea = new VBox(loadExplainer, currentIndexLabel, addBookButton, deleteBookButton);
            buttonArea.setPadding(insets);

            //VBox for listing
            ListView<HBox> bookList = new ListView<>();



            //clear previou

            //make rows from states add to list
            for (Book b : books) {
                String author = b.getAuthor();
                String title = b.getTitle();
                String genre = b.getGenre();
                Date published = b.getPublished();

                //make a row of data
                Label infoLabel = new Label("Title: " + title + " Author: " + author + "Genre: " + genre);
                Label dateLabel = new Label(published.toString());
                VBox tableRow = new VBox(infoLabel, dateLabel);
                HBox listRow = new HBox(tableRow);

                listRow.setOnMouseClicked((e) -> {
                    bookSelected = b;
                    System.out.println("Selected book: " + bookSelected);
                });

                //historyList.getItems().add(listCell);
                bookList.getItems().add(listRow);
            }

            //VBox layout for window
            VBox bookWindowLayout = new VBox(buttonArea, bookList);
            bookWindowLayout.setPadding(insets);

            //return scene
            return new Scene(bookWindowLayout);
    }



}
