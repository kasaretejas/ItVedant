package multithreading;
class Counter
{
	int count=0;
	//public void changeCounter() //not thread safe
	public synchronized void changeCounter() //thread safe
	{
		count++;
	}
}

class MyThread1 extends Thread
{
	Counter counter;
	MyThread1(Counter counter)
	{
		this.counter = counter;
	}
	@Override
	public void run() 
	{
		for(int i=1; i<=1000; i++)
		{
			counter.changeCounter();
		}
	}
	
}

class MyThread2 extends Thread
{
	Counter counter;
	MyThread2(Counter counter)
	{
		this.counter = counter;
	}

	@Override
	public void run() 
	{
		for(int i=1; i<=1000; i++)
		{
			counter.changeCounter();
		}
	}
	
}
public class MultiThreading2 {

	public static void main(String[] args) throws InterruptedException 
	{
		Counter counter = new Counter();
		MyThread1 thread1 = new MyThread1(counter);
		MyThread2 thread2 = new MyThread2(counter);
		
		thread1.start(); //this will inc counter to 1000
		thread2.start(); //this will inc counter to 1000
		//---------------------------------------------------
		//----------------------------------------- 2000
		
		//System.out.println(counter.count);
		thread1.join();
		thread2.join();
		System.out.println(counter.count);

	}

}
