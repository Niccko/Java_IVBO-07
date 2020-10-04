package practice78;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company gogle = new Company();
        for (int i = 0; i < 180; i++) {
            EmployeePosition empPosition = new Operator(gogle);
            gogle.hire(new Employee("Michael", "Rykhlov", (int)(Math.random()*100000+50000),empPosition));
        }
        for (int i = 0; i < 80; i++) {
            EmployeePosition empPosition = new Manager(gogle);
            gogle.hire(new Employee("Micha", "Rykhlov", (int)(Math.random()*50000+50000),empPosition));
        }
        for (int i = 0; i < 10; i++) {
            EmployeePosition empPosition = new TopManager(gogle);
            gogle.hire(new Employee("Miki", "Rykhlov", (int)(Math.random()*200000+100000),empPosition));
        }
        System.out.println("\nTop salary staff:");
        List<Employee> tempEmployees = gogle.getTopSalaryStaff(15);
        for (Employee emp: tempEmployees) {
            System.out.println(emp.getEmployeeSalary()+"   id = "+emp.getId() + "   "+emp.getPosition().getJobTitle());
        }

        System.out.println("\nLow salary staff:");
        tempEmployees = gogle.getLowSalaryStaff(30);
        for (Employee emp: tempEmployees) {
            System.out.println(emp.getEmployeeSalary()+"   id = "+emp.getId() + "   "+emp.getPosition().getJobTitle());
        }

        int empSize = gogle.getEmployees().size();
        for (int i = 0; i < empSize; i++) {
            int id = gogle.getEmployeeId().get((int)(Math.random()*gogle.getEmployeeId().size()));
            gogle.fire(id);
        }

        System.out.println("\nTop salary staff after after dismissal:");
        tempEmployees = gogle.getTopSalaryStaff(15);
        for (Employee emp: tempEmployees) {
            System.out.println(emp.getEmployeeSalary()+"   id = "+emp.getId() + "   "+emp.getPosition().getJobTitle());
        }

        System.out.println("\nLow salary staff after dismissal:");
        tempEmployees = gogle.getLowSalaryStaff(30);
        for (Employee emp: tempEmployees) {
            System.out.println(emp.getEmployeeSalary()+"   id = "+emp.getId() + "   "+emp.getPosition().getJobTitle());
        }
    }
}
