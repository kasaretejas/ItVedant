package inheritrance_types;

class R { int r=10; }
class S extends R{ int s=20; }
class T extends S{ int t=30; }
class U extends R{ int u=40; }

public class Hybrid {

	public static void main(String[] args) 
	{
		T objectT = new T();
		System.out.println(objectT.r);
		System.out.println(objectT.s);
		System.out.println(objectT.t);
		
		U objectU = new U();
		System.out.println(objectU.r);
		System.out.println(objectU.u);

	}

}
