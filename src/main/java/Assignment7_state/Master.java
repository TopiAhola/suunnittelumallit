package Assignment7_state;

public class Master extends Level {

    public Master(Character character) {
        super(character);
    }

    @Override
    public void doTurn() {
        System.out.println("You have reached master level! Game will end...");

    }


}
