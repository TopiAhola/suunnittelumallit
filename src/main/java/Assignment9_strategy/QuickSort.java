package Assignment9_strategy;

import java.util.Arrays;

public class QuickSort implements Algorithm{
   @Override
    public int[] sort(int[] array) {
       System.out.println("Quick sort");
       return recursiveDivide(array);
    }

    private int[] recursiveDivide(int[] subArray) {
       if (subArray.length < 2) return subArray;
       int pivotIndex = (int) (subArray.length/2);


       int smallerCount = 0;
       int largerCount = 0;
       int equalCount = 0;
       //count sizes
       for(int i = 0; i < subArray.length; i++){
           if(subArray[i] > subArray[pivotIndex]){
               largerCount++;
           } else if(subArray[i] < subArray[pivotIndex]) {
               smallerCount++;
           }  else {
               equalCount++;
           }
       }
       //make arrays
       int[] smallerArray = new int[smallerCount];
       int[] largerArray = new int[largerCount];
       int[] equalArray = new int[equalCount];

       //fill arrays
       int smallerIndex = 0;
       int largerIndex = 0;
       int equalIndex = 0;
       for(int i = 0; i < subArray.length; i++){
           if(subArray[i] > subArray[pivotIndex]){
               largerArray[largerIndex] = subArray[i];
               largerIndex++;

           } else if(subArray[i] < subArray[pivotIndex])  {
               smallerArray[smallerIndex] = subArray[i];
               smallerIndex++;

           } else  {
               equalArray[equalIndex] = subArray[i];
               equalIndex++;
           }
       }

       int[] sortedSmallArray = recursiveDivide(smallerArray);
       int[] sortedLargerArray = recursiveDivide(largerArray);
       int[] returnArray = new int[smallerCount + equalCount + largerCount];
       //combine arrays for retund array
        //small array
       System.arraycopy(sortedSmallArray, 0, returnArray, 0, smallerCount);
       //add pivot
       System.arraycopy(equalArray, 0, returnArray, smallerCount, equalCount);
       //large array
       System.arraycopy(sortedLargerArray, 0, returnArray, smallerCount+equalCount, largerCount);

       //System.out.println("recursiveDivide subarray length: " + subArray.length + ", pivot: " + subArray[pivotIndex] + " array: " + Arrays.toString(subArray) +"return " + Arrays.toString(returnArray));
       return returnArray;

    }


}
