package Assignment20_iterator;

import java.util.Iterator;

/**
 * This class will implement the Sequence interface and will be responsible for generating Fibonacci numbers. It does not have to store the numbers but generate them on demand. This class should have a method to generate the next Fibonacci number when requested by the iterator.
 */
public class FibonacciSequence implements Sequence{


    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(this);
    }


    public int[] getSeries(int[] seed, int length){
        if (seed.length > 1){
            int[] returnArray = new int[length];

            int index_1 = seed[seed.length-1];
            int index_2 = seed[seed.length-2];
            for (int i = 0; i < length; i++) {
                returnArray[i] = index_1 + index_2;
                index_2 = index_1;
                index_1 = returnArray[i];
            }
            return returnArray;

        } else if ( seed.length == 1){
            int[] returnArray = new int[length];

            for (int i = seed[0]; i < seed[0] + length; i++) {
                returnArray[i] = getNumberByIndex(i);
            }
            return returnArray;

        } else {
            return new int[]{};
        }
    }

    public int getNumber(int n_1, int n_2){
        return n_1 + n_2;
    }

    public int getNumberByIndex(int index){
        if (index < 2){
            return 1;

        } else {
            int value = 0;
            int index_1 = 1;
            int index_2 = 1;
            for (int i = 2; i <= index; i++) {
                value = index_1 + index_2;
                index_2 = index_1;
                index_1 = value;

            }
            return value;
        }
    }



}
