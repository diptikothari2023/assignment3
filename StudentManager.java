// StudentManager.java
// Class to manage student records

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    // Constructor
    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(String prn, String name, String dob, double marks) {
        students.add(new Student(prn, name, dob, marks));
        System.out.println("Student added successfully.");
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            s.display();
        }
    }

    // Search student by PRN
    public Student searchByPrn(String prn) {
        for (Student s : students) {
            if (s.getPrn().equalsIgnoreCase(prn)) {
                return s;
            }
        }
        return null;
    }

    // Search student by Name
    public ArrayList<Student> searchByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                result.add(s);
            }
        }
        return result;
    }

    // Search student by Position
    public Student searchByPosition(int pos) {
        if (pos >= 0 && pos < students.size()) {
            return students.get(pos);
        }
        return null;
    }

    // Update student details
    public boolean updateStudent(String prn, String newName, String newDob, double newMarks) {
        Student s = searchByPrn(prn);
        if (s != null) {
            s.setName(newName);
            s.setDob(newDob);
            s.setMarks(newMarks);
            return true;
        }
        return false;
    }

    // Delete student by PRN
    public boolean deleteStudent(String prn) {
        Student s = searchByPrn(prn);
        if (s != null) {
            students.remove(s);
            return true;
        }
        return false;
    }
}