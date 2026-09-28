package java_string;

public class StringBasics 
{
	public static void main(String[] args) 
	{
		String s1 = "hello";
		String s2 = "hello";
		String s3 = "bye";
		
		String s4 = new String("hello");
		String s5 = new String("hello");
		
		//proof that s1 and s2 shares same memory location
		System.out.println(s1==s2);
		
		//proof that s4 and s5 shares same memory location
		System.out.println(s4==s5);
		
		//proof that s1,s2,s4,s5 has same content/value
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s4));
		
		
	}
}
