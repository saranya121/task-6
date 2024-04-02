package task6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import advanceJava.task3.Student;

public class JDBCConnectivity {
	public static void main(String args[]) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empl", "root", "password");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the no of Data is to be inserted:");
			int n = sc.nextInt();
			int updatedCount = 0;
			/*
			 * Get the student name from the user
			 */
			for (int i = 0; i < n; i++) {
				PreparedStatement stmt = con
						.prepareStatement("insert into empl (empcode,empname,empage,esalary) values (?, ?,?, ?)");
				stmt.setInt(1, 101);
				stmt.setString(2, "Jenny");
				stmt.setInt(3, 25);
				stmt.setInt(4, 10000);
				updatedCount = stmt.executeUpdate();
			}
			System.out.println("i = " + updatedCount);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
