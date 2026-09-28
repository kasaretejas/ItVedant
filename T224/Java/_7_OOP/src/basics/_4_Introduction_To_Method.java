package basics;

class Calculator
{
	//simple method
	 void add() 
	 {
		 int n1=20;
		 int n2=18;
		 System.out.println("addition is :"+(n1+n2));
	 }
	 
	 //method with parameters
	 void multiply(int n1, int n2)  //here n1 and n2 are parameters
	 {
		 System.out.println("Multiplication is :"+(n1*n2));
	 }
	 
	 //method with return type
	 int sub(int n1, int n2)  //here n1 and n2 are parameters
	 {
		 int result = n1-n2;
		 return result;
	 }
}


public class _4_Introduction_To_Method {

	public static void main(String[] args) 
	{
		//method : block of code, get executed when we call it!
		//syntax : 
		//[non-access modifiers] [access modifiers] returnType methodName([parameter/s]) {}
		//non-access modifiers : static, final, abstract etc
		//access modifiers : public, protected, default, private
		//returnType : the datatype that is method going to be returned (all data types)
					// ex- if method is returning "hello" then return type is String
					// ex- if method is returning 56 then return type is int
					// void : when method is not going to return any value
					//returnType and data type of value that we returned, must be match/same
		//when method return any value, that value goes to method call
		Calculator calculator = new Calculator();
		calculator.add();
		calculator.add();
		
		//calculator.multiply(); //ERROR: multiply method required n1, n2 (parameters) so we have to pass arguments
		calculator.multiply(2, 8); //here 2 and 8 are called as arguments
		
		calculator.sub(10, 2);
		System.out.println(calculator.sub(10, 2));
		System.out.println(calculator.sub(10, 2));
		
		int output=calculator.sub(10, 2);
		System.out.println(output);
		System.out.println(output);
	}

}







