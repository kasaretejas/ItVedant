package basics;

public class StringMethods {

	public static void main(String[] args) 
	{
		String name="AniKet223#";
		System.out.println(name.charAt(0));
		System.out.println(name.length());
		System.out.println(name.compareTo("hi"));
		System.out.println(name.concat("BYE"));
		
		String newName = name.concat("BYE");
		System.out.println(name);
		System.out.println(newName);
		
		

	}

}
