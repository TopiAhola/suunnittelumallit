package Assignment14_builder;

public class LaptopBuilder implements ComputerBuilder{
      Computer computer;
      public LaptopBuilder() {

        this.computer = new Computer();
      }

    @Override
    public void setName() {
        computer.setName("MacBook Neo");
    }

    @Override
    public void setProcessor() {
        computer.setProcessor("Laptop CPU");
    }

    @Override
    public void setRam() {
        computer.setRam(8);
    }

    @Override
    public void setGpu() {
        computer.setGpu("Integrated GPU");
    }

    @Override
    public void setOs() {
        computer.setOs("Mac OS");
    }

    @Override
    public void addDrive() {
        computer.addDrive("M.2 SSD");
    }

    @Override
    public void setChassis() {
        computer.setChassis("Laptop Chassis");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
