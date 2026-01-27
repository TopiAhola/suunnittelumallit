package Assignment9_strategy;

public class BubbleSort implements Algorithm {

    @Override
    public int[] sort(int[] array) {
        System.out.println("Bubble sort");
        boolean finished;
        do  {
            finished = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int placeHolder = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = placeHolder;
                    finished = false;
                }
            }
        } while (!finished);

        return array;
    }

}
