package Assignment7_state;

import java.util.Scanner;

public class Novice extends Level {

    public Novice(Character character) {
        super(character);
    }

    @Override
    public void doTurn() {
        character.printStats();

        //get input
        System.out.println("You are Novice level, all you can do is train:");
        System.out.println("Options:");
        System.out.println("    1. Do nothing");
        System.out.println("    2. Train");
        Scanner sc = new Scanner(System.in);
        String input = sc.next().trim();
        System.out.println(input);

        //process input
        switch (input) {
            case "1": {
                this.doNothing();
            }
            break;

            case "2": {
                this.train();
            }
            break;

            default: {
                System.out.println("Invalid input");
            }
            break;
        }

        //levelup
        if(character.experiencePoints > 200) {
            System.out.println("You have advanced to Intermediate level!");
            character.level = new Intermediate(character);
        }

        //run next turn
        character.turnCount += 1;
        character.level.doTurn();



    }

    public void doNothing(){
        System.out.println("You waste your time...");
    }

    public void train() {
        System.out.println("You train...");
        int newExperience = (int) (Math.random() * 200);
        this.character.experiencePoints += newExperience;
        System.out.println(String.format("Experience increased by %d", newExperience));
    }


}
