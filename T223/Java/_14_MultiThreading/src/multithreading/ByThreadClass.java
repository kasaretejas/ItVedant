package multithreading;



class Test extends Thread
{
	@Override //task for thread : display 1 to 5 numbers
	public void run() 
	{
		for(int i=1; i<=5; i++)
		{
			System.out.println(i);
		}
		
	}	
}
public class ByThreadClass {

	public static void main(String[] args) 
	{
		Test test = new Test();
		test.start();
	}
}
