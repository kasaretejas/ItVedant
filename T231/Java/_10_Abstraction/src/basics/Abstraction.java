package basics;
abstract class Vehicle
{
	void mirrors()
	{
		System.out.println("Vehicle has 2 mirrors");
	}
	abstract void wheels();
}

class Car  extends Vehicle
{
//	void mirrors()
//	{
//		System.out.println("Vehicle has 2 mirrors");
//	}
//	abstract void wheels();
	
	void wheels()
	{
		System.out.println("Car has 4 wheels");
	}
}

public class Abstraction {

	public static void main(String[] args) 
	{
		//Car car = new Car();
		//Vehicle vehicle = new Vehicle();
		
		Car car = new Car();
		car.wheels();
		

	}

}
