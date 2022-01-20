package lang.objectmethod.JDBCdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lang.objectmethod.JDBCdemo.model.User;


public class UserDAO {
	
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String INSERT_USERS_SQL = "INSERT INTO user"
			+ "  (first_name, last_name, username, password, address, contact) VALUES " + " (?, ?, ?, ?,?,?);";


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

	public void registerUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getAddress());
			preparedStatement.setString(6, user.getContact());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
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

	public User checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/test";
		String dbUser = "root";
		String dbPassword = "password";

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "SELECT * FROM user WHERE username = ? and password = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);

		ResultSet result = statement.executeQuery();

		User user = null;

		if (result.next()) {
			user = new User();
			user.setFirstName("Jasmin");
			user.setLastName("Guzina");
		}

		connection.close();

		return user;
	}
}