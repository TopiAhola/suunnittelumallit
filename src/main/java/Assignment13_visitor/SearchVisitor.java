package Assignment13_visitor;

import java.util.HashSet;
import java.util.Set;

public class SearchVisitor implements FileSystemVisitor{

    Set<FileSystemElement> foundElements;
    String searchTarget;
    FileSystemElement startingElement;


    public SearchVisitor() {
        this.foundElements = new HashSet<>();
    }

    public Set<FileSystemElement> search(String search, FileSystemElement start){
        this.searchTarget = search;
        this.startingElement = start;
        start.accept(this);
        return this.foundElements;
    }


    public void visit(Directory target){
        if(target.name.equals(searchTarget)){
            foundElements.add(target);
        }
        target.children.forEach(c -> c.accept(this));
    };

    public void visit(File target){
        if(target.name.equals(searchTarget)){
            foundElements.add(target);
        }
    };
}
