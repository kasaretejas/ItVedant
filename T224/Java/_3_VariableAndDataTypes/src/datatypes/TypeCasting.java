package datatypes;

public class TypeCasting 
{
	public static void main(String[] args) 
	{
		// byte > short > int > long > float > double -->automatic/implicit/widening
		// byte < short < int < long < float < double -->manual/explicit/narrowing
		
		int a = 10;
		long b = a; //added int(4 byte) into long(8 byte) --> automatic 
		
		short c = 15;
		//byte d = c; //adding short(2 byte) into byte(1 byte) --> NOT POSSIBLE
		byte e = (byte)c; //manually converted short(2 byte) into byte(1 byte)
		
	}
}
