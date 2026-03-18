package Assignment13_visitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchVisitor implements FileSystemVisitor{

    List<FileSystemElement> foundElements;
    String searchTarget;
    FileSystemElement startingElement;


    public SearchVisitor() {
        this.foundElements = new ArrayList<>() {
        };
    }

    public List<FileSystemElement> search(String search, FileSystemElement start){
        this.foundElements.clear();
        this.searchTarget = search;
        this.startingElement = start;
        start.accept(this);
        return this.foundElements;
    }


    public void visit(Directory target){
        if(target.name.contains(searchTarget)){
            foundElements.add(target);
        }
        target.children.forEach(c -> c.accept(this));
    };

    public void visit(File target){
        if(target.name.contains(searchTarget) || target.fileType.contains(searchTarget) ){
            foundElements.add(target);
        }
    };
}
