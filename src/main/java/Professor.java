import java.util.Scanner;

public class Professor extends People{
	void addProfessor() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the Professor.");
		this.name = sc.nextLine();
		System.out.println("Enter the age of the Professor");
		this.age = sc.nextInt();
		
	}
	

}
