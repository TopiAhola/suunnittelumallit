package Assignment7_state;

public class Character {
    public String name;
    public Level level;
    public int experiencePoints;
    public int healthPoints;
    public int turnCount;


    public Character(String name) {
        this.name = name;
        this.level = new Novice(this);
        this.experiencePoints = 0;
        this.healthPoints = 10;
        this.turnCount = 1;
    }

    public void doTurn(){
        this.level.doTurn();
    }

    public void printStats(){
        System.out.println();
        System.out.println("Turn: " + this.turnCount);
        System.out.println("Name: " + this.name);
        System.out.println("Level: " + this.level.getClass().getSimpleName());
        System.out.println("Experience Points: " + this.experiencePoints);
        System.out.println("Health Points: " + this.healthPoints);
        System.out.println();
    }

}
