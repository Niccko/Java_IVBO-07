package practice78;

public class Manager implements EmployeePosition {
    private Company company;
    double income;
    public Manager(Company company) {
        income = Math.random()*25000+115000;
        this.company = company;
    }

    public double getIncome() {
        return income;
    }

    @Override
    public int calcSalary(double baseSalary) {
        return (int)(baseSalary+0.05*income);
    }

    @Override
    public String getJobTitle() {
        return getClass().getName();
    }
}
