package basics;

static class Example {} //ERROR ----> we cant make outer class as a static class
class Sample
{
	int a = 10;
	static int b = 20;
	
	void em() {}
	static void sm1 () {}
	static void sm2 ()
	{
		//System.out.println(a);  -------> ERROR : Only static members alowed inside static method
		System.out.println(b);
		//em(); -------------------------> ERROR : Only static members alowed inside static method
		sm1();
	}
	
	class Display {} //this is called as inner class
	static class View {} //this is called as nested class
	
}
public class StaticModifier {

	public static void main(String[] args) 
	{
		Sample sample = new Sample();
		System.out.println(sample.b); //WARNING : static variable should be access using class
		System.out.println(Sample.b);
		
		//creating inner class object (non static inner)
		Display display = new Display();
		Sample.Display display1 = sample.new Display(); 
		//we need object of outer class to create object of inner class
		
		View view = new View();
		Sample.View view2 = new Sample.View(); 
		//to create object of nested class, we dont required object of outer class
		
	}

}
