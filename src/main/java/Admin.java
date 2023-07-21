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
	
	ArrayList<Professor> professors;
	ArrayList<Course> courses;
	ArrayList<Student> students;
	
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
		courses.add(c);
	}

}
