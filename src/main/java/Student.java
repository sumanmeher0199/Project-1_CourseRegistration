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
	
	static void addStudentMain(Admin ad) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n---Add Student---");
		if(ad.coursesSequence.size()!=0) {
			Course.showAllCourse(ad);
			System.out.println("Select an option:");
			int userInp = sc.nextInt();
			
			String courseId = ad.coursesSequence.get(userInp-1);
			Course course = ad.courses.get(courseId);
			Student s1 = new Student("Sd"+ad.studentNo++);
			s1.addStudent();
			s1.enrolledCourseId=courseId;
			course.studIdList.add(s1.getId());
			System.out.println("Student Created Successfully..");
			System.out.println(s1.getName()+" will be learning "+ad.courses.get(s1.enrolledCourseId).getName());
		}else {
			System.out.println("Redirecting to Admin menu..");
			return;
		}
		
		System.out.println("Do you want to Add more Students(Yes/No):");
		String userInp = sc.next();
		if (userInp.equalsIgnoreCase("yes")) {
			addStudentMain(ad);
		} else if (userInp.equalsIgnoreCase("no")) {
			return;
		} else {
			System.out.println("invalid Input");
		}
		
		
		
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
		System.out.println("*                                                    *");
		System.out.println("*         Certificate of Course Completion           *");
		System.out.println("*                                                    *");
		System.out.println("*              This is to certify that               *");
		System.out.println("*                                                    *");
		String sname;
		System.out.print("*"); sname=String.format("%s", this.getName());
		centerAlign(sname);
		System.out.print("*");
		System.out.println("*                                                    *");
		System.out.println("*            has successfully completed              *");
		System.out.println("*                                                    *");
		String sdurationAndCName;
		System.out.print("*");sdurationAndCName=String.format("%s of %s course", c.getDuration(),c.getName());
		centerAlign(sdurationAndCName);
		System.out.print("*");
		System.out.println("*                                                    *");
		String sdescription;
		System.out.print("*");sdescription=String.format("containing %s", c.getContent());
		centerAlign(sdescription);
		System.out.print("*");
		System.out.println("*                                                    *");
		String sgrade;
		System.out.print("*");sgrade=String.format("with a grade of %s", getMarks());System.out.print("%");
		centerAlign(sgrade);
		System.out.print("*");
		System.out.println("*                                                    *");
		System.out.println("*                under the guidance of               *");
		System.out.println("*                                                    *");
		String pName;
		System.out.print("*");pName=String.format("%s", p.getName());
		centerAlign(pName);
		System.out.print("*");
		System.out.println("*                                                    *");
		System.out.println("*                                                    *");
		System.out.println("******************************************************");
	}
	//func for center alignment
	private static void centerAlign(String text) {
		int totalSpaces= 50-text.length();
		int leftSpaces = totalSpaces/2;
		int rightSpaces = totalSpaces-leftSpaces;
		
		//non-negative totalSpaces value
		if(totalSpaces>=0) {
			String alignedText=" ".repeat(leftSpaces)+text+" ".repeat(rightSpaces);
			System.out.println(alignedText);
		}else {
			//if text is already longer than 50 characters, print as it is
			System.out.println(text);
		}
	}
	
	

}