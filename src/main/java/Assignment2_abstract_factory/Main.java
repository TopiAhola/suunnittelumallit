package Assignment2_abstract_factory;

public class Main {
    public static void main(String[] args) {

        AFactory a = new AFactory();
        BFactory b = new BFactory();

        Button button1 = a.createButton("Button 1 A style");
        Checkbox checkbox1 = a.createCheckbox("Checkbox 1 A style");
        Checkbox checkbox2 = b.createCheckbox("Checkbox 2 B style");
        TextField textField1 = b.createTextField("Textfield 1 B style");

        button1.display();
        checkbox1.display();
        checkbox2.display();
        textField1.display();

        textField1.setText("Set new text for Textfield 1");
        textField1.display();
    }
}
