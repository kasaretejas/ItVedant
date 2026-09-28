package basics;

class MethodTypes
{
	int x=10;
	static int y=20;
	
	void instanceMethod1()
	{
		System.out.println("I am instanceMethod1");
		System.out.println(x);
		System.out.println(y);
		instanceMethod2();
		staticMethod1();
	}
	
	void instanceMethod2()
	{
		System.out.println("I am instanceMethod2");
	}
	
	static void staticMethod1()
	{
		System.out.println("I am staticMethod1");
		//System.out.println(x); //cannot access non-static variable in static method
		System.out.println(y);
		//instanceMethod2(); //cannot call non-static method in static method
		staticMethod2();
		
		
	}
	
	static void staticMethod2()
	{
		System.out.println("I am staticMethod2");
	}
	
	void display()
	{
		System.out.println(" i am display");
	}


}

public class _5_InstanceStaticLocal_Methods {

	public static void main(String[] args) 
	{
		MethodTypes methodTypes = new MethodTypes();
		
		System.out.println("---- Working with static method --- ");
		methodTypes.instanceMethod1();
		
		
		System.out.println("---- Working with static method --- ");
		//methodTypes.staticMethod1();
		MethodTypes.staticMethod1();

	}

}
