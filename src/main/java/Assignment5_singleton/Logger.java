package Assignment5_singleton;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static Logger instance = null;

    protected String fileName = "";
    protected BufferedWriter writer = null;

    public static Logger getInstance(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }

    private Logger(){
        try {
            this.fileName = "defaultName.txt";
            this.writer = new BufferedWriter(new FileWriter(this.fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean write(String text){
        try {
            System.out.println(this.fileName + " <- " + "\"" + text + "\"");
            writer.write(text);
            writer.newLine();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean setFileName(String fileName) {
        try {
            this.writer.close();
            this.fileName = fileName;
            this.writer = new BufferedWriter(new FileWriter(fileName));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean close(){
        try {
            this.writer.close();
            this.fileName = "";
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
