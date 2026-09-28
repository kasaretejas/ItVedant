package mutithreading;

class Demo extends Thread
{
	@Override
	public void run() 
	{
		for(int i=1; i<=10; i++)
		{
			System.out.println(i);
		}
	}
}

public class ThreadUsingThreadClass {
	public static void main(String[] args) 
	{
		Demo demo = new Demo();
		demo.start();

	}

}
