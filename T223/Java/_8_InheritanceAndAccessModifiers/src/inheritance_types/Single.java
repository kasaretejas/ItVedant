package inheritance_types;

class A 
{
	String name = "I am raj from class A";
}

class B extends A
{}

public class Single 
{
	public static void main(String[] args) 
	{
		B b = new B();
		System.out.println(b.name);
	}
}
