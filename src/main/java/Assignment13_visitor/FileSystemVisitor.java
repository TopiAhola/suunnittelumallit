package Assignment13_visitor;

public interface FileSystemVisitor {
    public void visit(File target);
    public void visit(Directory target);
}
