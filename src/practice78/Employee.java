package practice78;

public class Employee {
    private String firstName,lastName;
    private double salary;
    EmployeePosition position;
    Company company;

    public Employee(String firstName, String lastName, double salary,Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
