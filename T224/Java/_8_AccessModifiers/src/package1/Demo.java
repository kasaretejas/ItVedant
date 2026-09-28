package package1;

public class Demo 
{

	public String iamPublic = "I am Public";
	protected String iamProtected = "I am Protected";
	String iamDefault = "I am Default";
	private String iamPrivate = "I am Private";
	
	public static void main(String[] args) 
	{
		Demo demo = new Demo();
		System.out.println(demo.iamPublic);
		System.out.println(demo.iamProtected);
		System.out.println(demo.iamDefault);
		System.out.println(demo.iamPrivate);

	}

}


