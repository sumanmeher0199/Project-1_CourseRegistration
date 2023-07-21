import java.util.ArrayList;
import java.util.Scanner;

public class Course {
	String name;
	int price;
	String duration;
	String content;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	//method to add course
	void addCourse() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Name of the course: ");
		name=sc.nextLine();
		setName(name);
		
		System.out.println("Enter the Price of the course: ");
		price=sc.nextInt();
		setPrice(price);
		
		System.out.println("Enter the Duration of the course: ");
		duration=sc.nextLine();
		setDuration(duration);
		
		System.out.println("Enter the Content of the course using comma (,): ");
		content=sc.nextLine();
		setContent(content);
	}
	
	private void commaSeparator(){
		String[] cont= content.split(",");
		for(String word:cont) {
			System.out.println(word.trim());
		}
	}
	
	void displayCourse() {
		System.out.println("Name: "+name);
		System.out.println("Price: "+price);
		System.out.println("Duration: "+duration);
		System.out.println("Course Content: ");
		commaSeparator();
	}
	
	ArrayList stud = new ArrayList();
	
	
	
	Professor prof=new Professor();
	
	

}
