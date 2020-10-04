package practice78;

import java.util.*;

public class Company {
    private List<Employee> employees = new LinkedList<>();
    private Vector<Integer> employeeId = new Vector<>();

    public Vector<Integer> getEmployeeId() { return employeeId; }

    public List<Employee> getEmployees() { return employees; }

    void hire(Employee employee){
        int id = (int)(Math.random()*10000);
        while(employeeId.contains(id)) id = (int)(Math.random()*10000);
        employee.setId(id);
        employeeId.add(id);
        employees.add(employee);
    };

    Employee getEmployeeById(int id){
        for (Employee emp:employees) {
            if(emp.getId() == id) return emp;
        }
        return null;
    }
    void hireAll(List<Employee> employeeList){
        employees.addAll(employeeList);
    }

    void fire(int id){
        employees.remove(getEmployeeById(id));
        employeeId.remove((Integer)id);
    }

    double getIncome(){
        double income = 0;
        for (Employee employee:employees) {
            if(employee.getPosition() instanceof Manager){
                income+=((Manager) employee.getPosition()).getIncome();
            }
        }
        return income;
    }

    List<Employee> getTopSalaryStaff(int count){
        if(count<=0){
            System.out.println("Invalid employees number");
            return Collections.emptyList();
        }
        List<Employee> sEmp = new LinkedList<>(employees);
        Employee t;
        int i, j;
        for (i = 0; i < sEmp.size(); i++) {
            t = sEmp.get(i);
            for (j = i - 1; j >= 0 && sEmp.get(j).getEmployeeSalary() < t.getEmployeeSalary(); j--)
                sEmp.set(j+1,sEmp.get(j));
            sEmp.set(j+1,t);
        }
        return sEmp.subList(0,count);
    }
    List<Employee> getLowSalaryStaff(int count){
        if(count<=0){
            System.out.println("Invalid employees number");
            return Collections.emptyList();
        }
        List<Employee> sEmp = new LinkedList<>(employees);
        Employee t;
        int i, j;
        for (i = 0; i < sEmp.size(); i++) {
            t = sEmp.get(i);
            for (j = i - 1; j >= 0 && sEmp.get(j).getEmployeeSalary() > t.getEmployeeSalary(); j--)
                sEmp.set(j+1,sEmp.get(j));
            sEmp.set(j+1,t);
        }
        return sEmp.subList(0,count);
    }
}
