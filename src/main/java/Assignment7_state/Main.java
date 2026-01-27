package Assignment7_state;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Name your character:");
        Scanner scanner = new Scanner(System.in);
        Character newCharacter = new Character(scanner.nextLine());
        newCharacter.doTurn();
        System.out.println("Game has ended.");
    }
}
