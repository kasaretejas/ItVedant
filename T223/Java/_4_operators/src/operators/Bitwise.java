package operators;

public class Bitwise {

	public static void main(String[] args) 
	{
		//bitwise operators works on bits. first convert decimal to binary then apply bitwise op
		// & ---> set 1 if all bits are 1
		//|  ---> set 1 if at least one bit is 1
		//^  ---> set 1 if all bits are different
		//~  ---> not ~x = -x-1
		//<< ---> shifts bits to the left by given number
		//>> ---> shifts bits to the right by given number
		
		//2^6    2^5   2^4    2^3    2^2    2^1    2^0
		//64     32    16      8      4      2      1
		
		//                            1      1      1
		//                            4  +   2   +  1 = 7 ==> 0111
		//                            1      0      0
		//                            4  +   0   +  0 = 4 ==> 0100
		
		
		System.out.println(Integer.toBinaryString(7)); //0000 0111
		System.out.println(Integer.toBinaryString(4)); //0000 0100
		
		System.out.println(7&4);
		System.out.println(7|4);
		System.out.println(7^4);
		System.out.println(~7);  //-7-1 = -8
		System.out.println(7<<2); //28
		System.out.println(4>>3); //0
		System.out.println(4>>1); //2
		
		//0  0  0  0  0  1  1  1
		//0  0  0  0  0  1  0  0
		//-------------------------
	//  & 0  0  0  0  0  1  0  0 ========> 4
	//  | 0  0  0  0  0  1  1  1 ========> 7
	//  ^ 0  0  0  0  0  0  1  1 ========> 3
		
		
		
		//7<<2
		//0  0  0  0  0  1  1  1
//  0  0  0  0  0  1  1  1  X  X      ---> on the places of XX there will be 00 
		//4+8+16 =28
		
	
		//4>>1
		//0  0  0  0  0  1  0  0
		//X  0  0  0  0  0  1  0   ===> 2
		
	 	
		
		

	}

}
