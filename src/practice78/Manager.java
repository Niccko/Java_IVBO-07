package practice78;

public class Manager extends Employee implements EmployeePosition {


    public Manager(String firstName, String lastName, double salary, Company company) {
        super(firstName, lastName, salary,company);
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary+Math.random()*1250+5750;
    }

    @Override
    public String getJobTitle() {
        return getClass().getName();
    }
}
