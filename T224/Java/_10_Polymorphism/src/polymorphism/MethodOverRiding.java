package polymorphism;
class A
{
	void display()
	{
		System.out.println("dispaly from class A");
	}
}

class B extends A
{	
	@Override
	void display()
	{
		System.out.println("dispaly from class B");
		super.display();
	}
}


public class MethodOverRiding {

	public static void main(String[] args) 
	{
		B b = new B();
		b.display();
		b.display();

	}

}
