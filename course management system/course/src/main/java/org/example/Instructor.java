package org.example;

public class Instructor {
    private int instructorId;
    private String instructorName;
    private String expertiseArea;
    private String contactEmail;

    // Constructor
    public Instructor(int instructorId, String instructorName, String expertiseArea, String contactEmail) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.expertiseArea = expertiseArea;
        this.contactEmail = contactEmail;
    }

    // Getters and Setters
    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getExpertiseArea() {
        return expertiseArea;
    }

    public void setExpertiseArea(String expertiseArea) {
        this.expertiseArea = expertiseArea;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    // ToString method
    @Override
    public String toString() {
        return "Instructor [ID=" + instructorId + ", Name=" + instructorName +
                ", Expertise=" + expertiseArea + ", Email=" + contactEmail + "]";
    }
}
