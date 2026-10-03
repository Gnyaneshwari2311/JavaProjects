package studentmanagement;

public class Course {

    private int courseId;
    private String courseName;

    public Course(int courseId, String courseName) {

        this.courseId = courseId;
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {

        return courseName;
    }
}