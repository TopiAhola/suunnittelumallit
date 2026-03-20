package Assignment14_builder;

public class OfficeComputerBuilder implements ComputerBuilder{

   Computer computer;
      public OfficeComputerBuilder() {

        this.computer = new Computer();
      }

@Override
    public void setName() {
        computer.setName("Workstation");
    }

    @Override
    public void setProcessor() {
        computer.setProcessor("Intel XEON");
    }

    @Override
    public void setRam() {
        computer.setRam(128);
    }

    @Override
    public void setGpu() {
        computer.setGpu("Professional GPU");
    }

    @Override
    public void setOs() {
        computer.setOs("Linux");
    }

    @Override
    public void addDrive() {
        computer.addDrive("M.2 SSD");
        computer.addDrive("16TB HDD");
        computer.addDrive("16TB HDD");
    }

    @Override
    public void setChassis() {
        computer.setChassis("Workstation case");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
