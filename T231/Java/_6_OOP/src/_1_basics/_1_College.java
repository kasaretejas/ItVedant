package _1_basics;

class Student
{
	String name = "amit"; //variable OR property
	void work() //method OR BEHAVIOR
	{
		System.out.println("amit is doing study");
	}
}

public class _1_College 
{

	public static void main(String[] args) 
	{
		Student student = new Student();
		Student student1 = new Student();
		Student s1 = new Student();
		Student gaurav = new Student();
		
		System.out.println(student.name); //accessing variable OR property of Student using RV
		System.out.println(s1.name); //accessing variable OR property of Student using RV
		
		student.work(); //accessing method OR BEHAVIOR of Student using RV
		
		//Student : class name
		//new Student() : Object
		//student, student1, s1, gaurav : reference variable
		
		//class - just plan/ blue print/structure
		//object - real world existence of a class
		//rv : used to access properties and behaviours of an object
		      //properties : variables
			  //behaviours : methods
		      //used to access variables and methods of an object

	}

}
