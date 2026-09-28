package basics;
abstract class Vehicle
{
	abstract void wheels();
	void mirrors () { System.out.println("Vehicle has 2 mirrors");   }
}

class Car extends Vehicle 
{
	void wheels() {  System.out.println("car has 4 wheels"); }
}

class Bike extends Vehicle {} 
//If we arent providing body for Wheels() method in Bike class then, Bike class will be treated as abstract class

public class AbstractModifier {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	}

}
