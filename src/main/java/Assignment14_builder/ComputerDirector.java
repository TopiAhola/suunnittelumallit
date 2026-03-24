package Assignment14_builder;

public class ComputerDirector {
    ComputerBuilder computerBuilder;

    public ComputerDirector(){}

    public void setComputerBuilder(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public void buildComputer(){
        this.computerBuilder.setName();
        this.computerBuilder.setOs();
        this.computerBuilder.addDrive();
        this.computerBuilder.setChassis();
        this.computerBuilder.setGpu();
        this.computerBuilder.setProcessor();
        this.computerBuilder.setRam();
    }

    public Computer getComputer(){
        return this.computerBuilder.getComputer();
    }


}
