package basics;

interface Computer
{
	 void code();
}

class Laptop implements Computer
{
	public void code()
	{
		System.out.println("coding using laptop");
	}
}

class Desktop  implements Computer
{
	public void code()
	{
		System.out.println("coding using desktop");
	}
}

class Developer
{
	void doingCode(Computer computer)
	{
		computer.code();
	}
}

public class _2_WhyWeNeedInterface 
{

	public static void main(String[] args) 
	{ 
		Laptop laptop = new Laptop();
		Desktop desktop = new Desktop();
		Developer developer = new Developer();
		developer.doingCode(laptop); //this is tight coupling between Developer and Laptop
		
		//developer.doingCode(desktop);
		
		Computer laptopp = new Laptop();
		Computer desktopp = new Desktop();
		
		Developer developer2 = new Developer();
		developer2.doingCode(desktopp);
		developer2.doingCode(laptopp);

	}
}
