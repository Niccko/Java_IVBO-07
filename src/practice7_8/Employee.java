package practice7_8;

public class Employee{
    private String firstName,lastName;
    private double salary;
    private EmployeePosition position;
    private int id;

    public Employee(String firstName, String lastName, double salary, EmployeePosition position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getEmployeeSalary(){ return position.calcSalary(salary); }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + position.calcSalary(salary) +
                ", position=" + position +
                '}';
    }
}
