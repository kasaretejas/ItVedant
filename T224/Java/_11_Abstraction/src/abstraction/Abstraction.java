package abstraction;
abstract class Vehicle
{
	abstract void wheels();
	
	void mirrors()
	{
		System.out.println("Vehicle has 2 mirrors");
	}
}

class Car extends Vehicle
{
	void wheels()
	{
		System.out.println("car has 4 wheels");
	}
}
public class Abstraction {

	public static void main(String[] args) 
	{
		//Vehicle vehicle = new Vehicle();  //ERROR
		Car ciaz =new Car();
		ciaz.wheels();

	}

}
