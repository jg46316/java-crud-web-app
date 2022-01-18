package lang.objectmethod.JDBCdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lang.objectmethod.JDBCdemo.model.Assistant;


// This DAO class provides CRUD database operations for the table student in the database.
public class AssistantDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";


	private static final String SELECT_ALL_ASSISTANT = "select * from assistant";

	public AssistantDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}


	public List<Assistant> selectAllAssistant() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Assistant> assistant = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ASSISTANT);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String courses = rs.getString("courses");
				String email = rs.getString("email");
				assistant.add(new Assistant(id, name, courses, email));

			}

		} catch (SQLException e) {
			printSQLException(e);
		}
		return assistant;
	}



	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}