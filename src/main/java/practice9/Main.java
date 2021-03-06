package practice9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();
        List<Employee> testList = new ArrayList<>();
        Random rnd = new Random();
        String name;
        for (int i = 0; i < 100; i++) {
            name = "Katya";
            if(rnd.nextInt(10)>5) {
                name = "Angelina";
            }
            company.hire(new Employee( name,
                                       "Oronovskaya",
                                        "Moscow",
                                   "8920"+(rnd.nextInt(8999999)+1000000),
                                                rnd.nextInt(100000),
                                                LocalDate.of(rnd.nextInt(50)+1980,rnd.nextInt(11)+1, rnd.nextInt(27)+1)));
        }

        company.doSome(emp -> emp.getSalary()>10000, testList::add);
        for (Employee emp:testList) {
            System.out.println(emp);
        }

        company.doSome(new EmployeeSelector() {
            @Override
            public boolean isNeededEmployee(Employee emp) {
                return emp.getBirthDate().getYear() > 2000;
            }
        }, new EmployeeHandler() {
            @Override
            public void handleEmployees(Employee emp) {
                System.out.println("---.---");
                System.out.println(emp);
            }
        });

        company.doSome(new YearSelector(2010), new YearHandler());

    }
}
