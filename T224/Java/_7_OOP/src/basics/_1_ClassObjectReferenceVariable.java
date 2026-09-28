package basics;

class Student
{
	String name; //instance variable
	void work()
	{
		System.out.println("student is studying");
	}	
}

public class _1_ClassObjectReferenceVariable 
{
	public static void main(String[] args) 
	{
		Student student1 = new Student();
	   //Student       ==> class Name
	   //student1      ==> reference variable
	   //new Student() ==> object
		
		//creating more than one object
		Student student2 = new Student();
		
		//assigning value to name (instance variable)
		System.out.println(student1.name); //accessed variable name using RV
		student1.name="raj"; //initialized instance variable
		System.out.println(student1.name);
		
		System.out.println(student2.name);
		student2.name="rani";
		System.out.println(student2.name);
		
		student1.work();
		student2.work();
	}
}







