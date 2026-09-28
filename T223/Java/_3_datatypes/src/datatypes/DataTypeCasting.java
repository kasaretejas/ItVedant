package datatypes;

public class DataTypeCasting {

	public static void main(String[] args) 
	{
		//byte > short  >  int  > long   >  float  >  double
		// 1   >  2     >   4   >  8     >   4     >    8
		// --------------------------------->  automatically by JVM : type conversion
		//<---------------------------------   forcefully by developer : type casting
		
		byte byte_data = 10;
		short short_data = 20;
		int int_data = 30;
		long long_data = 40l;
		
		int n = short_data;  //here 2 bytes(short) are getting store into 4 bytes(int) --> automatically
		int m = (int)long_data; //here 8 byte are getting store into 4 byte ---> forcefully
		
		float f = long_data; //here 8 bytes(long) are getting store into 4 bytes(float) --> automcatically by jvm
		//but there is chance of data manipulation
		System.out.println(long_data);
		System.out.println(f);
		
		float float_data = 42.29f;
		int p = (int) float_data; 
		//there is chance of data manipulation
		System.out.println(float_data);
		System.out.println(p);
		
		//type conversion : converting one data type into another
		//data type conversion (implicit) : when JVM converts one data type into another (automatically)
		//data type casting (explicit) : when developer forcefully/manually converts one data type to another

	}

}
