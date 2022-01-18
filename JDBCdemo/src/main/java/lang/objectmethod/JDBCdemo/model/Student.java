package lang.objectmethod.JDBCdemo.model;

public class Student {

	private int id;
	private String name;
	private String class_st;
	private String gender;

	public Student(String name, String class_st, String gender) {
		super();
		this.name = name;
		this.class_st = class_st;
		this.gender = gender;
	}

	public Student(int id, String name, String class_st, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.class_st = class_st;
		this.gender = gender;
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

	public String getClass_st() {
		return class_st;
	}

	public void setClass_st(String class_st) {
		this.class_st = class_st;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
