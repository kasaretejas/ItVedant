package package_1_accessModifiers;

public class Test_1 
{
	public String publicMember = "I am public";
	protected String protectedMember = "I am protected";
	String defaultMember = "I am default";
	private String privateMember = "I am private";

	public static void main(String[] args) 
	{
		Test_1 test1 = new Test_1();
		System.out.println("------ inside Test_1 class, package_1 ----------");
		System.out.println(test1.publicMember);
		System.out.println(test1.protectedMember);
		System.out.println(test1.defaultMember);
		System.out.println(test1.privateMember);

	}

}
