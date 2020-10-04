package practice78;

public class Manager implements EmployeePosition {
    Company company;

    public Manager(Company company) {
        this.company = company;
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
