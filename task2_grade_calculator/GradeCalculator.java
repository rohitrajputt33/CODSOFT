package task2_grade_calculator;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Student Grade Calculator ---");
        
        int numSubjects = 0;
        while (numSubjects <= 0) {
            System.out.print("Enter the number of subjects: ");
            try {
                numSubjects = Integer.parseInt(scanner.nextLine());
                if (numSubjects <= 0) {
                    System.out.println("Number of subjects must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid whole number.");
            }
        }

        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            int marks = -1;
            while (marks < 0 || marks > 100) {
                System.out.print("Enter marks obtained in Subject " + i + " (out of 100): ");
                try {
                    marks = Integer.parseInt(scanner.nextLine());
                    if (marks < 0 || marks > 100) {
                        System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        
        // Calculate Grade
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        // Display Results
        System.out.println("\n--- Final Results ---");
        System.out.println("Total Subjects: " + numSubjects);
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        System.out.println("---------------------");

        scanner.close();
    }
}
