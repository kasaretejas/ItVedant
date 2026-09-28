package lambda_expression;

@FunctionalInterface
interface Vehical
{
	void wheels(); 
}



public class UnderstandingLambdaExpression {

	public static void main(String[] args) 
	{
		Vehical auto = () ->
		{
			System.out.println("auto has 3 wheels");
		};
		
		auto.wheels();

	}

}
