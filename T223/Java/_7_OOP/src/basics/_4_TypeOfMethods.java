package basics;

class Teacher
{
	String name;
	static String collegeName="ITVedant";
	
	Teacher(String teacherName)
	{
		this.name=teacherName;
	}
	
	void instanceMethod()
	{
		System.out.println("instanceMethod executed");
		System.out.println(name);
		System.out.println(collegeName);//we can access static variable from non static method
		staticMethod1(); //we can call static method from non static method
	}
	
	static void staticMethod1()
	{
		System.out.println("staticMethod1 executed");
		//System.out.println(name); //here name is non static so we cant access
		System.out.println(collegeName);
		//instanceMethod();
		staticMethod2();
	}
	
	static void staticMethod2()
	{
		System.out.println("staticMethod2 executed");
	}
}


public class _4_TypeOfMethods 
{
	
	public static void main(String[] args) 
	{
		Teacher teacher1 = new Teacher("Mr. Amit Sharma");
		System.out.println(teacher1.name);
		System.out.println(teacher1.collegeName);
		System.out.println(Teacher.collegeName);//best way to access static member is using class name
		
		System.out.println("----------");
		teacher1.instanceMethod();
		
		System.out.println("----------");
		teacher1.staticMethod1();
		Teacher.staticMethod1();//best way to access static member is using class name
	}
}






