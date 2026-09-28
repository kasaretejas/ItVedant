package final_modifier;
//final class
class Test1{}
class Test2 extends Test1{}
final class Test3{}
class Test4 extends Test3{} //can not extend final class

//final variable and method
class Demo
{
	int x=10;
	final int y=20;
	
	void nonFinalMethod()
	{
		System.out.println("This method is not final");
	}
	
	final void finalMethod()
	{
		System.out.println("This method is final");
	}
}


public class FinalModifier extends Demo 
{

	@Override
	void nonFinalMethod()
	{
		System.out.println("This method is not final overriden in class FinalModifier");
	}
	
	@Override
	final void finalMethod() //Cannot override the final method
	{}
	
	
	public static void main(String[] args) 
	{
		FinalModifier finalModifier = new FinalModifier();
		System.out.println(finalModifier.x);
		System.out.println(finalModifier.y);
		
		finalModifier.x=100;
		finalModifier.y=200; //can not change value of final variable
	}

}
