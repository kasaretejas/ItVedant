package operators;

public class UnaryAndTernary 
{
	public static void main(String[] args) 
	{
		//++,--
		int x=10;
		
		System.out.println(--x + ++x - x--);
		
		int y = 12;
		
		System.out.println(y-- + ++y - y++ - 3 + --y);
		//                 9+12 =21
		
		System.out.println(10<2?"YES":"NO");
		
		
		
	}
}
