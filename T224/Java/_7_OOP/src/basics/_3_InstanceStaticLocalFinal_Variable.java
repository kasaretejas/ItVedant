package basics;

class Car
{
	String model;  //instance
	float price;   //instance
	static String brand="Mahindra";  //static
	final String color="black";  //final
	
	Car(String model,float price)
	{
		this.model=model; //initializing instance variable
		this.price=price; //initializing instance variable
	}
	
	void engine()
	{
		String capasity="1500HP"; //local variable : inside a method
		System.out.println(capasity);
	}
}


public class _3_InstanceStaticLocalFinal_Variable {

	public static void main(String[] args) 
	{
		Car car= new Car("scorpion", 4500);
		
		System.out.println(car.model); //correct way of accessing instance variable : using reference variable
		System.out.println(car.price); //correct way of accessing instance variable : using reference variable
		
		System.out.println(car.brand); //not correct way of accessing static variable 
		System.out.println(Car.brand); //correct way of accessing static variable : using class name
		
		System.out.println(car.color);
		//car.color="blue"; //we can not re-assigned final variable(value is fixed)
		
		
		//System.out.println(car.capasity); //cant access local variable outside a method

	}

}
