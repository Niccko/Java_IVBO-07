package practice78;

public class TopManager extends Employee implements EmployeePosition {
    Company company;

    public TopManager(String firstName, String lastName, double salary,Company company) {
        super(firstName, lastName, salary, company);
    }

    @Override
    public String getJobTitle() {
        return getClass().getName();
    }

    @Override
    public double calcSalary(double baseSalary) {
        if(company.getIncome()>1e7) {
            return baseSalary*2.5;
        } else {
            return baseSalary;
        }
    }
}
