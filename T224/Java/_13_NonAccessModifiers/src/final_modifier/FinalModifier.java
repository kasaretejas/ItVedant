package final_modifier;

final class Test1 {}
class Test2 {}

//class Demo1 extends Test1{} //cant extend final class
class Demo2 extends Test2 {}

class Demo
{
		  int x = 10;
	final int y = 20;
	
		  void display(){}
	final void show() {}
}



public class FinalModifier extends Demo 
{
	@Override
	void display() {}
	
	//@Override
	//void show() {} //cant override final method

	public static void main(String[] args) 
	{
		FinalModifier finalModifier = new FinalModifier();
		System.out.println(finalModifier.x);
		System.out.println(finalModifier.y);
		
		finalModifier.x =30;
		//finalModifier.y = 40; //cant change value of final variable

	}

}
