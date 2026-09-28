package package_2_accessModifiers;

import package_1_accessModifiers.Test_1;

public class Display extends Test_1{

	public static void main(String[] args) 
	{
		System.out.println("------ inside Display class (with inheritance), package_2 ----------");
		Display display = new Display();
		System.out.println(display.publicMember);
		System.out.println(display.protectedMember);
		//System.out.println(display.defaultMember);
		//System.out.println(display.privateMember);

	}

}
