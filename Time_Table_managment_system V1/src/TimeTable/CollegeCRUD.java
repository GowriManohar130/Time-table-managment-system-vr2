package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CollegeCRUD {
	Scanner scanner = new Scanner(System.in);

	public void collegeInsert(Connection con) {
		try {
			System.out.print("Enter college ID: ");
			int collegeId = scanner.nextInt();
			scanner.nextLine();

			System.out.print("Enter college name: ");
			String collegeName = scanner.nextLine();

			System.out.print("Enter college departments: ");
			String collegeDepartments = scanner.nextLine();

			String query = "INSERT INTO college (collegeId, collegeName,collegeDepartments) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, collegeId);
			st.setString(2, collegeName);
			st.setString(3, collegeDepartments);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void collegedelete(Connection con) {
		try {
			System.out.print("Enter college ID: ");
			int collegeId = scanner.nextInt();

			String query = "DELETE FROM college WHERE collegeId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, collegeId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void collegeupdate(Connection con) {
		try {
			System.out.print("Enter college name: ");
			String collegeName = scanner.nextLine();

			System.out.print("Enter college ID: ");
			int collegeId = scanner.nextInt();

			String query = "UPDATE college SET collegeName = ? WHERE collegeId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, collegeName);
			st.setInt(2, collegeId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while updating data: " + e.getMessage());
		}
	}

	public void collegeSelect(Connection con) {
		try {
			String query = "select * from college";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int collegeId = rs.getInt("collegeId");
				String collegeName = rs.getString("collegeName");
				String collegeDepartments = rs.getString("collegeDepartments");

				System.out.println(collegeId + "  " + collegeName + "  " + collegeDepartments);
			}
		} catch (SQLException e) {
			System.out.println("Error while Reading data: " + e.getMessage());
		}
	}

}
