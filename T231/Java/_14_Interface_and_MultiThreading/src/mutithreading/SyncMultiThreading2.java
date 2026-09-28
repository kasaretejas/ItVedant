package mutithreading;

class View 
{
	synchronized void show()
	{
		for(int i=1; i<=1000; i++)
		{
			System.out.println(i);
		}
	}
}

class MyThreadd extends Thread
{
	View view = new View();
	@Override
	public void run() 
	{
		view.show();
	}
	
}

public class SyncMultiThreading2 
{
	public static void main(String[] args) 
	{
		MyThreadd thread1 = new MyThreadd();
		MyThreadd thread2 = new MyThreadd();
		
		thread1.start();
		thread2.start();
	}
	
}
