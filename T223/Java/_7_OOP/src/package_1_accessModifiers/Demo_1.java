package package_1_accessModifiers;

public class Demo_1 {

	public static void main(String[] args) 
	{
		Test_1 test1 = new Test_1();
		System.out.println("------ inside Demo1 class, package_1 ----------");
		System.out.println(test1.publicMember);
		System.out.println(test1.protectedMember);
		System.out.println(test1.defaultMember);
		//System.out.println(test1.privateMember);

	}

}
