package lambda_expression;

@FunctionalInterface
interface Vehikle
{
	void wheels(); 
}


public class UnderstandingAnonumousClass {

	public static void main(String[] args) 
	{
		Vehikle bike = new Vehikle() 
		{
			
			@Override
			public void wheels() 
			{
				System.out.println("bike has 2 wheels");
			}
		};
		
		bike.wheels();

	}

}

