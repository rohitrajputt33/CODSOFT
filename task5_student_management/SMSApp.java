package task5_student_management;

import java.util.Scanner;

public class SMSApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem("students.dat");
        boolean exit = false;

        System.out.println("Welcome to the Student Management System");

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a Student");
            System.out.println("2. Edit a Student's Information");
            System.out.println("3. Remove a Student");
            System.out.println("4. Search for a Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudentMenu(scanner, sms);
                    break;
                case "2":
                    editStudentMenu(scanner, sms);
                    break;
                case "3":
                    System.out.print("Enter the roll number of the student to remove: ");
                    String rollToRemove = scanner.nextLine().trim();
                    sms.removeStudent(rollToRemove);
                    break;
                case "4":
                    System.out.print("Enter the roll number of the student to search: ");
                    String rollToSearch = scanner.nextLine().trim();
                    sms.searchStudent(rollToSearch);
                    break;
                case "5":
                    sms.displayAllStudents();
                    break;
                case "6":
                    System.out.println("Exiting the application. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid menu item.");
            }
        }
        scanner.close();
    }

    private static void addStudentMenu(Scanner scanner, StudentManagementSystem sms) {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine().trim();
        
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine().trim();

        if (name.isEmpty() || rollNumber.isEmpty() || grade.isEmpty()) {
            System.out.println("Error: All fields are required. Please try again.");
            return;
        }

        Student student = new Student(name, rollNumber, grade);
        sms.addStudent(student);
    }

    private static void editStudentMenu(Scanner scanner, StudentManagementSystem sms) {
        System.out.print("Enter the roll number of the student to edit: ");
        String rollNumber = scanner.nextLine().trim();
        Student student = sms.getStudent(rollNumber);
        
        if (student == null) {
            System.out.println("Error: Student with roll number '" + rollNumber + "' not found.");
            return;
        }

        System.out.println("Editing student: " + student.getName() + " (Roll No: " + student.getRollNumber() + ")");
        System.out.print("Enter new name (press Enter to keep '" + student.getName() + "'): ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter new grade (press Enter to keep '" + student.getGrade() + "'): ");
        String grade = scanner.nextLine().trim();

        sms.editStudent(rollNumber, name, grade);
    }
}
