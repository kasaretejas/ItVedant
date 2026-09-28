package mutithreading;

class Thread1 extends Thread
{
	@Override
	public void run() 
	{
		for(int i=100; i<=999; i++) { System.out.println(i); }
	}
	
}

class Thread2 extends Thread
{
	@Override
	public void run() 
	{
		for(int i=1000; i<=9999; i++) { System.out.println(i); }
	}
	
}


public class MultiThreading {

	public static void main(String[] args) 
	{
		Thread1 t1 =  new Thread1();
		Thread2 t2 =  new Thread2();
		
		t2.start();
		t1.start();

	}

}
