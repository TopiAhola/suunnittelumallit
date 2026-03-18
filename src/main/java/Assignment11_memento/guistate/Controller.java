package Assignment11_memento.guistate;

import java.util.*;

public class Controller {
    private Model model;
    private Gui gui;
    private Map<Integer,IMemento> history; // Memento history
    private int currentHistoryIndex;


    private IMemento currentState;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new TreeMap<>();
        this.currentHistoryIndex = 0;
    }

    public Map<Integer,IMemento> getHistory(){
        return this.history;
    }

    public int getCurrentHistoryIndex() {
        return currentHistoryIndex;
    }

    public void setOption(int optionNumber, int choice) {
         //save initial state if not saved
        if(history.isEmpty()){
            saveToHistory();
        }
        model.setOption(optionNumber, choice);
        saveToHistory();
        gui.updateGui();
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
        gui.updateGui();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void loadHistory(int index){
        System.out.println("loadHistory: "+index);
        IMemento targetState = history.get(index);
        model.restoreState(targetState);
        currentHistoryIndex = index;
        gui.updateGui();
    }



    public void undo() {
        if (!history.isEmpty()) {

            //step 1 index to past
            if(currentHistoryIndex > 1 ) {
                currentHistoryIndex = currentHistoryIndex - 1;
                System.out.println("Step back to: "+ currentHistoryIndex);

            } else{
                System.out.println("index is 1: " + currentHistoryIndex);

            }


            IMemento previousState = history.get(currentHistoryIndex);
            model.restoreState(previousState);

            //logging
            Memento printoutmemento = (Memento)previousState;
            System.out.println("Current state is:" +previousState.toString() +printoutmemento.getOptions().toString() +printoutmemento.isSelected());

        } else  {
            System.out.println("No history");
        }

        gui.updateGui();
    }

    public void redo() {
        if (!history.isEmpty()) {

            //step 1 index to future
            if(currentHistoryIndex < history.size() ) {
                currentHistoryIndex = currentHistoryIndex + 1;

                System.out.println("Step forward to: " + currentHistoryIndex);

            } else {
                System.out.println("No more future history at: " + currentHistoryIndex);
            }

            IMemento nextState = history.get(currentHistoryIndex);
            model.restoreState(nextState);

            //logging
            Memento printoutmemento = (Memento) nextState;
            System.out.println("Current state is:" +nextState.toString() +printoutmemento.getOptions().toString() +printoutmemento.isSelected());
        } else  {
            System.out.println("No history");
        }
        gui.updateGui();
    }


    private void saveToHistory() {


        //erase future redo states if they exist
        if (currentHistoryIndex < history.size()) {
            int originalHistorySize = history.size();
            for (int i = currentHistoryIndex+1; i <= originalHistorySize; i++) {
                history.remove(i);
                System.out.println("Removed state: " +i);
            }

/*            //remove from end of list
            System.out.println("Remove from history: " + (currentHistoryIndex+1) + " - " + (history.size()-1) );
            history.subList(currentHistoryIndex + 1, history.size()).clear();*/
        }

        IMemento currentState = model.createMemento();


        //increase index by 1
        currentHistoryIndex++;

        //logging
        Memento printoutmemento = (Memento) currentState;
        System.out.println("Saved new state is:" +currentState.toString() +printoutmemento.getOptions().toString() +printoutmemento.isSelected());

        //put next state to history
        history.put(currentHistoryIndex, currentState);
        //currentHistoryIndex = history.size()-1;
        System.out.println("Added history index: " + currentHistoryIndex +" history size: " +history.size());
    }
}
