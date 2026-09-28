package java_string;

public class StringsInJava {

	public static void main(String[] args) 
	{
		String s1 = "hello"; //--> inside SCP
		String s2 = "hello"; //--> inside SCP, shared same location as s1 as they have same value
		String s3 = "bye";   //--> inside SCP
		
		String s4 = new String("hello"); //--> inside heap memory
		String s5 = new String("hello"); //--> inside heap memory
		
		//== operator on string is used for reference(memory location) comparison
		System.out.println(s1==s2); //true as they shared same memory location
		System.out.println(s4==s5); //false as they shared different memory location
		
		//.equals() built in method in string used for content comparison
		System.out.println(s1.equals(s2)); //true
		System.out.println(s4.equals(s5)); //true
		System.out.println(s1.equals(s5)); //true
		
		//string built in methods
		

	}

}
