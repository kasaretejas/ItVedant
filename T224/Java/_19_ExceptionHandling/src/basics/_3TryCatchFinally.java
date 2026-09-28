package basics;

public class _3TryCatchFinally {

	public static void main(String[] args) 
	{
		System.out.println("start");
		int x=15;
		//int y=3;
		int y=0;
		try
		{
			double result = x/y;
			System.out.println(result);
		}
		catch (Exception e) 
		{
			System.out.println("cant divide any number by zero");
		}
		finally
		{
			System.out.println("finally block");
		}
		System.out.println("end");

	}

}
