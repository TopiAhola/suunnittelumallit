package Assignment2_abstract_factory;

public class CheckboxA extends Checkbox{

    public CheckboxA(String text) {
        this.text = text;
    }


    public void display(){
        try {
            int textAreaWidth = this.text.length() + 2;
            String horizontalBorder = "+--+";
            for (int i = 0; i < textAreaWidth; i++) {
                horizontalBorder = horizontalBorder.concat(" ");
            }
            horizontalBorder = horizontalBorder.concat(" ");

            //print rectangle
            System.out.println(horizontalBorder);
            System.out.println("|  | " + this.text + "  ");
            System.out.println(horizontalBorder);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    };


}
