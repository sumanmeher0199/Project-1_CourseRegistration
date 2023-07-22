import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	
	//Login Credentials
	String username;
	String password;
	public Admin() {
		this.username = "admin";
		this.password = "Admin";
	}
	
	ArrayList<Professor> professors = new ArrayList<Professor>();
	ArrayList<Course> courses = new ArrayList<Course>();
	ArrayList<Student> students = new ArrayList<Student>();
	
	boolean checkUsernamePassword() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Admin Username:");
		String name = sc.next();
		System.out.println("Enter Admin Password");
		String pass = sc.next();
		
		if(name.equals(username) && pass.equals(this.password))
			return true;
		return false;
		
	}
	
	void addCourseInList(Course c) {
//		System.out.println(c.getName());
		this.courses.add(c);
	}
	
	void showAllCourses() {
		int i=0;
		for (Course course : courses) {
			System.out.println(i+")"+course.getName()+"("+course.id+")");
//			course.displayCourse();
			System.out.println("------");
		}
	}
	
	void showAllProfessors() {
		for (var professor : professors) {
			System.out.println(professor.getName()+"("+professor.getId()+")");
		}
	}

}
