package Assignment2_abstract_factory;

public class AFactory extends UIFactory{

     public Button createButton(String text){
        return new ButtonA(text);
    }

    public Checkbox createCheckbox(String text){
        return new CheckboxA(text);
    }

    public TextField createTextField(String text){
        return new TextFieldA(text);
    }


}
