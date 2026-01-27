package Assignment8_template_method;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new MyGame();
        Scanner input = new Scanner(System.in);
        System.out.println("Give number of players: ");
        int players = 2;
        try {
            players = input.nextInt();
            System.out.println("Players set to " + players);
        } catch (Exception e) {
            System.out.println("Invalid input. Players set to " + players);
        }

        game.play(players);


    }
}
