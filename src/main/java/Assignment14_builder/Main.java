package Assignment14_builder;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //make builders
        ComputerBuilder laptopBuider = new LaptopBuilder();
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();

        //make director
        ComputerDirector cd = new ComputerDirector();

        //set builders and get computers
        cd.setComputerBuilder(gamingBuilder);
        cd.buildComputer();
        System.out.println(cd.getComputer());


        cd.setComputerBuilder(officeBuilder);
        cd.buildComputer();
        System.out.println(cd.getComputer());

        cd.setComputerBuilder(laptopBuider);
        cd.buildComputer();
        System.out.println(cd.getComputer());


        //Try building custom computer
        String a = """
                List your components in order:
                 name;
                 processor;
                 ram;
                 gpu;
                 os;
                 drives;
                 chassis;
                """;
        System.out.println(a);

        Scanner input = new Scanner(System.in);
        //BufferedInputStream bis = new BufferedInputStream(System.in);
        String[] arguments = new String[7];
        for (int i = 0; i < 7; i++) {
            if(input.hasNext()){
                arguments[i] = input.nextLine();
                //System.out.println(arguments[i]);
            } else {
                arguments[i] = "default";
            }
        };

        //System.out.println(Arrays.toString(arguments));

        CustomBuilder customBuilder = new CustomBuilder(
                arguments[0],
                arguments[1],
                Integer.parseInt(arguments[2]),
                arguments[3],
                arguments[4],
                new ArrayList<>(List.of(arguments[5])),
                arguments[6]
        );

        cd.setComputerBuilder(customBuilder);
        cd.buildComputer();
        System.out.println(cd.getComputer());


    }
}
