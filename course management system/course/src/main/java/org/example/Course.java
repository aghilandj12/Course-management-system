package org.example;
public class Course {
    private int courseId;
    private String courseName;
    private String courseType;
    private int durationInWeeks;
    private double fee;
    private int capacity;
    private int availableSlots;

    // Constructor
    public Course(int courseId, String courseName, String courseType, int durationInWeeks, double fee, int capacity, int availableSlots) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseType = courseType;
        this.durationInWeeks = durationInWeeks;
        this.fee = fee;
        this.capacity = capacity;
        this.availableSlots = availableSlots;
    }

    public Course() {

    }

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots = availableSlots;
    }

    // ToString method
    @Override
    public String toString() {
        return "Course Name: " + courseName + "\n" +
                "Course Type: " + courseType + "\n" +
                "Duration: " + durationInWeeks + " weeks\n" +
                "Fee: " + fee + "\n" +
                "Capacity: " + capacity + "\n" +
                "Available Slots: " + availableSlots + "\n";
    }


}
