import java.util.Scanner;

public class Student extends People {
//	Course c;
	String enrolledCourseId;
	int marks;
	
	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Student(String id) {
		this.setId(id);
	}
	
	void addStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the Student");
		setName(sc.nextLine());
		System.out.println("Enter the age of the Student");
		setAge(sc.nextInt());
		System.out.println("Enter the Password:");
		setPassword(sc.next());
	}
	
//	void addCourse(Course course) {
//		this.c=course;
//	}
	void setCourse(String courseId) {
		enrolledCourseId=courseId;
	}
	
	static Student loginStudent(Admin ad) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student User Id:");
		String userId = sc.next();
		System.out.println("Enter Password:");
		String pass = sc.next();
		if(ad.students.get(userId)!=null) {
			if(ad.students.get(userId).checkPassword(pass)) {
				return ad.students.get(userId);
			}
		}
		return null;
	}
	
	

}
