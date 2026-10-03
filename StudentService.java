package studentmanagement;

import java.util.HashMap;

public class StudentService {

    private HashMap<Integer, Student> students;

    public StudentService() {

        students = new HashMap<>();
    }

    // Add student
    public void addStudent(Student student) {

        if (students.containsKey(student.getId())) {

            throw new IllegalArgumentException(
                    "Student ID already exists");
        }

        if (student.getMarks() < 0 ||
                student.getMarks() > 100) {

            throw new IllegalArgumentException(
                    "Marks must be between 0 and 100");
        }

        if (student.getAttendance() < 0 ||
                student.getAttendance() > 100) {

            throw new IllegalArgumentException(
                    "Attendance must be between 0 and 100");
        }

        students.put(student.getId(), student);

        System.out.println("Student added successfully.");
    }

    // Display all students
    public void displayStudents() {

        if (students.isEmpty()) {

            System.out.println("No students found.");
            return;
        }

        for (Student student : students.values()) {

            System.out.println(student);
        }
    }

    // Search by ID
    public Student searchById(int id) {

        return students.get(id);
    }

    // Search by name
    public void searchByName(String name) {

        boolean found = false;

        for (Student student : students.values()) {

            if (student.getName().equalsIgnoreCase(name)) {

                System.out.println(student);
                found = true;
            }
        }

        if (!found) {

            System.out.println("Student not found.");
        }
    }

    // Update marks
    public void updateMarks(int id, double marks) {

        Student student = students.get(id);

        if (student == null) {

            System.out.println("Student not found.");
            return;
        }

        if (marks < 0 || marks > 100) {

            throw new IllegalArgumentException(
                    "Marks must be between 0 and 100");
        }

        student.setMarks(marks);

        System.out.println("Marks updated successfully.");
    }

    // Update attendance
    public void updateAttendance(int id, int attendance) {

        Student student = students.get(id);

        if (student == null) {

            System.out.println("Student not found.");
            return;
        }

        if (attendance < 0 || attendance > 100) {

            throw new IllegalArgumentException(
                    "Attendance must be between 0 and 100");
        }

        student.setAttendance(attendance);

        System.out.println(
                "Attendance updated successfully.");
    }

    // Remove student
    public void removeStudent(int id) {

        if (students.containsKey(id)) {

            students.remove(id);

            System.out.println(
                    "Student removed successfully.");

        } else {

            System.out.println("Student not found.");
        }
    }

    // Display topper
    public void displayTopper() {

        if (students.isEmpty()) {

            System.out.println("No students found.");
            return;
        }

        Student topper = null;

        for (Student student : students.values()) {

            if (topper == null ||
                    student.getMarks() > topper.getMarks()) {

                topper = student;
            }
        }

        System.out.println("Topper:");
        System.out.println(topper);
    }

    // Get all students
    public HashMap<Integer, Student> getStudents() {

        return students;
    }

    // Set students
    public void setStudents(
            HashMap<Integer, Student> students) {

        this.students = students;
    }
}