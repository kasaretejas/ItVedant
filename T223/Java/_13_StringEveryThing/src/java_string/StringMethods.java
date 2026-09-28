package java_string;

import java.util.Arrays;

public class StringMethods {

	public static void main(String[] args) 
	{
		String s1 = "hello";
		System.out.println(s1.length());
		System.out.println("hello".length());
		System.out.println("hello".charAt(0)); //character at index 0 --> h
		//System.out.println("hello".charAt(5)); //character at index 5 --> ERROR
		
		String s2 = "Java1#"; //['J','a','v','a','1','#'] ==> character array
		char charArray[]=s2.toCharArray();
		System.out.println(Arrays.toString(charArray));
		for(char character :charArray)
		{
			System.out.println(character);
		}
		
		
		//built in methods
		System.out.println("hello".compareTo("hello")); //0
		System.out.println("hello".compareTo("hel")); //2 in both strig there is difference in 2 characters
		
		String s="hello";
		System.out.println(s.concat("bye"));
		String newS=s.concat("bye");
		System.out.println(s);
		System.out.println(newS);
		
		System.out.println(s.replace("e", "-"));
		System.out.println(s);

		System.out.println("hello".contains("he"));
		System.out.println("hello".endsWith("o"));
		System.out.println("hello".startsWith("h"));
		System.out.println("hello".equals("Hello"));
		System.out.println("hello".equalsIgnoreCase("Hello"));
		
		System.out.println("hello".indexOf('l')); //first occurance
		System.out.println("hello".lastIndexOf("l")); //last occurance
		System.out.println("hello".indexOf("he"));
		System.out.println("hello".indexOf('h', 1));
		
		
		System.out.println("hello".toUpperCase());
		System.out.println("Hello".toLowerCase());
		
		System.out.println(Arrays.toString("Hello".split("e")));
	}

}





