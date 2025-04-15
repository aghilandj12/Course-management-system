package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {

    // Method to enroll a student in a course
    public int enrollStudent(int studentId, int courseId, String enrollmentDate) {
        String query = "INSERT INTO Enrollment (student_id, course_id, enrollment_date, status) VALUES (?, ?, ?, ?)";
        int enrollmentId = -1; // Default value if enrollment fails
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, studentId);
            pstmt.setInt(2, courseId);
            pstmt.setString(3, enrollmentDate);
            pstmt.setString(4, "Enrolled");

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        enrollmentId = rs.getInt(1);
                        System.out.println("Enrollment successful! Enrollment ID: " + enrollmentId);
                    }
                }
            } else {
                System.err.println("Enrollment failed. No rows affected.");
            }
        } catch (SQLException e) {
            System.err.println("Error enrolling student: " + e.getMessage());
            e.printStackTrace();
        }
        return enrollmentId; // Return the generated enrollment ID
    }

    // Method to retrieve all enrollments
    public List<Enrollment> getAllEnrollments() {
        List<Enrollment> enrollments = new ArrayList<>();
        String query = "SELECT * FROM Enrollment";
        try (Connection conn = JDBCUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                enrollments.add(new Enrollment(
                        rs.getInt("enrollment_id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getString("enrollment_date"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving enrollments: " + e.getMessage());
            e.printStackTrace();
        }
        return enrollments;
    }

    // Method to retrieve a specific enrollment by ID
    public Enrollment getEnrollmentById(int enrollmentId) {
        Enrollment enrollment = null;
        String query = "SELECT * FROM Enrollment WHERE enrollment_id = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, enrollmentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    enrollment = new Enrollment(
                            rs.getInt("enrollment_id"),
                            rs.getInt("student_id"),
                            rs.getInt("course_id"),
                            rs.getString("enrollment_date"),
                            rs.getString("status")
                    );
                } else {
                    System.out.println("No enrollment found with ID: " + enrollmentId);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving enrollment: " + e.getMessage());
            e.printStackTrace();
        }
        return enrollment;
    }
}
