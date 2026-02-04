package Assignment9_strategy;

public class InsertionSort implements Algorithm{

    @Override
    public int[] sort(int[] array) {
        System.out.println("Insertion sort");

        for (int index = 1; index < array.length; ++index) {
            int key = array[index];
            int insertPointer = index - 1;

            while (insertPointer >= 0) {
                if(array[insertPointer] > key) {
                    array[insertPointer + 1] = array[insertPointer];
                    insertPointer -= 1;
                } else {
                    break;
                }
            }

            array[insertPointer + 1] = key;
        }
        return array;
    }
}
