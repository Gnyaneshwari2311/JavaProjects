package studentmanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class StudentFileService {

    private String fileName = "students.txt";

    // Save students
    public void saveStudents(
            HashMap<Integer, Student> students) {

        try {

            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter(fileName));

            for (Student student : students.values()) {

                writer.println(
                        student.getId() + "," +
                        student.getName() + "," +
                        student.getEmail() + "," +
                        student.getMarks() + "," +
                        student.getAttendance() + "," +
                        student.getStatus() + "," +
                        student.getCourse().getCourseId() + "," +
                        student.getCourse().getCourseName());
            }

            writer.close();

            System.out.println("Student details saved.");

        } catch (IOException e) {

            System.out.println(
                    "Error while saving data.");
        }
    }

    // Load students
    public HashMap<Integer, Student> loadStudents() {

        HashMap<Integer, Student> students =
                new HashMap<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(fileName));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id =
                        Integer.parseInt(data[0]);

                String name = data[1];

                String email = data[2];

                double marks =
                        Double.parseDouble(data[3]);

                int attendance =
                        Integer.parseInt(data[4]);

                StudentStatus status =
                        StudentStatus.valueOf(data[5]);

                int courseId =
                        Integer.parseInt(data[6]);

                String courseName = data[7];

                Course course =
                        new Course(courseId, courseName);

                Student student =
                        new Student(
                                id,
                                name,
                                email,
                                marks,
                                attendance,
                                status,
                                course);

                students.put(id, student);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                    "No previous data found.");

        } catch (Exception e) {

            System.out.println(
                    "Error while loading data.");
        }

        return students;
    }
}