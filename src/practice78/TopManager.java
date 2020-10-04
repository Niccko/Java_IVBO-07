package practice78;

public class TopManager implements EmployeePosition {
    Company company;

    public TopManager(Company company) {
        this.company = company;
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
