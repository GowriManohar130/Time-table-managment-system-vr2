package TimeTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class FacultyCRUD {
	
	Scanner scanner = new Scanner(System.in);

	public void facultyInsert(Connection con) {
		try {
			System.out.print("Enter Faculty ID: ");
	        int facultyId = scanner.nextInt();

	        System.out.print("Enter Faculty Name: ");
	        scanner.nextLine();
	        String facultyName = scanner.nextLine();

	        System.out.print("Enter Department ID: ");
	        int departmentId = scanner.nextInt();

			String query = "INSERT INTO faculty (facultyId, facultyName, departmentId) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, facultyId);
			st.setString(2, facultyName);
			st.setInt(3, departmentId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while inserting data: " + e.getMessage());
		}
	}

	public void facultydelete(Connection con) {
		try {
			System.out.print("Enter Faculty ID: ");
	        int facultyId = scanner.nextInt();

			String query = "DELETE FROM faculty WHERE facultyId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, facultyId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while deleting data: " + e.getMessage());
		}
	}

	public void facultyupdate(Connection con) {
		try {
			System.out.print("Enter Faculty ID: ");
	        int facultyId = scanner.nextInt();

	        System.out.print("Enter Faculty Name: ");
	        scanner.nextLine();
	        String facultyName = scanner.nextLine();

			String query = "UPDATE faculty SET facultyName = ? WHERE facultyId = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, facultyName);
			st.setInt(2, facultyId);
			st.execute();
		} catch (SQLException e) {
			System.out.println("Error while updating data: " + e.getMessage());
		}
	}
	
	public void facultySelect(Connection con) {
		try {
			String query = "select * from faculty";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
			    int facultyId = rs.getInt("facultyId");
			    String facultyName = rs.getString("facultyName");
			    int departmentId = rs.getInt("departmentId");

			    System.out.println(facultyId + " " + facultyName +" " + departmentId);
			}
		} catch (SQLException e) {
			System.out.println("Error while reading data: " + e.getMessage());
		}
	}

}

