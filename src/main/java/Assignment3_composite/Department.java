package Assignment3_composite;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Department> departments;
    private ArrayList<Employee> employees;

    public Department(String name){
        this.name = name;
        this.departments = new ArrayList<Department>();
        this.employees = new ArrayList<Employee>();
    }

    public double getTotalSalary(){
        double total = 0.0;
        for (Department d : departments ) {
            total += d.getTotalSalary();
        }
        for (Employee e : this.employees){
            total += e.getSalary();
        }
        //System.out.println("Salary of "+this.name+": "+total);
        return total;
    }

    public void printSalary(){
        System.out.println("Salary of " +this.name + ": " +this.getTotalSalary());
    }

    public void printOrg(int indent){
        String indentString = "";
        for (int i = 0; i < indent; i++) {
            indentString = indentString.concat("  ");
        }

        System.out.println(indentString+"<"+this.name+", employees: "+this.employees.size()  +">");

        //print employees
        //System.out.println(indentString + "  " +"<Employees>");  //+1 indent
        for(Employee e : this.employees){
            System.out.println(indentString + "    " + e.getName() + ", salary: " + e.getSalary()); //+2 indent
        }
        //System.out.println(indentString + "  " + "</Employees>");

        //print sub departments
        //System.out.println(indentString + "  " +"<SubDepartments>");
        for(Department d : this.departments){
            d.printOrg(indent+1);
        }
        //System.out.println(indentString + "  " + "</SubDepartments>");

        System.out.println(indentString+"</"+this.name+">");
    }

    public void addDepartment(Department newDep){
        this.departments.add(newDep);
    }

    public void removeDepartment(Department dep){
        this.departments.remove(dep);
    }

    public void addEmployee(Employee newEmp){
        this.employees.add(newEmp);
    }

    public void removeEmployee(Employee newEmp){
        this.employees.remove(newEmp);
    }


    public String getName() {
        return name;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
