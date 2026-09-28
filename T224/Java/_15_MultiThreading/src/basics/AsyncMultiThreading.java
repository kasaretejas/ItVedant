package basics;
class Counter
{
	int count;
	void changeCounter()
	{
		count+=1;
	}
}

class Thread_1 extends Thread
{
	Counter counter;
	Thread_1(Counter counter)
	{
		this.counter=counter;
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
class Thread_2 extends Thread
{
	Counter counter;
	Thread_2(Counter counter)
	{
		this.counter=counter;
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


public class AsyncMultiThreading {

	public static void main(String[] args) throws InterruptedException 
	{
		Counter counter = new Counter();
	
		Thread_1 t1 = new Thread_1(counter);
		Thread_2 t2 = new Thread_2(counter);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(counter.count);
	}

}
