package org.example;

import java.sql.*;

public class PaymentDAO {

    // Add a payment record
    public void addPayment(Payment payment) {
        String query = "INSERT INTO Payment (enrollment_id, amount_paid, payment_date, payment_status) VALUES (?, ?, ?, ?)";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, payment.getEnrollmentId());
            pstmt.setDouble(2, payment.getAmountPaid());
            pstmt.setString(3, payment.getPaymentDate());
            pstmt.setString(4, payment.getPaymentStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get payment details by payment ID
    public Payment getPaymentById(int paymentId) {
        Payment payment = null;
        String query = "SELECT * FROM Payment WHERE payment_id = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, paymentId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                payment = new Payment(
                        rs.getInt("payment_id"),
                        rs.getInt("enrollment_id"),
                        rs.getDouble("amount_paid"),
                        rs.getString("payment_date"),
                        rs.getString("payment_status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }
}
