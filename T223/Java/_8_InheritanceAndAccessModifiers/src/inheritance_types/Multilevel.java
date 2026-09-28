package inheritance_types;
class C
{
	int c = 20;
}

class D extends C
{
	int d = 50;
}

class E extends D
{
	int e = 40;
}
public class Multilevel 
{

	public static void main(String[] args) 
	{
		E e_reference = new E();
		System.out.println(e_reference.c);
		System.out.println(e_reference.d);
		System.out.println(e_reference.e);

	}

}
