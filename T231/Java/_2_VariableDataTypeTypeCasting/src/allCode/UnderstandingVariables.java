package allCode;

public class UnderstandingVariables 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello Java");
		//-------------------------variable
		//int 6age=30; 
		int age6=30; 
		
		int _age=30; 
		int age=30; 
		
		int Age=30;
		
		//String full name = "raj kumar";
		String fullName = "raj kumar";
		
		//variable declaration and initilization
		int a; //variable declaration
		a=20; //variable initilization
		
		int b=30; //variable declaration and initilization in one step
		
		//int x,y,z = 10,20,30; //ERROR
		
		
		//----------------------------------------datatype
		byte m = 10;
		short n = 20;
		int p= 30;
		
		long q = 40; //in this line 40 is not long type. it is int type 
		long r = 11l; //to define long data type, we have to use either l (small L) or L
		long s = 22L;
		
		//float t = 23.89; //here 23.89 is of type double. and double size is 8 bytes so it can not be fit inside float(size 4 byte)
		float u = 23.89f;
		float v = 23.89F;
		
		double w = 45.90;
		
		//when we write any whole number then its data type is int by default
		//when we write any decimal number then its data type is double  by default
		
		
		//--------------------------------- type casting
		short g = 20;
		int h = g ; //we are storing g of type short (2 bytes) into int (4 bytes) ----> implicit
		
		int i = 10;
		//short j = i ; //error because we are storing int(4 bytes) into short(2 byte)
		short j = (short)i; //here we are forcefully converting i (int type) into short ---> explicit
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
