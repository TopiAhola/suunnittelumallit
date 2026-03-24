package Assignment14_builder;

public class GamingComputerBuilder implements ComputerBuilder {


   Computer computer;
      public GamingComputerBuilder() {

        this.computer = new Computer();
      }


@Override
    public void setName() {
        computer.setName("Gaming Computer");
    }

    @Override
    public void setProcessor() {
        computer.setProcessor("I5 4430");
    }

    @Override
    public void setRam() {
        computer.setRam(8);
    }

    @Override
    public void setGpu() {
        computer.setGpu("GTX 1060");
    }

    @Override
    public void setOs() {
        computer.setOs("Windows 10");
    }

    @Override
    public void addDrive() {
        computer.addDrive("SSD");
    }

    @Override
    public void setChassis() {
        computer.setChassis("Cardboard box");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }


}
