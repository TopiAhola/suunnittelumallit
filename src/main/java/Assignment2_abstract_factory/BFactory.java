package Assignment2_abstract_factory;

public class BFactory extends UIFactory{

    public Button createButton(String text){
        return new ButtonB(text);
    }

    public Checkbox createCheckbox(String text){
        return new CheckboxB(text);
    }

    public TextField createTextField(String text){
        return new TextFieldB(text);
    }


}
