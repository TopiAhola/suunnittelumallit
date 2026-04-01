package Assignment17_flyweight;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) {


        Map City = new CityMap(3,3);
        Map Wilderness = new WildernessMap(4,4);

        //3x3 City map with one tile in center
        City.mapTiles[1][1] = City.createTile();
        System.out.println("City map:");
        City.display();

        //4x4 Wilderness map with random tiles
        for (int i = 0; i < Wilderness.height; i++) {
            for (int j = 0; j < Wilderness.width; j++) {
                Wilderness.mapTiles[i][j] = Wilderness.createTile();
            }

        }
        System.out.println("Wilderness map:");
        Wilderness.display();



        //Testing window
        try {
            InputStream inputStream = new FileInputStream("src/main/java/Assignment17_flyweight/images/building.bmp");
            Image testImage = new Image(inputStream);
            //testImage.getPixelReader().getPixels();

            //draw on canvas
            Canvas canvas = new Canvas(500, 500);
            GraphicsContext gc =  canvas.getGraphicsContext2D();

            //draw small red dot
            gc.setFill(Color.RED);
            gc.fillOval(50, 200, 5, 5);
            gc.stroke();

            //draw image at coordinates (image, x ,y)
            gc.drawImage(testImage, 100, 100);
            gc.stroke();

            //put elemets on root
            Group root = new Group();
            root.getChildren().add(canvas);

            Scene scene = new Scene(root);
            //display
            window.setScene(scene);
            window.setTitle("Test Map");
            window.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

        //draw city map map
        Parent root2 = new Pane( new CityMap(5,5).draw() );
        Scene scene2 = new Scene(root2);
        Stage cityWindow = new Stage();
        cityWindow.setScene(scene2);
        cityWindow.setTitle("City map");
        cityWindow.show();


        //draw wilderness map
        Parent root3 = new Pane( new WildernessMap(5,5).draw() );
        Scene scene3 = new Scene(root3);
        Stage wildernessWindow = new Stage();
        wildernessWindow.setScene(scene3);
        wildernessWindow.setTitle("Wilderness map");
        wildernessWindow.show();


    }
}
