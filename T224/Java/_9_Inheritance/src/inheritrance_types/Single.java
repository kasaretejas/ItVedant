package inheritrance_types;

class A { int a=10; }
class B extends A { int b=20; }


public class Single {

	public static void main(String[] args) 
	{
		B objectB = new B();
		System.out.println(objectB.a);
		System.out.println(objectB.b);

	}

}
