package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Course Enrollment System");
            System.out.println("Select your role:");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            int roleChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (roleChoice) {
                case 1:
                    adminMenu(scanner);
                    break;
                case 2:
                    studentMenu(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Admin Menu
    public static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Add a new course");
            System.out.println("2. View all courses");
            System.out.println("3. Register a new student");
            System.out.println("4. Exit to main menu");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCourse(scanner);
                    break;
                case 2:
                    viewAllCourses();
                    break;
                case 3:
                    registerStudent(scanner);
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    return; // Exit to main menu
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Student Menu
    public static void studentMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nStudent Menu");
            System.out.println("1. View all courses");
            System.out.println("2. Enroll in a course");
            System.out.println("3. Process a payment");
            System.out.println("4. Exit to main menu");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAllCourses();
                    break;
                case 2:
                    enrollStudent(scanner);
                    break;
                case 3:
                    processPayment(scanner);
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    return; // Exit to main menu
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Add a new course
    public static void addCourse(Scanner scanner) {
        System.out.println("\nEnter course details:");

        System.out.print("Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Course Type (Online/Offline): ");
        String courseType = scanner.nextLine();

        System.out.print("Duration (in weeks): ");
        int durationInWeeks = scanner.nextInt();

        System.out.print("Fee: ");
        double fee = scanner.nextDouble();

        System.out.print("Capacity: ");
        int capacity = scanner.nextInt();

        System.out.print("Available Slots: ");
        int availableSlots = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Creating a new course object
        Course course = new Course(0, courseName, courseType, durationInWeeks, fee, capacity, availableSlots);

        // Inserting the course into the database
        CourseDAO courseDAO = new CourseDAO();
        courseDAO.addCourse(course);

        System.out.println("Course added successfully!");
    }

    // View all courses
    public static void viewAllCourses() {
        CourseDAO courseDAO = new CourseDAO();
        List<Course> courses = courseDAO.getAllCourses();

        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    // Register a new student
    public static void registerStudent(Scanner scanner) {
        System.out.println("\nEnter student details:");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();

        // Creating a new student object
        Student student = new Student(0, firstName, lastName, email, phoneNumber, dateOfBirth);

        // Inserting the student into the database
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(student);

        System.out.println("Student registered successfully!");
    }

    // Enroll a student in a course
    public static void enrollStudent(Scanner scanner) {
        System.out.print("\nEnter Student ID: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter Course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Enrollment Date (YYYY-MM-DD): ");
        String enrollmentDate = scanner.nextLine();

        // Adding the enrollment record to the database
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
        enrollmentDAO.enrollStudent(studentId, courseId, enrollmentDate);

        System.out.println("Student enrolled successfully!");
    }

    // Process a payment
    public static void processPayment(Scanner scanner) {
        System.out.print("\nEnter Enrollment ID: ");
        int enrollmentId = scanner.nextInt();

        System.out.print("Enter Amount Paid: ");
        double amountPaid = scanner.nextDouble();

        scanner.nextLine(); // Consume newline
        System.out.print("Enter Payment Date (YYYY-MM-DD): ");
        String paymentDate = scanner.nextLine();

        System.out.print("Enter Payment Status (Pending/Completed): ");
        String paymentStatus = scanner.nextLine();

        // Creating a payment object
        Payment payment = new Payment(0, enrollmentId, amountPaid, paymentDate, paymentStatus);

        // Adding the payment record to the database
        PaymentDAO paymentDAO = new PaymentDAO();
        paymentDAO.addPayment(payment);

        System.out.println("Payment processed successfully!");
    }
}
