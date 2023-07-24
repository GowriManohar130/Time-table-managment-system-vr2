package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ClassesCRUD {
	private Connection con;

	public void Classes() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver found successful");
			String url = "jdbc:mysql://localhost:3306/manohar";
			String username = "root";
			String password = "root";
			con = DriverManager.getConnection(url, username, password);
			System.out.println("connected with database successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("unable to find the driver");
		} catch (SQLException e) {
			System.out.println("unable to connect with database");
		}

	}

	public void ClassesInsert() {
		try {
			  Scanner scanner = new Scanner(System.in);
			  System.out.print("Enter Classes ID: ");
		        int classesId = scanner.nextInt();
		        scanner.nextLine(); 
		        System.out.print("Enter Classes Name: ");
		        String classesName = scanner.nextLine();
		        System.out.print("Enter Department ID: ");
		        int departmentId = scanner.nextInt();
			String query = "INSERT INTO Classes (classesId, classesName, departmentId) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, classesId);
			st.setString(2, classesName);
			st.setInt(3, departmentId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void Classesdelete() {
		try {
			 Scanner scanner = new Scanner(System.in);
			  System.out.print("Enter Classes ID: ");
		        int classesId = scanner.nextInt();
		        scanner.nextLine();
			String query = "DELETE FROM Classes WHERE classesId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, classesId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void Classesupdate() {
		try {
			 Scanner scanner = new Scanner(System.in);
			 System.out.print("Enter classes Name: ");
		        String classesName = scanner.nextLine();
		        scanner.nextLine();
			  System.out.print("Enter Classes ID: ");
		        int classesId = scanner.nextInt();
		      
			String query = "UPDATE Classes SET classesName = '?' WHERE classesId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, classesName);
			st.setInt(2, classesId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}
	
	public void ClassesSelect() {
		try {
			String query = "select * from Classes";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			    int classesId = rs.getInt("classesId");
			    String classesName = rs.getString("classesName");
			    int departmentId = rs.getInt("departmentId");
			    System.out.println(classesId + "  " + classesName + "  " + departmentId);
			}
		} catch (SQLException e) {
			System.out.println("Error while reading data: " + e.getMessage());
		}
	}
}
