package loopingStatements;

public class ForLoop 
{

	public static void main(String[] args) 
	{
		//for(intialization; condition; inc/dec) {}
		System.out.println("---display 1 to 5 numbers---");
		for(int i=1; i<=5; i++)
		{
			System.out.println(i);
		}
		
		System.out.println("---display even no between 1 to 10---");
		for(int i=1; i<=10; i++)
		{
			if(i%2==0)
			{
				System.out.println(i);
			}
		}
		
		System.out.println("---display 37 to 31 numbers---");
		for(int i=37; i>=31; i--)
		{
			System.out.println(i);
		}
		
		//nested for loop
		System.out.println("---- step 1 ----");
		for(int i=1; i<=3;i++)
		{
			System.out.println(i);
		}
		
		System.out.println("---- step 2 ----");
		for(int i=1; i<=3;i++)
		{
			System.out.print(i + "  ");
		}
		
		System.out.println();
		System.out.println("---- step 3 ----");
		for(int i=1; i<=3;i++)
		{
			System.out.print(i + "  ");
		}
		System.out.println();
		for(int i=1; i<=3;i++)
		{
			System.out.print(i + "  ");
		}
		System.out.println();
		for(int i=1; i<=3;i++)
		{
			System.out.print(i + "  ");
		}
		System.out.println();
		
		System.out.println("----- final logic ------");
		for(int j=1; j<=3; j++)
		{
			for(int i=1; i<=3;i++)
			{
				System.out.print(i + "  ");
			}
			System.out.println();
		}
		
		
		System.out.println("---- 5 6 7 logic ----");
		for(int j=1; j<=3; j++)
		{
			for(int i=5; i<=7; i++)
			{
				System.out.print(i+"  ");
			}
			System.out.println();
		}
		
		//1 1 1 
		//2 2 2
		//3 3 3
		System.out.println("--- 111 to 333 ----");
		for(int row=1; row<=3; row++)
		{
			for(int col=1; col<=3; col++)
			{
				System.out.print(row+ "  ");
			}
			System.out.println();
		}
		
		//1  
		//2 2 
		//3 3 3
		
		for(int row=1; row<=3; row++)
		{
			for(int col=1; col<=row; col++)
			{
				System.out.print(row+ "  ");
			}
			System.out.println();
		}
	   //   c3 c2 c1
		//r3 *  *  *  c1r3
		//r2    *  *
		//r1       *
		
		for(int row=3; row>=1; row--)
		{
			for(int col=3; col>=1; col--)
			{
				if(col<=row)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		//     c1  c2  c3
		//r1   1
		//r2   2   3
		//r3   4   5   6
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
