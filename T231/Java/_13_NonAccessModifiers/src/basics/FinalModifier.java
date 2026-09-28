package basics;
final class Demo {}

//class Test extends Demo ------------> cant extend final class
class Test
{
	final int x = 10;
	int y=20;
	
	final void iAmFinal() {}
	void iAmNotFinal() {}
}
public class FinalModifier extends Test
{
	//final void iAmFinal() {} ----> ERROR We can not override final method
	void iAmNotFinal() {}

	public static void main(String[] args) 
	{
		Test test = new Test();
		test.y=200;
		//test.x=100; -----> ERROR : we cant update final variable
		
		Demo demo = new Demo(); //------> we can create object of Demo class but cant extend
	}

}
