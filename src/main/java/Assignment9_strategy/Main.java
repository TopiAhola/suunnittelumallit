package Assignment9_strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //small array
        int[] smallIntArray = new int[] {1,1897,-22,374,0,4123,54,655,7,86,9,10,54,123,824,3,9999,1};
        System.out.println("Original array:");
        System.out.println(Arrays.toString(smallIntArray));

        //large array
        int[] largeIntArray = new int[100_000];
        for (int i = 0; i < 100_000; i++) {
            largeIntArray[i] = (int)((Math.random() * 2000) - 1000);
        }

        Context context = new Context();
        long startTime, BSRuntime, ISRuntime, QSRuntime;

        context.setAlgorithm(new BubbleSort());
        startTime = System.nanoTime();
        int[] bubbleSorted = context.doSorting(smallIntArray.clone());
        BSRuntime = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(bubbleSorted));

        context.setAlgorithm(new InsertionSort());
        startTime = System.nanoTime();
        int[] radixSorted = context.doSorting(smallIntArray.clone());
        ISRuntime = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(radixSorted));

        context.setAlgorithm(new QuickSort());
        startTime = System.nanoTime();
        int[] quickSorted = context.doSorting(smallIntArray.clone());
        QSRuntime = System.nanoTime() - startTime;
        System.out.println(Arrays.toString(quickSorted));


        System.out.println("Small array runtimes (ns) ");
        System.out.println("Bubble sort: "+BSRuntime );
        System.out.println("Insertion sort: "+ISRuntime );
        System.out.println("Quicksort: "+QSRuntime );

        //uudestaan isommalla arraylla

        context.setAlgorithm(new BubbleSort());
        startTime = System.currentTimeMillis();
        int[] bubbleSorted2 = context.doSorting(largeIntArray.clone());
        BSRuntime = System.currentTimeMillis() - startTime;

        context.setAlgorithm(new InsertionSort());
        startTime = System.currentTimeMillis();
        int[] insertionSorted2 = context.doSorting(largeIntArray.clone());
        ISRuntime = System.currentTimeMillis() - startTime;

        context.setAlgorithm(new QuickSort());
        startTime = System.currentTimeMillis();
        int[] quickSorted2 = context.doSorting(largeIntArray.clone());
        QSRuntime = System.currentTimeMillis() - startTime;
        //System.out.println(Arrays.toString(quickSorted2));

        //check sort results
        if(Arrays.equals(quickSorted2,bubbleSorted2)
           && Arrays.equals(bubbleSorted2, insertionSorted2)
        ) {
            System.out.println("Arrays are equal.");
        } else {
            System.out.println("Error in sorting!");
        }

        //print results
        System.out.println("Large array runtimes (ms) ");
        System.out.println("Bubble sort: "+BSRuntime );
        System.out.println("Insertion sort: "+ISRuntime );
        System.out.println("Quicksort: "+QSRuntime );

    }
}
