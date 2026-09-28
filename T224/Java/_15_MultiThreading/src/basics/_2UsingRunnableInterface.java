package basics;

class Demo implements Runnable
{
	@Override
	public void run() 
	{
		System.out.println("inside run, executed by :" + Thread.currentThread().getName());
		for(int i=1; i<=5; i++)
		{
			System.out.println(i);
		}	
	}
}

public class _2UsingRunnableInterface {

	public static void main(String[] args) 
	{
		System.out.println(Thread.currentThread().getName());
		
		Demo demo = new Demo();
		Thread thread = new Thread(demo);
		thread.setName("my thread");
		thread.start();

	}

}
