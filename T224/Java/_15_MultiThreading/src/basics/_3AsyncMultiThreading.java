package basics;

class Thread1 extends Thread
{
	_3AsyncMultiThreading amt;
	Thread1(_3AsyncMultiThreading amt)
	{
		this.amt = amt;
	}
	@Override
	public void run()
	{
		for(int i=1; i<=1000;i++)
		{
			amt.counter++;
		}
	}
}

class Thread2 extends Thread
{
	_3AsyncMultiThreading amt;
	Thread2(_3AsyncMultiThreading amt)
	{
		this.amt = amt;
	}
	@Override
	public void run()
	{
		for(int i=1; i<=1000;i++)
		{
			amt.counter++;
		}
	}
}
public class _3AsyncMultiThreading 
{
	int counter;

	public static void main(String[] args) throws InterruptedException 
	{
		_3AsyncMultiThreading amt = new _3AsyncMultiThreading();
		//amt.counter=12;
		System.out.println(amt.counter);
	
		
		Thread1 thread1 = new Thread1(amt);
		Thread2 thread2 = new Thread2(amt);
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		System.out.println(amt.counter);
	}

}
