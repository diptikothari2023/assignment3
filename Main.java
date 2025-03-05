// Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StudentManager manager = new StudentManager();
            int choice;

            // Menu-driven approach
            do {
                System.out.println("\nStudent Management System");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Search Student by PRN");
                System.out.println("4. Search Student by Name");
                System.out.println("5. Search Student by Position");
                System.out.println("6. Update Student Details");
                System.out.println("7. Delete Student");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> { // Add Student
                        System.out.print("Enter PRN: ");
                        String prn = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Date of Birth (DD/MM/YYYY): ");
                        String dob = scanner.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = scanner.nextDouble();
                        manager.addStudent(prn, name, dob, marks);
                    }

                    case 2 -> manager.displayStudents(); // Display Students

                    case 3 -> { // Search by PRN
                        System.out.print("Enter PRN: ");
                        String prn = scanner.nextLine();
                        Student found = manager.searchByPrn(prn);
                        if (found != null) found.display();
                        else System.out.println("Student not found.");
                    }

                    case 4 -> { // Search by Name
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        var studentsByName = manager.searchByName(name);
                        if (!studentsByName.isEmpty()) {
                            for (Student s : studentsByName) {
                                s.display();
                            }
                        } else {
                            System.out.println("No student found with this name.");
                        }
                    }

                    case 5 -> { // Search by Position
                        System.out.print("Enter Position (Index starts from 0): ");
                        int pos = scanner.nextInt();
                        Student s = manager.searchByPosition(pos);
                        if (s != null) s.display();
                        else System.out.println("Invalid position.");
                    }

                    case 6 -> { // Update Student
                        System.out.print("Enter PRN to update: ");
                        String prn = scanner.nextLine();
                        System.out.print("Enter new Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new Date of Birth: ");
                        String newDob = scanner.nextLine();
                        System.out.print("Enter new Marks: ");
                        double newMarks = scanner.nextDouble();
                        if (manager.updateStudent(prn, newName, newDob, newMarks))
                            System.out.println("Student updated successfully.");
                        else
                            System.out.println("Student not found.");
                    }

                    case 7 -> { // Delete Student
                        System.out.print("Enter PRN to delete: ");
                        String prn = scanner.nextLine();
                        if (manager.deleteStudent(prn))
                            System.out.println("Student deleted successfully.");
                        else
                            System.out.println("Student not found.");
                    }

                    case 0 -> System.out.println("Exiting...");

                    default -> System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 0);
        } // Scanner automatically closed here
    }
}