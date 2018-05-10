package silver;

public class Student {
	private String Student_id;
	private String Student_name;
	private String Class_id;
	private String student_pwd;
	public String getStudent_id() {
		return Student_id;
	}
	public void setStudent_id(String student_id) {
		Student_id = student_id;
	}
	public String getStudent_name() {
		return Student_name;
	}
	public Student() {
		
	}
	public Student(String student_id, String student_name, String class_id,String student_pwd) {
		super();
		this.Student_id = student_id;
		this.Student_name = student_name;
		this.Class_id = class_id;
		this.student_pwd=student_pwd;
	}
	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}
	public String getClass_id() {
		return Class_id;
	}
	public void setClass_id(String class_id) {
		this.Class_id = class_id;
	}
	public String getStudent_pwd() {
		return student_pwd;
	}
	public void setStudent_pwd(String student_pwd) {
		this.student_pwd = student_pwd;
	}
	
}
