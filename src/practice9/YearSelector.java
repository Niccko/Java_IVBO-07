package practice9;

public class YearSelector implements EmployeeSelector {
    private int year;

    public YearSelector(int year) {
        this.year = year;
    }

    @Override
    public boolean isNeededEmployee(Employee emp) {
        return emp.getBirthDate().getYear()>year;
    }
}
