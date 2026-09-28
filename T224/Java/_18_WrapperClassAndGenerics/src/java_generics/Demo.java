package java_generics;

import java.util.ArrayList;

class Bucket<T>
{
	T value;   //int x, here you will get value of type T

	public T getValue() 
	{
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}


public class Demo {

	public static void main(String[] args) 
	{
		ArrayList hybridList = new ArrayList();
		hybridList.add("hello");
		hybridList.add(10);
		hybridList.add(64.21);
		System.out.println(hybridList);
		
		String s = (String) hybridList.get(0);
		int i =(int) hybridList.get(1);
		
		//in above hybridList, the values are heterogeneous so
		//if we want to unpack them into variable they we must create
		//variables with different data types. while unpacking we have
		//to take care of type casting.
		
		//thus, above hybridList is not type safe.
		
		//next, creating type safe ArrayList
		
		ArrayList<String> names = new ArrayList<>();
		names.add("raj");
		names.add("rani");
		
		System.out.println(names.get(0));
		
		//since above names list is of type string (generic string)
		//we compulsory has to add values of type string and when get
		//get(), we will always get values of type String
		
		
		Bucket<String> bucket = new Bucket<>();
		
		bucket.setValue("hello");
		System.out.println(bucket.getValue());
		//bucket.setValue(45);
		
		Bucket<Integer> bucket2 = new Bucket<>();
		bucket2.setValue(23);
		System.out.println(bucket2.getValue());
		

	}

}
