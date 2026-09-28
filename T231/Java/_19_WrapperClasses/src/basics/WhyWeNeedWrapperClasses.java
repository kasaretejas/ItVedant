package basics;

import java.util.ArrayList;
import java.util.List;

class Student {}

public class WhyWeNeedWrapperClasses {

	public static void main(String[] args) 
	{
		
		ArrayList<Student> list1 = new ArrayList<>();
		//what is Student : class 
		//Student class is defined by us
		
		ArrayList<Integer> list2 = new ArrayList<>();
		//what is Integer : class 
		//Integer class is written by java
		
		//ArrayList<int> list3 = new ArrayList<>();
		//what is int : primitive data Type
		
		//conclusion : inside <> brackets of collection, we must have to put class name ONLY
		
		//while creating collection we compulsory have to provide class name ONLY.
		//it is possible to create collection od Employee, Student, Car, Plane, Bike etc, WHY? becuse the are classes
		
		//now, it is not possible to create collection of int, float, long , double etc.  WHY ? because they are not claases
		
		//therefor java has created claases for primitive data type calles as : WRAPPER CLASSES
		//byte ---- Byte
		//short ---- Short .....
		
		
		//convert string to int
		String n1 = "10";
		String n2 = "30";
		System.out.println(n1+n2);
		
		int x1=Integer.parseInt(n1);
		int x2=Integer.parseInt(n2);
		System.out.println(x1+x2);
		
		System.out.println(Integer.max(29, 89));
		
		//wrapper classes has built in methods for each wrapper class
		
	}

}
