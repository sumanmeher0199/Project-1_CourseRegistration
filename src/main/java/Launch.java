import java.util.Scanner;


public class Launch {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Course Regestration Website!");
		System.out.println();
		Admin ad = new Admin();

		boolean isAuth = ad.checkUsernamePassword();
		if(!isAuth) {
			System.out.println("Authentication Failed.. \nThanx for visiting us..");
			System.exit(0);
		}
		
		System.out.println("Authenticated..\n");
		
		mainMenu(ad);
		
		
		String cont="yes";

		
//		----- Don't read after this..----
//		----- Don't read after this..----
//		----- Don't read after this..----
//		----- Don't read after this..----
//		----- Don't read after this..----
//		----- Don't read after this..----
//		----- Don't read after this..----
//		----- Don't read after this..----
		
//		cont="yes";
//
//		System.out.println("\nWelcome to student section.");
//		cont="yes";
//		while(!cont.equalsIgnoreCase("no")) {
//			System.out.println("Please Login to get your marks and Report.");
//			Student stud = Student.loginStudentCheck(ad);
//			if(stud==null) {
//				System.out.println("wrong userId and Password. Please try again.");
//				System.out.println("Try again for Student Login (yes/No)?");
//				cont = sc.next();
//				if(cont.equalsIgnoreCase("no"))
//					break;
//				else
//					continue;
//			}else {
//				
//				Course course = ad.courses.get(stud.enrolledCourseId);
//				System.out.println("1. Check score");
//				System.out.println("2. Get Report");
//				System.out.println("3. Exit");
//				
//				System.out.println("Select an option:");
//				int userInp = sc.nextInt();
//				if(userInp==1) {
//					System.out.println("Your marks is: "+stud.getMarks());
//				}else if(userInp==2) {
////					System.out.println("Report Coming Soon.");
//					stud.printScoreCard(ad);
//				}else if(userInp==3){
//					System.out.println("Exiting the Application.");
//					System.out.println("Thanks for visiting us.");
//					System.exit(0);
//				}else {
//					System.out.println("wrong input");
//					System.exit(0);
//				}
//			}
//			
//			System.out.println("New Student Login (yes/No)?");
//			cont = sc.next();
//		}
//		
		
		

	}
	
	static void printMainMenu() {
		System.out.println("----Main Menu----");
		System.out.println("1. Admin Login");
		System.out.println("2. Professor Login");
		System.out.println("3. Student Login");
		System.out.println("4. Exit Application");
	}
	static void mainMenu(Admin ad) {
		Scanner sc = new Scanner(System.in);
		printMainMenu();
		System.out.println("Select an option:");
		int userInp = sc.nextInt();
		if(userInp==1) {
			Admin.adminMenu(ad);
		}else if(userInp==2) {
			Professor.professorLogin(ad);
			mainMenu(ad);
		}else if(userInp==3) {
			Student.studentLogin(ad);
			mainMenu(ad);
		}else if(userInp==4) {
			System.exit(0);
		}else {
			
		}
		
	}
	
	

}