package Assignment13_visitor;

public interface FileSystemElement {
    public void accept(FileSystemVisitor visitor);
}
