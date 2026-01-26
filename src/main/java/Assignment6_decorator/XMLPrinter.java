package Assignment6_decorator;



public class XMLPrinter extends PrinterDecorator{


    public XMLPrinter(Printer printer){
        super(printer);

    }

    @Override
    public void print(String message){
        String xmlString = "<message>"+message+"</message>";
        this.printer.print(xmlString);
    }

}
