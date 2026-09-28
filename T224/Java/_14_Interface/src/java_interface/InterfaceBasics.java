package java_interface;
interface Vehicle
{
	void wheels(); //public abstract void wheels();
	int mirrors=2; //public static final int mirrors=2;
	default void display() { System.out.println("default method"); }
	static void show() { System.out.println("static method"); }
}

class Car implements Vehicle
{
	@Override
	public void wheels()
	{
		System.out.println("car has 4 wheels");
	}
}



public class InterfaceBasics {

	public static void main(String[] args) 
	{
		Car car = new Car();
		car.wheels();
		System.out.println(car.mirrors);
		System.out.println(Car.mirrors);
		//Car.mirrors = 4;
		car.display();
		Vehicle.show();
	}

}
