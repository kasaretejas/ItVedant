package multithreading;
class Thread1 extends Thread
{
	@Override //display two digit numbers
	public void run() 
	{
		for(int i=10; i<=99; i++)
		{
			System.out.println(i);
		}
	}
	
}

class Thread2 extends Thread
{
	@Override //display three digit numbers
	public void run() 
	{
		for(int i=100; i<=999; i++)
		{
			System.out.println(i);
		}
	}
	
}
public class MultiThreading1 {

	public static void main(String[] args) 
	{
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		
		thread1.start();
		thread2.start();

	}

}
