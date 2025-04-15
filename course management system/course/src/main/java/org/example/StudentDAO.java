package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Method to get all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Student";
        try (Connection conn = JDBCUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("student_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("date_of_birth")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Method to add a new student
    public void addStudent(Student student) {
        String query = "INSERT INTO Student (first_name, last_name, email, phone_number, date_of_birth) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getPhoneNumber());
            pstmt.setString(5, student.getDateOfBirth());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
