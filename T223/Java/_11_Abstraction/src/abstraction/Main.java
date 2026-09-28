package abstraction;

abstract class Test {}  //An abstract class can have zero abstract method.


abstract class Vehicle
{
		abstract void wheels();
		
		void mirrors() //Abstract class can have non abstract methods
		{
			System.out.println("Vehicle has 2 mirrors");
		}	
}

class Car extends Vehicle
{	
	@Override
	void wheels()
	{
		System.out.println("Car has 4 wheels");
	}		
}
public class Main {

	public static void main(String[] args) 
	{
		// Vehicle vehicle = new Vehicle(); ERROR
		Car car = new Car();
		car.wheels();
		car.mirrors();

	}

}
