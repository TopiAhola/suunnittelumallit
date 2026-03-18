package Assignment13_visitor;

public class File implements FileSystemElement{
    String name;
    long size;
    String fileType;


    public File(String name, String fileType, long size) {
        this.name = name;
        this.fileType = fileType;
        this.size = size;

    }

    public void accept(FileSystemVisitor visitor){
        visitor.visit(this);
    };



    @Override
    public String toString(){
        return "File " + this.name + this.fileType +  " size: " + this.size;
    }


}
