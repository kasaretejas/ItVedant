package datatypes;

public class Introduction {
	//1 byte = 4 bits
	public static void main(String[] args) 
	{
	//primitive datatypes
		//whole numbers
				//byte ----->  1 byte
				//short ---->  2 bytes
				//int  ----->  4 bytes
				//long ----->  8 bytes
				//default datatype for whole numbers is int
				//default value for whole number (byte, short, int, long) is zero 0
		//decimal numbers
				//float  ---> 4 bytes
				//double ---> 8 bytes
				//default datatype for decimal numbers is double
				//default value for decimal number (float,double) is 0.0
				//to write float values we have to use prefix f;
		//true/false values
				// boolean --> 1 byte
				//used to store either true or false
				//default value for boolean is false
		//single character
				//char  ----> 2 bytes
				//used to store single character in single quote
		
		//NON-PRIMITIVE
			//string, array, class, object interface
		
		byte b = 12;
		short s = 34;
		int i = 309;
		long p = 1204l; //here to define long value, we have to use l (small L) or L;
		
		byte n = 150; //here we will get error because data type of 150 is int (size 4 bytes), we can not store into byte (size 1 byte)
		long m = 150; // here no error because m is of type long(size 8 bytes), can store 150 of type int(size 4 byte)
		
		
		//float f = 23.89;  // here 23.89 is of type double 
		float f = 23.89f;   // here, with 23.89, we have used keyword f. that indicates 23.89f is actually float value
		double d = 64.90;
		
		boolean u = true;
		
		char c = 'b';

	}

}
