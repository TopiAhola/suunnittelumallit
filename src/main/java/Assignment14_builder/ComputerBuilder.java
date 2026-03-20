package Assignment14_builder;

import java.util.List;

public interface ComputerBuilder {
    public void setName();

    public void setProcessor();

    public void setRam();

    public void setGpu();

    public void setOs();

    public void addDrive();

    public void setChassis();

    public Computer getComputer();

}
