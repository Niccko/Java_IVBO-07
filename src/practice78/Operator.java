package practice78;

public class Operator extends Employee implements EmployeePosition {
    Company company;
    public Operator(String firstName, String lastName, double salary, Company company) {
        super(firstName, lastName, salary,company);
    }

    @Override
    public String getJobTitle() {
        return getClass().getName();
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }
}
