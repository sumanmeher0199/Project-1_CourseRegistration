import java.util.Scanner;

public class Launch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Course Regestration Website: ");
		Admin ad = new Admin();
		boolean isAuth = ad.checkUsernamePassword();
		if(!isAuth) {
			System.out.println("Authentication Failed.. \nThanx for visiting us..");
			System.exit(0);
		}
		System.out.println("Authenticated..");
		
		//Add course
		String cont="yes";
		while(!cont.equals("no")) {
			Course c1 = new Course();
			c1.addCourse();
			ad.addCourseInList(c1);
			System.out.println("Do you want to Create more Courses:");
			String  inp = sc.next();
			cont = inp;
		}
		
		
		

	}

}
