package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PeriodCRUD {

	Scanner scanner = new Scanner(System.in);

	public void periodInsert(Connection con) {
		try {
			System.out.print("Enter Period ID: ");
			int periodId = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter Period From (e.g., 9-Pm): ");
			String periodFrom = scanner.nextLine();
			System.out.print("Enter Period To (e.g., 9-Pm): ");
			String periodTo = scanner.nextLine();
			String query = "INSERT INTO period (periodId, periodFrom, periodTo) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, periodId);
			st.setString(2, periodFrom);
			st.setString(3, periodTo);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void perioddelete(Connection con) {
		try {
			System.out.print("Enter Period ID: ");
			int periodId = scanner.nextInt();
			String query = "DELETE FROM period WHERE periodId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, periodId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void periodupdate(Connection con) {
		try {
			System.out.print("Enter Period ID: ");
			int periodId = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter Period From (e.g., 9-Pm): ");
			String periodFrom = scanner.nextLine();
			String query = "UPDATE period SET periodFrom = '?', periodTo = ? WHERE periodId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, periodFrom);
			st.setInt(2, periodId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while updating data: " + e.getMessage());
		}
	}

	public void periodSelect(Connection con) {
		try {
			String query = "select * from period";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int periodId = rs.getInt("periodId");
				String periodFrom = rs.getString("periodFrom");
				int periodTo = rs.getInt("periodTo");

				System.out.println(periodId + "  " + periodFrom + "  " + periodTo);
			}
		} catch (SQLException e) {
			System.out.println("Error while reading data: " + e.getMessage());
		}
	}

}
