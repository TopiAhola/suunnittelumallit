package test;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.function.UnaryOperator;

public class TestMain {

    public static void main(String[] args) {

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
    }


}
