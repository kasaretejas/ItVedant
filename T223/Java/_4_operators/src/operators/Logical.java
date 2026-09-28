package operators;

public class Logical {

	public static void main(String[] args) 
	{
		// &&  ---> returns true if all conditions are true
		//||   ---> returns true if at least one condition is true
		//!    ---> reverse the result 
		
		System.out.println(5>3 && 5>4 && 5>1); //true
		System.out.println(5>3 && 5>4 && 5<1); //false
		System.out.println(5<3 && 5>4 && 5>1); //false
		
		System.out.println(5<3 || 5<4 || 5>1); //true
		System.out.println(5>3 || 5<4 || 5>1); //true
		
		System.out.println(!(10>5)); //!true ---> false

	}

}
