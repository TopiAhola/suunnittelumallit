package Assignment7_state;

import java.util.Scanner;

public class Intermediate extends Level {

    public Intermediate(Character character) {
        super(character);
    }


    @Override
    public void doTurn() {
        character.printStats();

        //get input
        System.out.println("You are Intermediate level.");
        System.out.println("Options:");
        System.out.println("    1. Do nothing");
        System.out.println("    2. Train");
        System.out.println("    3. Meditate");
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

            case "3": {
                this.meditate();
            } break;

            default: {
                System.out.println("Invalid input");
            }
            break;
        }

        //levelup
        if(character.experiencePoints > 500) {
            System.out.println("You have advanced to Expert level!");
            character.level = new Expert(character);
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

    public void meditate() {
        System.out.println("You meditate...");
        character.healthPoints += (int) (Math.random() *5);
        System.out.println("Your health increases to " + character.healthPoints);
    }


}
