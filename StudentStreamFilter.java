import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " - Marks: " + marks;
    }
}

public class StudentStreamFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Anurag", 82.5),
            new Student("Riya", 68.0),
            new Student("Karan", 90.0),
            new Student("Meera", 77.5),
            new Student("Aman", 72.0)
        );

        List<String> topStudents = students.stream()
            .filter(s -> s.marks > 75)
            .sorted(Comparator.comparingDouble(s -> s.marks))
            .map(s -> s.name)
            .collect(Collectors.toList());

        System.out.println("Students scoring above 75% (sorted by marks):");
        topStudents.forEach(System.out::println);
    }
}
