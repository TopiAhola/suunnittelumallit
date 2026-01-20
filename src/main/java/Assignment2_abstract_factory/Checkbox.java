package Assignment2_abstract_factory;

public abstract class Checkbox {
    String text;

    public abstract void display();

    public void setText(String newText) {
        this.text = newText;
    }
}
