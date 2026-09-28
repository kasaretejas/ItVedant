package basics;
class Parent
{
	void hello()
	{
		System.out.println("hello from parent");
	}
}

class Child extends Parent
{
	@Override
	void hello()
	{
		System.out.println("hello from child");
	}
}

public class OverRiding {

	public static void main(String[] args) {
		Child child = new Child();
		child.hello();

	}

}
