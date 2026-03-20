package Assignment14_builder;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    String name;
    String processor;
    int ram;
    String gpu;
    String os;
    List<String> drives;
    String chassis;

    public Computer(){
        this.drives = new ArrayList<String>();
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void addDrive(String drive) {
        this.drives.add(drive);
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    @Override
    public String toString() {
        return this.name + " " + this.processor + " " + this.ram + " " + this.gpu + " " + this.os + " " + this.drives + " " + this.chassis;
    }

}
