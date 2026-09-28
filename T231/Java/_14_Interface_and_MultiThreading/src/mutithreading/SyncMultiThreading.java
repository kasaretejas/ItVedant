package mutithreading;

class Display 
{
	synchronized void show(String threadName)
	{
		for(int i=1; i<=1000; i++)
		{
			System.out.println(threadName + " : " + i);
		}
	}
}

class MyThread extends Thread
{
	Display  display;
	String threadName;
	
	public MyThread(Display  display, String threadName) 
	{
		this.display = display;
		this.threadName=threadName;
	}
	@Override
	public void run() 
	{
		display.show(threadName);
	}
	
}

public class SyncMultiThreading {

	public static void main(String[] args) 
	{
		Display display = new Display();
		
		MyThread thread1 = new MyThread(display, "thread 1");
		thread1.start();
		
		MyThread thread2 = new MyThread(display, "thread 2");
		thread2.start();

	}

}
