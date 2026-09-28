package lambda_expression;

@FunctionalInterface
interface Vehicle
{
	void wheels(); 
	//to give body to this method
		//1. create a class and implelemt this interface
		//2. write body to this method
		//3. create object of class
		//4. call this method
}

class Car implements Vehicle
{
	@Override
	public void wheels()
	{
		System.out.println("car has 4 wheels");
	}
}


public class FunctionalInterfaceRecall {

	public static void main(String[] args) 
	{
		Car car = new Car();
		car.wheels();
		
		

	}

}
