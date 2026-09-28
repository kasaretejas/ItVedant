package basics;

public class _1_Basics 
{

	public static void main(String[] args) 
	{
		// 1. compile time exception
		//System.out.Println("hii"); //here P is capital
		
		// 2. exception handled by Java : always abnormal termination
		System.out.println("code starts");
		//System.out.println(4/0); //Exception in thread "main" java.lang.ArithmeticException: / by zero
		System.out.println("code ends");
		//conclusion : 
				//1. the line on which exception raise, will not get execute
				//2. the code after line on which exception rasied, will not executes
		
		// exception handled by developer
			//1. find out risky code and put into try block
			//2. add respective handling code in catch
		
		//example code:
			//System.out.println("code starts");
			//System.out.println(4/0); 
			//System.out.println("code ends");
		//Exeption Handling code
			System.out.println("-------------------------");
			System.out.println("code starts");
			try
			{
				System.out.println(4/0); 
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				System.out.println("can not divide any number by zero");
			}
			System.out.println("code ends");
		

	}

}
