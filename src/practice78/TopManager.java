package practice78;

public class TopManager implements EmployeePosition {
    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return getClass().getName();
    }

    @Override
    public int calcSalary(double baseSalary) {
        if(company.getIncome()>1e7) {
            return (int)(baseSalary*2.5);
        } else {
            return (int)baseSalary;
        }
    }
}
