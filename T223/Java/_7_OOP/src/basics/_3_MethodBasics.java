package basics;
// method syntax :
// accessModifier [nonAccessModifier] retuenType methodName([parameters])
// {
	//logic
// }

//accessModifiers : public, private, protected, default
//nonAccessModifiers : static, final, abstract,......
//return type:
	//type of value that method is going to return
	//void means the method is not going to return any value

class Calculator
{
	//variation 1 : simple method
	void addition() //method will not return any value
	{
		int n1=20; //local variable
		int n2=81; //local variable
		System.out.println(n1+n2);
	}
	
	//variation 2 : with return type
	int substraction() //method will  return int value
	{
		int n1 = 26;
		int n2 = 8;
		int sub = n1-n2;
		return sub; //returned value goes to the method call (line number 39)
	}
	
	//variation 3 : with parameters, arguments and return
	int multiplication(int n1, int n2)
	{
		int multi = n1*n2;
		return multi;
	}
	
}

public class _3_MethodBasics {
	public static void main(String[] args) 
	{
		Calculator calculator = new Calculator();
		calculator.addition();
		
		calculator.substraction(); //here we have got value but there is no print.
		System.out.println(calculator.substraction());
		System.out.println(calculator.substraction());
		int returnedValueFromSubstraction=calculator.substraction();
		System.out.println(returnedValueFromSubstraction);
		System.out.println(returnedValueFromSubstraction);
		System.out.println(returnedValueFromSubstraction);
		
		int output=calculator.multiplication(12, 5);
		System.out.println(output);

	}
}
