package Assignment13_visitor;

public class File implements FileSystemElement{
    String name;
    long size;


    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public void accept(FileSystemVisitor visitor){
        visitor.visit(this);
    };

}
