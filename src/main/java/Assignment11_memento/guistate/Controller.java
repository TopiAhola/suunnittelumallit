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
 /*        //save initial state if not saved
        if(history.isEmpty()){
            saveToHistory();
        }*/
        model.setOption(optionNumber, choice);
        saveToHistory();
        gui.updateGui();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
 /*       //save initial state if not saved
        if(history.isEmpty()){
            saveToHistory();
        }*/
        model.setIsSelected(isSelected);
        //save modified state
        saveToHistory();
        gui.updateGui();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {

            //step 1 index to past
            if(currentHistoryIndex > 0 ) {
                currentHistoryIndex = currentHistoryIndex - 1;
                System.out.println("Step back to: "+ currentHistoryIndex);


                IMemento previousState = history.get(currentHistoryIndex);

                model.restoreState(previousState);


            } else{
                System.out.println("index is 0: " + currentHistoryIndex);
                IMemento previousState = history.get(currentHistoryIndex);
                model.restoreState(previousState);
            }

        } else  {
            System.out.println("No history");
        }
        gui.updateGui();
    }

    public void redo() {
        if (!history.isEmpty()) {

            //step 1 index to future
            if(currentHistoryIndex < history.size() -1 ) {
                currentHistoryIndex = currentHistoryIndex + 1;

                System.out.println("Step forward to: " + currentHistoryIndex);

            } else {
                System.out.println("No more future history");
            }

            IMemento nextState = history.get(currentHistoryIndex);
            model.restoreState(nextState);

        } else  {
            System.out.println("No history");
        }
        gui.updateGui();
    }


    private void saveToHistory() {
        IMemento currentState = model.createMemento();

        //erase future redo states if they exist
        if (currentHistoryIndex < history.size() - 1) {

            //remove from end of list
            System.out.println("Remove from history: " + (currentHistoryIndex+1) + " - " + (history.size()-1) );
            history.subList(currentHistoryIndex + 1, history.size()).clear();
        }

        //
        history.addLast(currentState);
        currentHistoryIndex = history.size()-1;
        System.out.println("Added history index: " + currentHistoryIndex +" history size: " +history.size());
    }
}
