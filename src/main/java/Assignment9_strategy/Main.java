package Assignment9_strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //small array
        int[] smallIntArray = new int[] {1,1897,-22,374,0,4123,54,655,7,86,9,10,54,123,824,3,9999,1};
        System.out.println("Original array:");
        System.out.println(Arrays.toString(smallIntArray));

        //large array
        int[] largeIntArray = new int[1_000_000];
        for (int i = 0; i < 1_000_000; i++) {
            largeIntArray[i] = (int)((Math.random() * 1000) - 2000);
        }

        Context context = new Context();

        context.setAlgorithm(new BubbleSort());
        int[] bubbleSorted = context.doSorting(smallIntArray.clone());
        System.out.println(Arrays.toString(bubbleSorted));

        context.setAlgorithm(new InsertionSort());
        int[] radixSorted = context.doSorting(smallIntArray.clone());
        System.out.println(Arrays.toString(radixSorted));

        context.setAlgorithm(new QuickSort());
        int[] quickSorted = context.doSorting(smallIntArray.clone());
        System.out.println(Arrays.toString(quickSorted));



        //TODO: timers (nanotime)

    }
}
