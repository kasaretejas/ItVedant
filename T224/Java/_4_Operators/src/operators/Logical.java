package operators;

public class Logical {

	public static void main(String[] args) 
	{
		//&&,||,!
		System.out.println(10>2 && 10>5 && 10>3);
		System.out.println(10<2 && 10>5 && 10>3);
		
		System.out.println(10<2 || 10<5 || 10>3);
		System.out.println(10>2 || 10<5 || 10>3);
		
		System.out.println(!true);
		System.out.println(!(10<2));
	}

}
