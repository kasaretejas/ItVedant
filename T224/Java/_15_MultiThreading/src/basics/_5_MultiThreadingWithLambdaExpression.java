package basics;

public class _5_MultiThreadingWithLambdaExpression {

	public static void main(String[] args) 
	{
		Runnable t1 = () -> 
		{
			for(int i=10; i<=99;i++)
			{
				System.out.println(i);
			}
		};
		
		Runnable t2 = () -> 
		{
			for(int i=100; i<=199;i++)
			{
				System.out.println(i);
			}
		};
		
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		
		

	}

}
