package lang.objectmethod.JDBCdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lang.objectmethod.JDBCdemo.model.Assistant;
import lang.objectmethod.JDBCdemo.model.Student;

// This DAO class provides CRUD database operations for the table student in the database.
public class StudentDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String INSERT_STUDENT_SQL = "INSERT INTO student" + "  (name, class_st, gender) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_STUDENT_BY_ID = "select id,name,class_st, gender from student where id =?";
	private static final String SELECT_ALL_STUDENT = "select * from student";
	private static final String SELECT_ALL_ASSISTANT = "select * from assistant";
	private static final String SELECT_STUDENT_ASSISTANT = "SELECT  student.name\r\n" + "FROM student\r\n"
			+ "JOIN assistant_student ON student.id = assistant_student.student_id\r\n"
			+ "JOIN assistant ON assistant_student.assistant_id = assistant.id where assistant.id = ?;";
	private static final String DELETE_STUDENT_SQL = "delete from student where id = ?;";
	private static final String UPDATE_STUDENT_SQL = "update student set name = ?,class_st= ?, gender =? where id = ?;";

	public StudentDAO() {
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

	public void insertStudent(Student student) throws SQLException {
		System.out.println(INSERT_STUDENT_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getClass_st());
			preparedStatement.setString(3, student.getGender());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Student selectStudent(int id) {
		Student student = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("class_st");
				String country = rs.getString("gender");
				student = new Student(id, name, email, country);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return student;
	}

	public List<Student> selectAllStudent() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Student> student = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String class_st = rs.getString("class_st");
				String gender = rs.getString("gender");
				student.add(new Student(id, name, class_st, gender));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return student;
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

	public ArrayList<String> selectAllStudentAssistant(int id) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		ArrayList<String> student_assistant = new ArrayList<String>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_ASSISTANT);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				String name = rs.getString("name");

				student_assistant.add(name);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return student_assistant;
	}

	public boolean deleteStudent(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateStudent(Student student) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_SQL);) {
			statement.setString(1, student.getName());
			statement.setString(2, student.getClass_st());
			statement.setString(3, student.getGender());
			statement.setInt(4, student.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
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