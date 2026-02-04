package Assignment9_strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] intArray = new int[] {1,1897,-22,374,0,4123,54,655,7,86,9,10,54,123,824,3,9999,1};
        System.out.println("Original array:");
        System.out.println(Arrays.toString(intArray));

        Context context = new Context();

        context.setAlgorithm(new BubbleSort());
        int[] bubbleSorted = context.doSorting(intArray.clone());
        System.out.println(Arrays.toString(bubbleSorted));

        context.setAlgorithm(new InsertionSort());
        int[] radixSorted = context.doSorting(intArray.clone());
        System.out.println(Arrays.toString(radixSorted));

        context.setAlgorithm(new QuickSort());
        int[] quickSorted = context.doSorting(intArray.clone());
        System.out.println(Arrays.toString(quickSorted));

        System.out.println("Original array:");
        System.out.println(Arrays.toString(intArray));

        //TODO: timers (nanotime)

    }
}
