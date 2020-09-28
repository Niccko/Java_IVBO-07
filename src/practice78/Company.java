package practice78;

import java.util.LinkedList;
import java.util.List;

public class Company {
    private List<Employee> employees = new LinkedList<>();
    void hire(Employee employee){employees.add(employee);};
    void hireAll(List<Employee> employeeList){
        for (Employee emp:
             employeeList) {
            employees.add(emp);
        }
    }
    void fire(String firstName, String lastName){
        employees.removeIf(emp -> emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName));
    }

    double getIncome(){
        return Math.random()*2*1e7;
    }
}
