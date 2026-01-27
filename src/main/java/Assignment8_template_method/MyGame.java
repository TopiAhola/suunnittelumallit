package Assignment8_template_method;

import java.util.Arrays;
import java.util.Arrays.*;
import java.util.Scanner;

public class MyGame extends Game {
    public class Player {
        String name;
        int score;

        public Player(String name) {
            this.name = name;
            this.score = 0;
        }
    }

    public Player[] players;
    public Player winner;
    public int secretNumber;

    public MyGame() {

    }

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.players = new Player[numberOfPlayers];
        this.winner = null;
        this.secretNumber = (int)((Math.random()*10) + 1);
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Give name for player " + (i+1));
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            players[i] = new Player(name);
        }

        System.out.println("");
        System.out.println("Welcome to My Game !");
        System.out.println("Your goal is to guess the secret number in range 1 to 10, inclusive.");
        System.out.println("Number of correct guesses needed to win is 1!");
    }

    @Override
    public boolean endOfGame() {
        Player[] winners = Arrays.stream(this.players).filter( (player)-> player.score > 0 ).toArray(Player[]::new);
        if (winners.length > 0) { this.winner = winners[0];}
        return this.winner != null;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println(players[player].name + "'s turn");
        System.out.println(players[player].name+ " guess the number: ");
        Scanner input = new Scanner(System.in);
        int guess = input.nextInt();
        if (guess == secretNumber) {
            players[player].score++;
            System.out.println(players[player].name + " guessed the secret number!");
        }

    }

    @Override
    public void displayWinner() {
        System.out.println("The winner is " + this.winner.name);
        System.out.println("Winner score is " + this.winner.score);
    }



}
