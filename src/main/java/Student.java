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
	
	void displayStudent(Admin ad) {
		System.out.println("Id: "+getId());
		System.out.println("Name: "+getName());
		System.out.println("Age: "+ getAge());
		System.out.println("Course: "+ad.courses.get(enrolledCourseId).getName());
	}
	

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
	
	void printScoreCard(Admin ad) {
		Course c = ad.courses.get(enrolledCourseId);
		Professor p = ad.professors.get(c.getProfId());
		System.out.println("******************************************************");
		System.out.println("*            Certificate of Achievement              *");
		System.out.println("*                                                    *");
		System.out.println("*              This is to certify that               *");
		System.out.println("*                                                    *");
		System.out.println("*                    "+this.getName()+"              *");
		System.out.println("*                                                    *");
		System.out.println("*            has successfully completed              *");
		System.out.println("*                                                    *");
		System.out.println("*      "+c.getDuration() +" of "+ c.getName()+"      *");
		System.out.println("*                                                    *");
		System.out.println("*          containing "+ c.getContent()+"            *");
		System.out.println("*                                                    *");
		System.out.println("*            with a grade of "+getMarks()+"          *");
		System.out.println("*                                                    *");
		System.out.println("*             under the guidance of                  *");
		System.out.println("*                                                    *");
		System.out.println("*                "+ p.getName()+"                     *");
		System.out.println("*                                                    *");
		System.out.println("*                                                    *");
		System.out.println("******************************************************");
	}
	
	

}
