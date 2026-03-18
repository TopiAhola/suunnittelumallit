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


    public long getSize(FileSystemElement target){
        totalSize = 0;
        target.accept(this);
        return totalSize;
    }


    public void visit(Directory target){
        target.children.forEach(c -> c.accept(this));
    };

    public void visit(File target){
        if(target != null ) {
            this.totalSize += target.size;
        }
    };
}
