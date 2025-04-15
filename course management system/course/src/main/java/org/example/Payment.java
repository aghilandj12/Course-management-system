package org.example;

public class Payment {
    private int paymentId;
    private int enrollmentId;
    private double amountPaid;
    private String paymentDate;
    private String paymentStatus;

    // Constructor
    public Payment(int paymentId, int enrollmentId, double amountPaid, String paymentDate, String paymentStatus) {
        this.paymentId = paymentId;
        this.enrollmentId = enrollmentId;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

    public Payment() {

    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // ToString method
    @Override
    public String toString() {
        return "Payment [ID=" + paymentId + ", Enrollment ID=" + enrollmentId +
                ", Amount Paid=" + amountPaid + ", Date=" + paymentDate + ", Status=" + paymentStatus + "]";
    }
}
