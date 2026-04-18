package Assignment20_iterator;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * This class will implement the java.util.Iterator<Integer> interface. It should handle the logic for iterating over the Fibonacci sequence.
 */
public class FibonacciIterator implements Iterator<Integer> {

    FibonacciSequence fibonacciSequence;
    int next;
    int prev;
    int index;
    int limit;

    public FibonacciIterator(FibonacciSequence fbs) {
        this.fibonacciSequence = fbs;
        this.index = 0;
        this.next = fbs.getNumberByIndex(index);
        this.limit = 45; //largest number that fits in int is 45
    }



    @Override
    public boolean hasNext() {
        if (index <= limit){
            System.out.printf("index: %d next: %d \n", index, next );
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer next() {
        int returnValue = next;
        prev = next;
        index++;
        next = fibonacciSequence.getNumberByIndex(index);
        return returnValue;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {
        Iterator.super.forEachRemaining(action);
    }

    public void setLimit(int index){
        limit = index;
    }


}
