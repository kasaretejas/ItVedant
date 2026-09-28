package basics;

public class StringCreation {

	public static void main(String[] args)
	{
		String name = "raj";
		String city = new String("pune");
		
		String s1 = "hello";
		String s2 = "hello";
		String s3 = "bye";
		
		String s4 = new String("hello");
		String s5 = new String("hello");
		String s6 = new String("bye");
		
		System.out.println(s1==s2); //true ---> comparing hello with hello
		System.out.println(s4==s5); //false --> comparing hello with hello
		
		System.out.println("--------------");
		
		System.out.println(s1.equals(s2));// true ---> comparing hello with hello
		System.out.println(s4.equals(s5));// true ---> comparing hello with hello
		
		//what is diff between == and equals()
		// == ---------> compares memory location
		//equals() ----> compares values
		
		System.out.println(s3==s6);  //false
		System.out.println(s3.equals(s6)); //true

	}

}


