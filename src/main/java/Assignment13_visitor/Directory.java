package Assignment13_visitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Directory implements FileSystemElement{
    String name;
    Set<FileSystemElement> children;

    public Directory(String n){
        name = n;
        children = new HashSet<>();
    }


    public void accept(FileSystemVisitor visitor){
        visitor.visit(this);
    }





}
