package inheritrance_types;

class P { int p=10; }

class C1 extends P { int c1=20; }
class C2 extends P { int c2=30; }

public class Hierarchical {

	public static void main(String[] args) 
	{
		C1 objectC1 = new C1();
		System.out.println(objectC1.p);
		System.out.println(objectC1.c1);
		
		C2 objectC2 = new C2();
		System.out.println(objectC2.p);
		System.out.println(objectC2.c2);

	}

}
