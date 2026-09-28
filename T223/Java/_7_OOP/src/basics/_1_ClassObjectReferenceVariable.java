package basics;

class Student
{
	String name = "Amit";
	void work()
	{
		System.out.println("student is doing study");
	}
}

public class _1_ClassObjectReferenceVariable 
{
	public static void main(String[] args) 
	{
		Student student1 = new Student();
		//   Student ---> className 
		// 	 student1 ---> referenceVariable (rf)
		//   new --------> built in keyword in java
		//   Student() ---> Object 
		System.out.println(student1.name); //using rf, we are accessing property/variable of object Student
		student1.work(); //using rf, we are accessing behavior/method of object Student
	}
}
