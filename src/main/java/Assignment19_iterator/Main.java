package Assignment19_iterator;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FibonacciSequence fbs = new FibonacciSequence();
        Iterator<Integer> iter = fbs.iterator();

        //try limiting:
        FibonacciIterator a =(FibonacciIterator)iter;
        a.setLimit(10);
        a.setLimit(10);

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        a.setLimit(20);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        Scanner scanner = new Scanner(System.in);

        Iterator<Integer> newIterator = fbs.iterator();
        while (newIterator.hasNext()) {
            System.out.println(newIterator.next());
            scanner.nextLine();
        }

}}
