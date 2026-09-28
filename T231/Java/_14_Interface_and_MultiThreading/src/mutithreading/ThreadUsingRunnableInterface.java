package mutithreading;

class Test implements Runnable
{
	@Override
	public void run() 
	{
		for(int i=10; i>=1; i--)
		{
			System.out.println(i);
		}
	}
	
}
public class ThreadUsingRunnableInterface {
	public static void main(String[] args) 
	{
		Test test = new Test();
		//test.start();
		Thread thread = new Thread(test);
		thread.start();

	}

}
