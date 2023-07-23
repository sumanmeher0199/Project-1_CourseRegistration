import java.util.Scanner;

public class Launch {

	public static void main(String[] args) {
		int courseNo = 1;
		int professorNo = 1;
		int studentNo = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Course Regestration Website: ");
		Admin ad = new Admin();
//		boolean isAuth = ad.checkUsernamePassword();
//		if(!isAuth) {
//			System.out.println("Authentication Failed.. \nThanx for visiting us..");
//			System.exit(0);
//		}
//		System.out.println("Authenticated...");
		
		//Add course
		String cont="yes";
		while(!cont.equalsIgnoreCase("no")) {
			Course c1 = new Course("C"+courseNo++);
			c1.addCourse();
			c1.displayCourse();
			ad.coursesSequence.add(c1.getId());
			ad.addCourseInList(c1.getId(),c1);
			System.out.println("Do you want to Create more Courses:");
			String  inp = sc.next();
			cont = inp;
			cont = sc.next();
		}
		
//		ad.showAllCourses();
		
		//Professor's section flow
		System.out.println("Welcome to Professor's Section.");
		int numOfCourse = ad.courses.size();
		for(int i=0;i<numOfCourse;i++) {
			
			Professor p1 = new Professor("Pr"+professorNo++);
			String courseId = ad.coursesSequence.get(i);
			Course course = ad.courses.get(courseId);
			System.out.println("Add Professor for Course "+course.getName());
			p1.addProfessor(course.getId());			
			course.setProf(p1.getId());
			ad.addProfessorInList(p1.getId(),p1);
			p1.displayProfessor(ad);
		}
		
		
		
		System.out.println("Professors for all Courses are added.");
		
//		ad.showAllProfessors();
		
		//Students section flow
		System.out.println("\nWelcome to Stuents section...");
		cont="yes";
		while(!cont.equalsIgnoreCase("no")) {
			Student s1 = new Student("Sd"+studentNo++);
			s1.addStudent();
			System.out.println("Available Course:");
			ad.showAllCourses();
			System.out.println("Select a course.");
			String courseId = ad.coursesSequence.get(sc.nextInt()-1);
			Course course = ad.courses.get(courseId);
			s1.setCourse(courseId);
			course.studIdList.add(s1.getId());
			System.out.println("selected course: "+ course.getName());
			ad.addStudentInList(s1.getId(),s1);
			s1.displayStudent(ad);
			
			System.out.println("Do you want to add more Students (Yes/No):");
			cont = sc.next();
		}
		
		//Professors section
		System.out.println("\nWelcome to Professor Login.");
		
		cont="yes";
		while(!cont.equalsIgnoreCase("no")) {
			System.out.println("Please Login to mark the students.");
			Professor prof = Professor.loginProfessor(ad);
			if(prof==null) {
				System.out.println("wrong userId and Password. Please try again.");
				System.out.println("Try again for professot Login (yes/No)?");
				cont = sc.next();
				if(cont.equalsIgnoreCase("no"))
					break;
				else
					continue;
			}else {
				
				Course course = ad.courses.get(prof.courseIdTeaching);
				System.out.println("Provide marks for student of course "+course.getName());
				for(String str:course.studIdList) {
					Student student = ad.students.get(str);
					System.out.println("Please give marks for student:"+student.getName());
//					System.out.println(student.getName());
					int marks = sc.nextInt();
					student.setMarks(marks);
				}
			}
			
			System.out.println("New professot Login (yes/No)?");
			cont = sc.next();
		}
		
		System.out.println("\nWelcome to student section.");
		cont="yes";
		while(!cont.equalsIgnoreCase("no")) {
			System.out.println("Please Login to get your marks and Report.");
			Student stud = Student.loginStudent(ad);
			if(stud==null) {
				System.out.println("wrong userId and Password. Please try again.");
				System.out.println("Try again for Student Login (yes/No)?");
				cont = sc.next();
				if(cont.equalsIgnoreCase("no"))
					break;
				else
					continue;
			}else {
				
				Course course = ad.courses.get(stud.enrolledCourseId);
				System.out.println("1. Check score");
				System.out.println("2. Get Report");
				System.out.println("3. Exit");
				
				System.out.println("Select an option:");
				int userInp = sc.nextInt();
				if(userInp==1) {
					System.out.println("Your marks is: "+stud.getMarks());
				}else if(userInp==2) {
//					System.out.println("Report Coming Soon.");
					stud.printScoreCard(ad);
				}else if(userInp==3){
					System.out.println("Exiting the Application.");
					System.out.println("Thanks for visiting us.");
					System.exit(0);
				}else {
					System.out.println("wrong input");
					System.exit(0);
				}
			}
			
			System.out.println("New Student Login (yes/No)?");
			cont = sc.next();
		}
		
		
		

	}

}
