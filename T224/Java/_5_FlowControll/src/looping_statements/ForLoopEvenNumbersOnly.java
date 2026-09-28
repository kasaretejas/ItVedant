package looping_statements;

public class ForLoopEvenNumbersOnly {

	public static void main(String[] args) {
		//display only even no between 37 to 23
		for(int i=37; i>=23; i--)
		{
			if(i%2==0)
			{
				System.out.println(i);
			}
		}

	}
}
