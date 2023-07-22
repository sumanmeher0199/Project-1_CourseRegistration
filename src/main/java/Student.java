import java.util.Scanner;

public class Student extends People {
	void addStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the Student");
		setName(sc.nextLine());
		System.out.println("Enter the age of the Student");
		setAge(sc.nextInt());
	}
	
	Course c;
	Student s;
	Professor p;
	
	void printScoreCard() {
		System.out.println("******************************************************");
		System.out.println("*            Certificate of Achievement              *");
		System.out.println("*                                                    *");
		System.out.println("*              This is to certify that               *");
		System.out.println("*                                                    *");
		System.out.println("*                    "+s.getName()+"                 *");
		System.out.println("*                                                    *");
		System.out.println("*            has successfully completed              *");
		System.out.println("*                                                    *");
		System.out.println("*      "+c.getDuration() +"of"+ c.getName()+"        *");
		System.out.println("*                                                    *");
		System.out.println("*          containing"+ c.getContent()+"             *");
		System.out.println("*                                                    *");
		System.out.println("*            with a grade of [Grade]                 *");
		System.out.println("*                                                    *");
		System.out.println("*             under the guidance of                  *");
		System.out.println("*                                                    *");
		System.out.println("*                "+ p.getName()+"                     *");
		System.out.println("*                                                    *");
		System.out.println("*                                                    *");
		System.out.println("******************************************************");
	}
	
	

}
