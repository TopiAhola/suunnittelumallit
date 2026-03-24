package Assignment14_builder;

import java.util.List;

public class CustomBuilder implements ComputerBuilder {
    Computer computer;

    String name;
    String processor;
    int ram;
    String gpu;
    String os;
    List<String> drives;
    String chassis;


    public CustomBuilder(String name, String processor, int ram, String gpu, String os, List<String> drives, String chassis) {
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.gpu = gpu;
        this.os = os;
        this.drives = drives;
        this.chassis = chassis;

        this.computer = new Computer();
    }



    @Override
    public void setName() {
        computer.setName(name);
    }

    @Override
    public void setProcessor() {
        computer.setProcessor(processor);
    }

    @Override
    public void setRam() {
        computer.setRam(ram);
    }

    @Override
    public void setGpu() {
        computer.setGpu(gpu);
    }

    @Override
    public void setOs() {
        computer.setOs(os);
    }

    @Override
    public void addDrive() {
        computer.addDrive(drives.toString());
    }

    @Override
    public void setChassis() {
        computer.setChassis(chassis);
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
