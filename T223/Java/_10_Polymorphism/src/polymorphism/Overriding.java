package polymorphism;

class Parent
{
	String paisa = "10Cr";
	String jamin = "10 Acre";
	
	void marriage()
	{
		System.out.println("You have to marry Sushila");
	}
	
}

class Mayuresh extends Parent
{
	@Override
	void marriage()
	{
		System.out.println("I will marry nora");
		super.marriage();
		
	}
}

public class Overriding 
{

	public static void main(String[] args) 
	{
		Mayuresh mayuresh = new Mayuresh();
		System.out.println(mayuresh.paisa);
		System.out.println(mayuresh.jamin);
		mayuresh.marriage();
		mayuresh.marriage();

	}

}
