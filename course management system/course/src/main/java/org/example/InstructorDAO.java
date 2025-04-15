package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstructorDAO {

    // Method to get all instructors
    public List<Instructor> getAllInstructors() {
        List<Instructor> instructors = new ArrayList<>();
        String query = "SELECT * FROM Instructor";
        try (Connection conn = JDBCUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                instructors.add(new Instructor(
                        rs.getInt("instructor_id"),
                        rs.getString("instructor_name"),
                        rs.getString("expertise_area"),
                        rs.getString("contact_email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instructors;
    }

    // Method to add a new instructor
    public void addInstructor(Instructor instructor) {
        String query = "INSERT INTO Instructor (instructor_name, expertise_area, contact_email) VALUES (?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, instructor.getInstructorName());
            pstmt.setString(2, instructor.getExpertiseArea());
            pstmt.setString(3, instructor.getContactEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
