package Assignment11_memento.guistate;

import java.util.Arrays;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;

    public Memento(int[] options, boolean isSelected) {
        //this.options = options.clone(); // Copy options array
        this.options = Arrays.copyOf(options, options.length);
        this.isSelected = isSelected;
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
