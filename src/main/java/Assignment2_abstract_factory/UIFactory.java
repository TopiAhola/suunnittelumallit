package Assignment2_abstract_factory;

public abstract class UIFactory {

    public abstract Button createButton(String text);

    public abstract Checkbox createCheckbox(String text);

    public abstract TextField createTextField(String text);

}
