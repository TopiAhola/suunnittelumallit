package Assignment9_strategy;

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
       //count sizes
       for(int i = 0; i < subArray.length; i++){
           if(subArray[i] > subArray[pivotIndex]){
               largerCount++;
           } else {
               smallerCount++;
           }
       }
       //make arrays
       int[] smallerArray = new int[smallerCount];
       int[] largerArray = new int[largerCount];

       //fill arrays
       int smallerIndex = 0;
       int largerIndex = 0;
       for(int i = 0; i < subArray.length; i++){
           if(subArray[i] > subArray[pivotIndex]){
               largerArray[largerIndex] = subArray[i];
               largerIndex++;
           } else  {
               smallerArray[smallerIndex] = subArray[i];
               smallerIndex++;
           }
       }

       int[] sortedSmallArray = recursiveDivide(smallerArray);
       int[] sortedLargerArray = recursiveDivide(largerArray);
       int[] returnArray = new int[smallerCount + 1 + largerCount];
       //combine arrays for retund array
        //small array
       System.arraycopy(smallerArray, 0, returnArray, 0, smallerCount);
       //add pivot
       returnArray[smallerCount] = subArray[pivotIndex];
       //large array
       System.arraycopy(largerArray, 0, returnArray, smallerCount+1, largerCount);
       return returnArray;

    }


}
