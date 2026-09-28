package wrapper_class;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) 
	{
		//ArrayList<int> list = new ArrayList<>();   ERROR
		ArrayList<Integer> list = new ArrayList<>();
		
		String a = "12";
		String b = "45";
		System.out.println(a+b);
		int x=Integer.parseInt(a);
		int y=Integer.parseInt(b);
		System.out.println(x+y);
		
		System.out.println(Integer.max(10, 30));
		System.out.println(Integer.min(10, 30));
		
		int p=Integer.valueOf("24");
		
		
		//boxing 
		int d=32;
		Integer e = Integer.valueOf(d); //converted primitive to object : manually - boxing
		Integer f = d; //converted primitive to object : automatically by jvm - autoboxing
	
		//unboxing
		Integer g = 27;
		int h = (int) g; //converted object to primitive : manually - unboxing
		int i = g; //converted object to primitive : automatically by jvm - autounboxing
	
	}

}
