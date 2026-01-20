package Assignment3_composite;

public class Main {
    public static void main(String[] args) {

        Department organization = new Department("Organization");

        Department rd = new Department("R&D");
        Department marketing = new Department("Marketing");
        Department gMarketing = new Department("Global Marketing");
        Department lMarketing = new Department("Local Marketing");
        Department manufacturing = new Department("Manufacturing");
        Department logistics = new Department("Logistics");

        //add sub departments
        marketing.addDepartment(gMarketing);
        marketing.addDepartment(lMarketing);
        manufacturing.addDepartment(logistics);

        //add departments to org
        organization.addDepartment(rd);
        organization.addDepartment(marketing);
        organization.addDepartment(manufacturing);

        //add Employees to departments
        Employee[] newEmployees = {
                new Employee("Aa", 1000.0),
                new Employee("Bb", 1500.0),
                new Employee("Cc", 800.0),
                new Employee("Dd", 6000.0),
                new Employee("Ee", 4567.7),
                new Employee("Ff", 4900.5),
                new Employee("Gg", 100.0),
                new Employee("Hh", 5678.0)
        };
        rd.addEmployee(newEmployees[0]);
        marketing.addEmployee(newEmployees[1]);
        gMarketing.addEmployee(newEmployees[2]);
        lMarketing.addEmployee(newEmployees[3]);
        manufacturing.addEmployee(newEmployees[4]);
        logistics.addEmployee(newEmployees[5]);
        organization.addEmployee(newEmployees[6]);
        logistics.addEmployee(newEmployees[7]);


        //print org structure
        organization.printOrg(0);

        //print salaries
        organization.printSalary();
        System.out.println();

        //fire an Employee
        lMarketing.removeEmployee(newEmployees[3]);
        organization.printOrg(0);
        organization.printSalary();     //salary should drp by 6000
        System.out.println();

        //remove a department
        organization.removeDepartment(manufacturing);
        organization.printOrg(0);
        organization.printSalary();
    }
}
