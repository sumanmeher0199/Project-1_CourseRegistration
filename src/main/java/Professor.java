import java.util.Scanner;

public class Professor extends People{
	Scanner sc = new Scanner(System.in);
//	Course 
//	Course course;
	String courseIdTeaching;
	public Professor(String s) {
		// TODO Auto-generated constructor stub
		setId(s);
	}
	
	void addProfessor(String courseID) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the Professor:");
//		System.out.println("Enter the name of the Professor for Course: "+c.getName());
		setName(sc.nextLine());
		System.out.println("Enter the age of the Professor");
		setAge(sc.nextInt());
		System.out.println("Enter the Password:");
		setPassword(sc.next());
//		course = c;
		courseIdTeaching=courseID;
	}
	
	void displayProfessor(Admin ad) {
		System.out.println("Id: "+getId());
		System.out.println("Name: "+getName());
		System.out.println("Age: "+ getAge());
		System.out.println("Course: "+ad.courses.get(courseIdTeaching).getName());
	}
	
	static Professor loginProfessor(Admin ad) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Professor User Id:");
		String userId = sc.next();
		System.out.println("Enter Password:");
		String pass = sc.next();
		if(ad.professors.get(userId)!=null) {
			if(ad.professors.get(userId).checkPassword(pass)) {
				return ad.professors.get(userId);
			}
		}
		return null;
		
	}
	
	
	

}
