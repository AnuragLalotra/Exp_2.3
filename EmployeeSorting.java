import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return name + " - Age: " + age + ", Salary: " + salary;
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Anurag", 25, 50000));
        employees.add(new Employee("Riya", 22, 60000));
        employees.add(new Employee("Karan", 30, 45000));
        employees.add(new Employee("Meera", 28, 75000));

        System.out.println("Sorted by Name:");
        employees.sort((e1, e2) -> e1.name.compareToIgnoreCase(e2.name));
        employees.forEach(System.out::println);

        System.out.println("\nSorted by Age:");
        employees.sort((e1, e2) -> Integer.compare(e1.age, e2.age));
        employees.forEach(System.out::println);

        System.out.println("\nSorted by Salary (Descending):");
        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));
        employees.forEach(System.out::println);
    }
}
