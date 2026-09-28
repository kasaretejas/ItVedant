package package_2;

import package_1.Student;

public class OutsidePackageWithInheritance extends Student //all Student class members are available to OutsidePackageWithInheritance
{

	public static void main(String[] args) 
	{
		OutsidePackageWithInheritance x = new OutsidePackageWithInheritance();
		
		System.out.println(x.publicName);
		System.out.println(x.protectedAge);
		System.out.println(x.defaultPhone);
		System.out.println(x.privateCity);

	}

}
