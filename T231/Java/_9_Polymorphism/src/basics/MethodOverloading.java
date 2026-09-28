package basics;
class Calculator
{
	void add(int x, int y)
	{
		System.out.println("addition is "+ (x+y));
	}
	
	void add(int x, float y)
	{
		System.out.println("addition is "+ (x+y));
	}

}

public class MethodOverloading {

	public static void main(String[] args) 
	{
		Calculator calculator = new Calculator();
		calculator.add(12, 5.3f); //this will call second add method
		calculator.add(12, 3); //this will call first add method
		//calculator.add(12, "hiii"); //this error will be raised at comiple time so it is called as compile time poly
	}

}
