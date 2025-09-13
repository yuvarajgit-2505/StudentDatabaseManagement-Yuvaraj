package com.yuvaraj.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentMethods {

    // Add Student
    public void addStudent(Scanner sc) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO students (id, name, age, address, email) VALUES (?, ?, ?, ?, ?)")) {

            StudentDatas student = new StudentDatas();

            System.out.print("Enter Student ID: ");
            student.setId(sc.nextInt());
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            student.setName(sc.nextLine());

            System.out.print("Enter Student Age: ");
            student.setAge(sc.nextInt());
            sc.nextLine();

            System.out.print("Enter Student Address: ");
            student.setAddress(sc.nextLine());

            System.out.print("Enter Student Email: ");
            student.setEmail(sc.nextLine());

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getEmail());

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Student added successfully!" : "Failed to add student.");

        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // Display Students
    public void displayStudents() {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nStudent List:");
            while (rs.next()) {
                StudentDatas student = new StudentDatas(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("address"),
                        rs.getString("email")
                );
                System.out.println(student);
            }
        } catch (Exception e) {
            System.out.println("Error displaying students: " + e.getMessage());
        }
    }

    // Search Student
    public void searchStudent(Scanner sc) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter Student ID to search: ");
            int id = sc.nextInt();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                StudentDatas student = new StudentDatas(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("address"),
                        rs.getString("email")
                );
                System.out.println("Student Found:");
                System.out.println(student);
            } else {
                System.out.println("Student not found.");
            }
        } catch (Exception e) {
            System.out.println("Error searching student: " + e.getMessage());
        }
    }

    // Update Student
    public void updateStudent(Scanner sc) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter Student ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            StudentDatas student = new StudentDatas();
            student.setId(id);

            System.out.print("Enter New Name: ");
            student.setName(sc.nextLine());

            System.out.print("Enter New Age: ");
            student.setAge(sc.nextInt());
            sc.nextLine();

            System.out.print("Enter New Address: ");
            student.setAddress(sc.nextLine());

            System.out.print("Enter New Email: ");
            student.setEmail(sc.nextLine());

            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE students SET name = ?, age = ?, address = ?, email = ? WHERE id = ?"
            );
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getAddress());
            ps.setString(4, student.getEmail());
            ps.setInt(5, student.getId());

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Student updated successfully!" : "Student not found.");

        } catch (Exception e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    // Delete Student
    public void deleteStudent(Scanner sc) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id = ?");
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Student deleted successfully!" : "Student not found.");

        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
