package basics;

public class _2WithTryCatch 
{
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
		System.out.println("end");
		
		
	}
}
