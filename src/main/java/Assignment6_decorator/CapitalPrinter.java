package Assignment6_decorator;



public class CapitalPrinter extends PrinterDecorator{


    public CapitalPrinter(Printer printer){
        super(printer);

    }

    @Override
    public void print(String message){
        String capitalString = message.toUpperCase();
        this.printer.print(capitalString);
    }

}
