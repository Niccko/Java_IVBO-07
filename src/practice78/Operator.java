package practice78;

public class Operator implements EmployeePosition {
    Company company;

    public Operator(Company company) {
        this.company = company;
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
