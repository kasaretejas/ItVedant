package package_1;

public class InsideSamePackageOutsideClass 
{
	public static void main(String[] args) 
	{
		Student student = new Student();
		
		System.out.println(student.publicName);
		System.out.println(student.protectedAge);
		System.out.println(student.defaultPhone);
		System.out.println(student.privateCity);

	}

}
