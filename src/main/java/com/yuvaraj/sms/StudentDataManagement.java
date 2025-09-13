package com.yuvaraj.sms;

import java.util.Scanner;

public class StudentDataManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentMethods methods = new StudentMethods();

        while (true) {
            System.out.println("\n===== Student Data Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> methods.addStudent(sc);
                case 2 -> methods.displayStudents();
                case 3 -> methods.searchStudent(sc);
                case 4 -> methods.updateStudent(sc);
                case 5 -> methods.deleteStudent(sc);
                case 6 -> {
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
