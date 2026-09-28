package multithreading;

class Demo implements Runnable
{
	@Override //task for thread : display 5 to 1 numbers
	public void run() 
	{
		for(int i=5; i>=1; i--)
		{
			System.out.println(i);
		}	
	}
	
}
public class ByRunnableInterface {

	public static void main(String[] args) 
	{
		Demo demo =  new Demo();
		//demo.start();
		Thread thread = new Thread(demo);
		thread.start();

	}

}
