package Assignment2_abstract_factory;

public abstract class TextField {

    String text;

    public abstract void display();

    public void setText(String newText){
        this.text = newText;
    }
}
