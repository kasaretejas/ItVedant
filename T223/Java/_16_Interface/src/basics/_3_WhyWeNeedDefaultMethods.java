package basics;
interface Vehicle
{
	void wheels();
	default void mirrors()
	{}
}

class Car implements Vehicle
{
	@Override
	public void wheels() 
	{
		System.out.println("car has 4 wheels");
	}	
}

class Bike implements Vehicle
{
	@Override
	public void wheels() 
	{
		System.out.println("bike has 2 wheels");
	}

	@Override
	public void mirrors() {
		System.out.println("bike has 2 mirrors");
	}
	
	
}
public class _3_WhyWeNeedDefaultMethods {

	public static void main(String[] args) 
	{
		Car car = new Car();
		car.wheels();

	}

}
