import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("STUDENT GRADE CALCULATOR");
        System.out.println("------------------------");
        
        // Get number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        // Validate number of subjects
        while (numSubjects <= 0) {
            System.out.println("Number of subjects must be positive. Please try again.");
            System.out.print("Enter the number of subjects: ");
            numSubjects = scanner.nextInt();
        }
        
        // Array to store marks
        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        
        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            
            // Validate marks (0-100)
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Marks must be between 0 and 100. Please try again.");
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
                marks[i] = scanner.nextInt();
            }
            
            totalMarks += marks[i];
        }
        
        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        
        // Determine grade
        String grade = calculateGrade(averagePercentage);
        
        // Display results
        System.out.println("\nRESULTS");
        System.out.println("-------");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
    
    // Method to calculate grade based on average percentage
    private static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}