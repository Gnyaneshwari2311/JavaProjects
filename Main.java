package studentmanagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService service =
                new StudentService();

        StudentFileService fileService =
                new StudentFileService();

        // Load old data
        service.setStudents(
                fileService.loadStudents());

        int choice;

        do {

            System.out.println();
            System.out.println(
                    "===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search By ID");
            System.out.println("4. Search By Name");
            System.out.println("5. Update Marks");
            System.out.println("6. Update Attendance");
            System.out.println("7. Remove Student");
            System.out.println("8. Display Topper");
            System.out.println("9. Save Students");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter marks: ");
                    double marks = scanner.nextDouble();

                    System.out.print(
                            "Enter attendance: ");

                    int attendance =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter status (ACTIVE/INACTIVE/COMPLETED): ");

                    String statusText =
                            scanner.nextLine();

                    StudentStatus status =
                            StudentStatus.valueOf(
                                    statusText.toUpperCase());

                    System.out.print(
                            "Enter course ID: ");

                    int courseId =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter course name: ");

                    String courseName =
                            scanner.nextLine();

                    Course course =
                            new Course(
                                    courseId,
                                    courseName);

                    Student student =
                            new Student(
                                    id,
                                    name,
                                    email,
                                    marks,
                                    attendance,
                                    status,
                                    course);

                    service.addStudent(student);

                    break;

                case 2:

                    service.displayStudents();

                    break;

                case 3:

                    System.out.print(
                            "Enter student ID: ");

                    int searchId =
                            scanner.nextInt();

                    Student foundStudent =
                            service.searchById(searchId);

                    if (foundStudent != null) {

                        System.out.println(foundStudent);

                    } else {

                        System.out.println(
                                "Student not found.");
                    }

                    break;

                case 4:

                    System.out.print(
                            "Enter student name: ");

                    String searchName =
                            scanner.nextLine();

                    service.searchByName(searchName);

                    break;

                case 5:

                    System.out.print(
                            "Enter student ID: ");

                    int marksId =
                            scanner.nextInt();

                    System.out.print(
                            "Enter new marks: ");

                    double newMarks =
                            scanner.nextDouble();

                    service.updateMarks(
                            marksId,
                            newMarks);

                    break;

                case 6:

                    System.out.print(
                            "Enter student ID: ");

                    int attendanceId =
                            scanner.nextInt();

                    System.out.print(
                            "Enter new attendance: ");

                    int newAttendance =
                            scanner.nextInt();

                    service.updateAttendance(
                            attendanceId,
                            newAttendance);

                    break;

                case 7:

                    System.out.print(
                            "Enter student ID: ");

                    int removeId =
                            scanner.nextInt();

                    service.removeStudent(removeId);

                    break;

                case 8:

                    service.displayTopper();

                    break;

                case 9:

                    fileService.saveStudents(
                            service.getStudents());

                    break;

                case 10:

                    fileService.saveStudents(
                            service.getStudents());

                    System.out.println(
                            "Program closed.");

                    break;

                default:

                    System.out.println(
                            "Invalid choice.");
                }

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Error: " + e.getMessage());

            } catch (Exception e) {

                System.out.println(
                        "Please enter valid input.");

                scanner.nextLine();
            }

        } while (choice != 10);

        scanner.close();
    }
}