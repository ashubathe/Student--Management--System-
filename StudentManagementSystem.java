import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String branch;
    double marks;

    Student(int rollNo, String name,
            String branch, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.marks = marks;
    }

    String getGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 40) return "D";
        else return "Fail";
    }

    void display() {
        System.out.println("----------------------------");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Branch      : " + branch);
        System.out.println("Marks       : " + marks);
        System.out.println("Percentage  : " + marks + "%");
        System.out.println("Grade       : " + getGrade());
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students =
            new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    static Student findStudent(int rollNo) {
        for (Student s : students) {
            if (s.rollNo == rollNo) {
                return s;
            }
        }
        return null;
    }

    static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = Integer.parseInt(sc.nextLine());

        if (findStudent(roll) != null) {
            System.out.println("Roll number already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter Marks (0-100): ");
        double marks = Double.parseDouble(sc.nextLine());

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks!");
            return;
        }

        students.add(new Student(roll, name, branch, marks));

        System.out.println("Student added successfully!");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = Integer.parseInt(sc.nextLine());

        Student s = findStudent(roll);

        if (s != null) {
            s.display();
        } else {
            System.out.println("Student not found!");
        }
    }

    static void updateStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = Integer.parseInt(sc.nextLine());

        Student s = findStudent(roll);

        if (s != null) {
            System.out.print("Enter New Name: ");
            s.name = sc.nextLine();

            System.out.print("Enter New Branch: ");
            s.branch = sc.nextLine();

            System.out.print("Enter New Marks: ");
            double marks = Double.parseDouble(sc.nextLine());

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks!");
                return;
            }

            s.marks = marks;
            System.out.println("Record updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = Integer.parseInt(sc.nextLine());

        Student s = findStudent(roll);

        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addStudent();
                        break;

                    case 2:
                        displayStudents();
                        break;

                    case 3:
                        searchStudent();
                        break;

                    case 4:
                        updateStudent();
                        break;

                    case 5:
                        deleteStudent();
                        break;

                    case 6:
                        System.out.println("Thank You!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                choice = 0;
            }

        } while (choice != 6);

        sc.close();
    }
}