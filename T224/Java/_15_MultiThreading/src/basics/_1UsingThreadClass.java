package basics;
class Test extends Thread
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
public class _1UsingThreadClass {

	public static void main(String[] args) 
	{
		System.out.println(Thread.currentThread().getName());
		
		Test test = new Test();
		test.start(); //correct way of calling/executing thread
		
		test.run(); //not recommonded. this is simple method call. not thread call

	}

}
