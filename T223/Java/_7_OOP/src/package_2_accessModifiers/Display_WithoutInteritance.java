package package_2_accessModifiers;

import package_1_accessModifiers.Test_1;

public class Display_WithoutInteritance {

	public static void main(String[] args) 
	{
		Test_1 test1 = new Test_1();
		System.out.println("------ inside Display class (without inheritance), package_2 ----------");
		System.out.println(test1.publicMember);
//		System.out.println(test1.protectedMember);
//		System.out.println(test1.defaultMember);
//		System.out.println(test1.privateMember);

	}

}
