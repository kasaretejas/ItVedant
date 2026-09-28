package inheritance_types;

class Parent
{
	int p=10;
}

class Child1 extends Parent
{}

class Child2 extends Parent
{}

public class Hierarchical {

	public static void main(String[] args) 
	{
		Child1 child1 = new Child1();
		System.out.println(child1.p);
		
		Child2 child2 = new Child2();
		System.out.println(child2.p);

	}

}
