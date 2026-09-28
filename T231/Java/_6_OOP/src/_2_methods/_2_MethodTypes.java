package _2_methods;

class Student
{
	String name;
	String phone;
	static String collegeName="IIT";
	
	Student(String name, String phone)
	{
		this.name = name;
		this.phone = phone;
	}
	
	//instance method
	void iamInstanceMethod1()
	{
		System.out.println("inside instance method 1 name "+this.name); //accessed instance variable
		System.out.println("inside instance method 1 collegeName " + collegeName); //accessed static variable
		iamInstanceMethod2();
	}
	
	void iamInstanceMethod2()
	{
		System.out.println("inside instance method 2 "); 
	}
	
	//static method
	static void iamStaticMethod1()
	{
		System.out.println("inside static method 1 name "+name); //accessed instance variable --> ERROR
		System.out.println("inside static method 1 collegeName " + collegeName); //accessed static variable
		iamInstanceMethod2(); //called instance method ----> ERROR
		iamStaticMethod2();
	}
	
	static void iamStaticMethod2()
	{
		System.out.println("inside static method 2");
	}
}

public class _2_MethodTypes {

	public static void main(String[] args) 
	{
		Student s1 = new Student("raj", "9843566367");
		Student s2 = new Student("sumit", "9843566367");
		System.out.println(s1.name);
		System.out.println(s2.name);
		
		s1.iamInstanceMethod1();
		s2.iamInstanceMethod1();

	}

}
