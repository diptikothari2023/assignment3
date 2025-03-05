// Student.java
// Class representing a Student with input validation

public class Student {
    private String prn;
    private String name;
    private String dob;
    private double marks;

    // Constructor with validation
    public Student(String prn, String name, String dob, double marks) {
        setPrn(prn);
        setName(name);
        this.dob = dob;
        setMarks(marks);
    }

    // Getters and Setters with validation
    public String getPrn() { return prn; }

    public void setPrn(String prn) {
        if (prn.matches("\\d{11}")) {  // Ensures PRN is exactly 11 digits
            this.prn = prn;
        } else {
            throw new IllegalArgumentException("Invalid PRN: Must be exactly 11 digits.");
        }
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name.matches("[A-Za-z ]+")) {  // Ensures name contains only letters and spaces
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid Name: Must contain only letters and spaces.");
        }
    }

    public String getDob() { return dob; }

    public void setDob(String dob) { this.dob = dob; }

    public double getMarks() { return marks; }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 99) {  // Ensures marks are within valid range (0-99)
            this.marks = marks;
        } else {
            throw new IllegalArgumentException("Invalid Marks: Must be between 0 and 99.");
        }
    }

    // Display student details
    public void display() {
        System.out.println("PRN: " + prn + ", Name: " + name + ", DoB: " + dob + ", Marks: " + marks);
    }
}