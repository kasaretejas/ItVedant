package polymorphism;

class Calculator
{
	void add(int x, int y)
	{
		System.out.println(x+y);
	}
	
	void add(int x, float y)
	{
		System.out.println(x+y);
	}
	
	void add(int a, int b, int c)
	{
		System.out.println(a+b+c);
	}
}

public class MethodOverLoading {

	public static void main(String[] args) 
	{
		Calculator calculator = new Calculator();
		calculator.add(12, 5.6f);
		calculator.add(12, 4, 8);
		calculator.add(12, 3);
		
		//calculator.add(12, 3.7);

	}

}
