package Assignment7_state;

import java.sql.SQLOutput;

public abstract class Level {
    public Character character;

    public Level(Character character) {
        this.character = character;
    }

    public abstract void doTurn();


}
