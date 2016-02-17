package jdbcProject;

import java.sql.*;

public class Driver {
	public static void main(String[] args) {
		try {

			// Connection
			Connection myCon = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo", "root", "Sanman88");
			// statement

			Statement myStmt = myCon.createStatement();

			// execution
			ResultSet myRes = myStmt.executeQuery("SELECT * FROM Student");

			// process resultset
			int count = 0;
			while (myRes.next() && count < 100) {
				System.out.println(myRes.getString("Name") + ","
						+ myRes.getString("Country"));
				count++;
			}

			String querrySql = "INSERT INTO student (StudentID, Name,Country) VALUES ('5', 'Manaswi', 'USA')";
			myStmt.executeUpdate(querrySql);
			System.out.println("Insert complete");

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}
}
