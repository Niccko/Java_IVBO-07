package practice9;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employees = new ArrayList<>();
    public void hire(Employee employee){
        employees.add(employee);
    }
    public void hireAll(List<Employee> list){
        for (Employee emp:list) {
            hire(emp);
        }
    }

    public void fire(List<Employee> list){
        for (Employee emp:list) {
            employees.remove(emp);
        }
    }

    public void doSome(EmployeeSelector selector, EmployeeHandler handler){
        for (Employee emp:employees) {
            if (selector.isNeededEmployee(emp)) {
                handler.handleEmployees(emp);
            }
        }
    }
}
