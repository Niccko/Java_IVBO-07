package practice78;

public class Operator implements EmployeePosition {
    private Company company;

    public Operator(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return getClass().getName();
    }

    @Override
    public int calcSalary(double baseSalary) {
        return (int)baseSalary;
    }
}
