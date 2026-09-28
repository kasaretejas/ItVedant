package looping_statements;

public class NestedForLoop {

	public static void main(String[] args) 
	{
		//display 1 to 3 numbers
		for(int i=1; i<=3; i++)
		{
			//System.out.println(i);
			//System.out.print(i);
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("------------------");
		
		
		for(int p=1; p<=4; p++)
		{
			for(int i=1; i<=3; i++)
			{
				System.out.print(i);
			}
			System.out.println();
		}
		
		//
		

	}

}
















