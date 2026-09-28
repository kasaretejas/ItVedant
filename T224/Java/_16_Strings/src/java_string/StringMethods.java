package java_string;

import java.util.Arrays;

public class StringMethods {

	public static void main(String[] args) 
	{
		System.out.println("hello".length());
		
		System.out.println("hello".toUpperCase());
		System.out.println("HELLO".toLowerCase());
	
		System.out.println("hello".charAt(1));
		
		System.out.println("hello".equals("Hello"));
		System.out.println("hello".equalsIgnoreCase("Hello"));
		
		System.out.println("hello".contains("lo"));
		System.out.println("hello".contains("y"));
		
		System.out.println("hello".startsWith("he"));
		System.out.println("hello".endsWith("lo"));
		
		System.out.println("hello".indexOf("l"));
		System.out.println("hello".lastIndexOf("l"));
		
		String s1="hello";
		System.out.println(s1); //hello
		String s2=s1.concat("bye");
		System.out.println(s1); //hello
		System.out.println(s2);
		
		String s3 ="blahblah";
		s3.replace('a', 'k');
		System.out.println(s3);
		String s4=s3.replace('a', 'k');
		System.out.println(s4);
		
		
		System.out.println("  bye  ".length());
		System.out.println("  bye  ".trim().length());
		System.out.println("  bye".trim().length());
		
		String splittedString[]="A-B-C".split("-");
		System.out.println(Arrays.toString(splittedString));
		
		String numInString=String.valueOf(400);
		System.out.println(numInString);
		String charInString=String.valueOf('a');
		System.out.println(charInString);
		
		String s6="hello";
		char[] s6Array = s6.toCharArray();
		System.out.println(Arrays.toString(s6Array));
		
		System.out.println("     ".isEmpty());
		System.out.println("".isEmpty());
		System.out.println("     ".isBlank());
	
		

	}

}
