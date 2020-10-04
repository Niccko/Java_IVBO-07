package practice78;

import java.util.*;

public class Company {
    private List<Employee> employees = new LinkedList<>();
    void hire(Employee employee){
        employees.add(employee);

    };
    void hireAll(List<Employee> employeeList){
        employees.addAll(employeeList);
    }
    void fire(int index){
        employees.remove(index);
    }

    double getIncome(){
        return Math.random()*2*1e7;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    List<Employee> getTopSalaryStaff(int count){
        List<Employee> sortedEmployees = new LinkedList<>(employees);
        for (int i = 0; i < ; i++) {
            
        }
        return sortedEmployees;
    }
    List<Employee> getLowSalaryStaff(int count){
        List<Employee> sortedEmployees = new LinkedList<>(employees);
        sortedEmployees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getPosition().calcSalary(o1.getSalary()) > o2.getPosition().calcSalary(o2.getSalary())) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return sortedEmployees;
    }
}
