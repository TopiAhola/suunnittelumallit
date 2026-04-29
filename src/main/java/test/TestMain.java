package test;

import javafx.fxml.FXMLLoader;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TestMain {

    public static void main(String[] args) throws Exception {

        System.out.println("ASD");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();
        System.out.println(input);

        @FunctionalInterface
                interface Printer {
            public void doIt ();
        }


        Printer a = input.equals("a") ?  () -> System.out.println(input)   :  () -> System.out.println("input not a")  ;

       a.doIt();

        FXMLLoader fxmlLoader = new FXMLLoader( TestMain.class.getResource("/pane.fxml") );
        //fxmlLoader.setController(new PaneController() );
        fxmlLoader.load();
        fxmlLoader.getRoot();




    }


}
