package package_1;

public class HasARelationship 
{
	//class HasARelationship HAS-A object of class Main
	public static void main(String[] args) 
	{
		Main main = new Main();
		System.out.println(main.publicMember);
		System.out.println(main.protectedMember);
		System.out.println(main.defaultMember);
		//System.out.println(main.privateMember);
	}

}
