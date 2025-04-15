package org.example;

public class Enrollment {
    private int enrollmentId;
    private int studentId;
    private int courseId;
    private String enrollmentDate;
    private String status;

    // Constructor
    public Enrollment(int enrollmentId, int studentId, int courseId, String enrollmentDate, String status) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public Enrollment() {

    }

    // Getters and Setters
    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Enrollment {" +
                "enrollmentId=" + enrollmentId +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
