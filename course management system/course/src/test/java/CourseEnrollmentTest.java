import org.example.Course;
import org.example.Student;
import org.example.Enrollment;
import org.example.Payment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseEnrollmentTest {

    @Test
    public void testCourse() {
        // Create a new Course object and set values
        Course course = new Course();
        course.setCourseId(1);
        course.setCourseName("Java Programming");
        course.setCourseType("Online");
        course.setDurationInWeeks(12);
        course.setFee(20000.0);
        course.setCapacity(30);
        course.setAvailableSlots(25);

        // Assertions to verify the course properties
        assertEquals(1, course.getCourseId());
        assertEquals("Java Programming", course.getCourseName());
        assertEquals("Online", course.getCourseType());
        assertEquals(12, course.getDurationInWeeks());
        assertEquals(20000.0, course.getFee());
        assertEquals(30, course.getCapacity());
        assertEquals(25, course.getAvailableSlots());
    }

    @Test
    public void testStudent() {
        // Create a new Student object and set values
        Student student = new Student();
        student.setStudentId(101);
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setEmail("john.doe@example.com");
        student.setPhoneNumber("1234567890");
        student.setDateOfBirth("1995-06-15");

        // Assertions to verify the student properties
        assertEquals(101, student.getStudentId());
        assertEquals("John", student.getFirstName());
        assertEquals("Doe", student.getLastName());
        assertEquals("john.doe@example.com", student.getEmail());
        assertEquals("1234567890", student.getPhoneNumber());
        assertEquals("1995-06-15", student.getDateOfBirth());
    }

    @Test
    public void testEnrollment() {
        // Create a new Enrollment object and set values
        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentId(5001);
        enrollment.setStudentId(101);
        enrollment.setCourseId(1);
        enrollment.setEnrollmentDate("2024-11-12");

        // Assertions to verify the enrollment properties
        assertEquals(5001, enrollment.getEnrollmentId());
        assertEquals(101, enrollment.getStudentId());
        assertEquals(1, enrollment.getCourseId());
        assertEquals("2024-11-12", enrollment.getEnrollmentDate());
    }

    @Test
    public void testPayment() {
        // Create a new Payment object and set values
        Payment payment = new Payment();
        payment.setPaymentId(2001);
        payment.setEnrollmentId(5001);
        payment.setAmountPaid(20000.0);
        payment.setPaymentDate("2024-11-12");
        payment.setPaymentStatus("Completed");

        // Assertions to verify the payment properties
        assertEquals(2001, payment.getPaymentId());
        assertEquals(5001, payment.getEnrollmentId());
        assertEquals(20000.0, payment.getAmountPaid());
        assertEquals("2024-11-12", payment.getPaymentDate());
        assertEquals("Completed", payment.getPaymentStatus());
    }
}
