package _2_methods;

class Calculator
{
	//method syntax
	//[accessModifier] [nonAccessModifier] returnType methodName([parameter(s)]) {}
	//accessModifier -----> public, protected, default, private
	//nonAccessModifier --> static, final, abstract
	//returnType----------> type of value that method is going to return. if no value then use void
	//methodName ---------> you can give any name according to naming conventions
	//parameter(s) -------> values required for the method
	
	//ex : public static void main(String[] args)
	
	//method variation 1 : simple method
	void add()
	{
		int x1 = 12;
		int x2 = 34;
		System.out.println(x1+x2);
	}
	
	//method variation 2 : with parameter and argument
	void sub(int n1, int n2) //n1 and n2 are parameters
	{
		int result = n1-n2;
		System.out.println("Substraction is "+ result);
	}

	//method variation 2 : with parameter,argument, return type
	float div(float n1, float n2) //this method is going to return float value
	{
		float result = n1/n2;
		//return "hello"; // ----------- ERROR ------ data type mismatched
		//return 12; ------------------- NO ERROR --- because of implicit type casting
		return result;
	}

}


public class _1_AboutMethod {

	public static void main(String[] args) 
	{
		Calculator calculator = new Calculator();
		calculator.add();
		calculator.add();
		calculator.add();
		
		calculator.sub(8, 3); //8 and 3 are arguments ---> values passed to the method
		calculator.sub(4, 3);
		calculator.sub(6, 3);
		
		calculator.div(12, 5);
		System.out.println(calculator.div(12, 5));
		float divResult=calculator.div(12, 2);
		System.out.println(divResult);

	}

}
