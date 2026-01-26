package Assignment6_decorator;

public class PrinterDecorator implements Printer{

    public Printer printer;

    public PrinterDecorator(Printer printer){
        this.printer = printer;
    }

    //public PrinterDecorator(){}

    @Override
    public void print(String message) {
        this.printer.print(message);
    }
}
