import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Double> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    double getAverage() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double g : grades) sum += g;
        return sum / grades.size();
    }

    double getHighest() {
        double high = Double.MIN_VALUE;
        for (double g : grades) if (g > high) high = g;
        return high;
    }

    double getLowest() {
        double low = Double.MAX_VALUE;
        for (double g : grades) if (g < low) low = g;
        return low;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("===== STUDENT GRADE TRACKER =====");

        while (true) {
            System.out.print("\nEnter Student Name (or type 'exit' to finish): ");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("exit")) break;

            Student s = new Student(name);

            System.out.print("Enter number of subjects: ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print("Enter grade for subject " + (i + 1) + ": ");
                double grade = sc.nextDouble();
                s.grades.add(grade);
            }
            sc.nextLine(); // consume newline
            students.add(s);
        }

        // Display summary report
        System.out.println("\n===== SUMMARY REPORT =====");
        for (Student s : students) {
            System.out.println("\nStudent: " + s.name);
            System.out.println("Grades: " + s.grades);
            System.out.printf("Average Score: %.2f\n", s.getAverage());
            System.out.printf("Highest Score: %.2f\n", s.getHighest());
            System.out.printf("Lowest Score: %.2f\n", s.getLowest());
        }

        sc.close();
        System.out.println("\n===== END OF REPORT =====");
    }
}

