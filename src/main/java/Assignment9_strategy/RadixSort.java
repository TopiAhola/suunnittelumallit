package Assignment9_strategy;

import java.util.Arrays;

public class RadixSort implements Algorithm{


    public void sortByDigit(int[] array, int digit) {


    }


    @Override
    public int[] sort(int[] array) {
        System.out.println("Radix sort");


        //get max
        int largestInteger = Arrays.stream(array).max().getAsInt();
        int largestDigit = Integer.toString(largestInteger, 10).length();

        //split numbers to buckets
        int[][] bucketArray = new int[largestDigit][array.length]; //array
        // kaikille luvuille
        for (int index = 0; index < array.length; index++) {

            String numberAsString = Integer.toString( array[index] );
            for (int digit = numberAsString.length(); digit > 0 ; digit--) {
                //insert to [digit][number]
                bucketArray[digit-1][index] = Integer.parseInt(String.valueOf(numberAsString.charAt(numberAsString.length() - digit)));

            }
        }

        //testitulostus
/*        for (int index = 0; index < array.length; index++) {
            for (int digit = largestDigit; digit > 0; digit--) {
                System.out.print(bucketArray[digit-1][index]);
            }
            System.out.println("\n");
        }*/

        int[] returnarray = new int[array.length];



        return null;
    }
}
