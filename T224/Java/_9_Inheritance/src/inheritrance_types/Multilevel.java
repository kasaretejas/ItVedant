package inheritrance_types;
class X { int x=10; }
class Y extends X { int y=20; }
class Z extends Y { int z=30; }


public class Multilevel {

	public static void main(String[] args) 
	{
		Z objectZ = new Z();
		System.out.println(objectZ.x);
		System.out.println(objectZ.y);
		System.out.println(objectZ.z);

	}

}
