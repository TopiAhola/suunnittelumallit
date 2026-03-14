package Assignment13_visitor;

import java.util.HashSet;
import java.util.Set;

public class SizeCalculatorVisitor implements FileSystemVisitor{

    Set<FileSystemElement> visitedElements;
    long totalSize;

    public SizeCalculatorVisitor() {
        this.totalSize = 0;
        this.visitedElements = new HashSet<>();
    }


    public void visit(Directory target){

    };

    public void visit(File target){

    };
}
