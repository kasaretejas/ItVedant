package basics;

@FunctionalInterface
interface AC
{
	void cooling();
}

class BedRoom implements AC
{
	@Override
	public void cooling()
	{
		System.out.println("BedRoom is cooling");
	}
}

public class _7_LambdaExpression {

	public static void main(String[] args) 
	{
		//named class with functional interface
		BedRoom bedRoom = new BedRoom();
		bedRoom.cooling();
		
		//anonymous class with functional interface
		AC hall = new AC() 
		{
			@Override
			public void cooling() 
			{
				System.out.println("Hall is cooling");
				
			}
		};
		
		hall.cooling();
		
		//anonymous class + anonymous method (lambda expression) with functional interface
		AC kitchen = () -> 
		{
				System.out.println("Kitchen is cooling");	
		};
		
		kitchen.cooling();

	}

}






