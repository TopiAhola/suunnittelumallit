package Assignment11_memento.guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private int currentHistoryIndex;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.currentHistoryIndex = 0;
    }

    public void setOption(int optionNumber, int choice) {
         //save initial state if not saved
        if(history.isEmpty()){
            saveToHistory();
        }
        model.setOption(optionNumber, choice);
        saveToHistory();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        //save initial state if not saved
        if(history.isEmpty()){
            saveToHistory();
        }
        model.setIsSelected(isSelected);
        //save modified state
        saveToHistory();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");

            //step 1 index to past
            if(currentHistoryIndex > 0 ) {
                currentHistoryIndex = currentHistoryIndex - 1;
            }
            IMemento previousState = history.get(currentHistoryIndex);

            model.restoreState(previousState);
            gui.updateGui();

        } else  {
            System.out.println("No history");
            currentHistoryIndex = 0;
        }
    }

    public void redo() {
        if (!history.isEmpty()) {

            //step 1 index to future
            if(currentHistoryIndex >= 0 &&  currentHistoryIndex < history.size() -1 ) {
                currentHistoryIndex = currentHistoryIndex + 1;

                System.out.println("Memento found in future history");
                IMemento nextState = history.get(currentHistoryIndex);

                model.restoreState(nextState);
                gui.updateGui();


            } else {
                System.out.println("No more future history");
            }

        } else  {
            System.out.println("No history");
            currentHistoryIndex = 0;
        }
    }


    private void saveToHistory() {
        IMemento currentState = model.createMemento();

        //erase redo states if they exist
        if (currentHistoryIndex < history.size() - 1) {

            history = new ArrayList<>(history.subList(0, currentHistoryIndex + 1));

             //remove indexes bigger than current
            //history.listIterator(currentHistoryIndex + 1).forEachRemaining(history::remove);
        }

        //
        history.add(currentState);
        currentHistoryIndex = history.size()-1;
    }
}
