package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    // Method to get all courses
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM Course";
        try (Connection conn = JDBCUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getString("course_type"),
                        rs.getInt("duration_in_weeks"),
                        rs.getDouble("fee"),
                        rs.getInt("capacity"),
                        rs.getInt("available_slots")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    // Method to add a new course
    public void addCourse(Course course) {
        String query = "INSERT INTO Course (course_name, course_type, duration_in_weeks, fee, capacity, available_slots) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, course.getCourseName());
            pstmt.setString(2, course.getCourseType());
            pstmt.setInt(3, course.getDurationInWeeks());
            pstmt.setDouble(4, course.getFee());
            pstmt.setInt(5, course.getCapacity());
            pstmt.setInt(6, course.getAvailableSlots());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
