package basics;
class MyThread extends Thread
{
	@Override
	public void run()
	{
		System.out.println("Thread is running");
		try 
			{
				System.out.println("Thread going for sleep");
				Thread.sleep(2000);
				System.out.println("Thread comes out of sleep");
			} 
		catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
	}
}
public class _6_ThreadLifeCycle {

	public static void main(String[] args) throws InterruptedException 
	{
		MyThread thread = new MyThread();
		System.out.println(thread.getState());
		
		thread.start();
		System.out.println(thread.getState());
		
		Thread.sleep(500);
		System.out.println(thread.getState());
		
		thread.join();
		System.out.println(thread.getState());
		
		

	}

}
