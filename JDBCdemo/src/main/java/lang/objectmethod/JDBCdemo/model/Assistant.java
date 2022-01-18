package lang.objectmethod.JDBCdemo.model;

public class Assistant {

	private int id;
	private String name;
	private String courses;
	private String email;

	public Assistant(int id, String name, String courses, String email) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
