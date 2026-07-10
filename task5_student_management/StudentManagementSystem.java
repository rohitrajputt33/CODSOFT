package task5_student_management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;
    private String dataFile;

    public StudentManagementSystem(String dataFile) {
        this.dataFile = dataFile;
        this.students = loadStudentsFromFile();
    }

    public void addStudent(Student student) {
        if (findStudentByRollNumber(student.getRollNumber()) != null) {
            System.out.println("A student with this roll number already exists.");
            return;
        }
        students.add(student);
        saveStudentsToFile();
        System.out.println("Student added successfully!");
    }

    public void removeStudent(String rollNumber) {
        Student student = findStudentByRollNumber(rollNumber);
        if (student != null) {
            students.remove(student);
            saveStudentsToFile();
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchStudent(String rollNumber) {
        Student student = findStudentByRollNumber(rollNumber);
        if (student != null) {
            System.out.println("Student Found: \n" + student.toString());
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("--- Student List ---");
            for (Student s : students) {
                System.out.println(s.toString());
            }
            System.out.println("--------------------");
        }
    }

    private Student findStudentByRollNumber(String rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(rollNumber)) {
                return s;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private List<Student> loadStudentsFromFile() {
        File file = new File(dataFile);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (List<Student>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading student data: " + e.getMessage());
            }
        }
        return new ArrayList<>();
    }

    private void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFile))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
    }
}
