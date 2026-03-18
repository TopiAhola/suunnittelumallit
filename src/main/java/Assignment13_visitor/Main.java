package Assignment13_visitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //create filesystem
        Directory root = new Directory("root");
        Directory user = new Directory("user");
        Directory programs = new Directory("programs");
        Directory pictures = new Directory("pictures");
        Directory texts = new Directory("texts");
        File readme = new File("readme", ".txt", 111);
        File executable = new File("program",".exe", 1234);
        File text2 = new File("text2", ".txt", 100);
        File text3 = new File("text3", ".txt", 120);
        File text4 = new File("text4", ".txt", 130);
        File text5 = new File("text5", ".txt", 140);
        File picture1 = new File("picture", ".png", 2500);
        File picture2 = new File("picture", ".png", 1000);

        root.addChild(user); root.addChild(programs); root.addChild(readme);
        user.addChild(pictures); user.addChild(texts);
        programs.addChild(executable);
        pictures.addChild(picture1); pictures.addChild(picture2);
        texts.addChild(text2); texts.addChild(text3); texts.addChild(text4); texts.addChild(text5);


        //create visitors
        SearchVisitor searchVisitor = new SearchVisitor();
        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();


        //test search
        //this finds all files with "text" in name and "texts" directory
        System.out.println("Search for 'text':");
        List<FileSystemElement> results = searchVisitor.search("text", root);
        for(FileSystemElement e : results) System.out.println(e);

        //this finds all files with ".txt"
        System.out.println("Search for '.txt':");
        List<FileSystemElement> results2 = searchVisitor.search(".txt", root);
        for(FileSystemElement e : results) System.out.println(e);

        //test size
        //size of entire filesystem
        System.out.println("Size of root: " +sizeCalculatorVisitor.getSize(root) );

        //size of pictures folder
        System.out.println("size of pictures folder: " +sizeCalculatorVisitor.getSize(pictures) );

        //size of all .txt files
        System.out.println("size of all .txt files");
        for ( FileSystemElement element : searchVisitor.search(".txt", root) ) {
            System.out.println( sizeCalculatorVisitor.getSize(element) );
        }



    }
}
