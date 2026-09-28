package basics;

import java.util.ArrayList;

public class WhyWeNeedGenerics {

	public static void main(String[] args) 
	{
		ArrayList list1 = new ArrayList();
		list1.add(10);
		list1.add("hello");
		list1.add(76.90);
		System.out.println(list1);
		
		int firstElement=(int) list1.get(0);
		String secondElement= (String) list1.get(1);
		
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(10);
		list2.add(65);
		//list2.add("hii");
		
		int n1=list2.get(0);
		int n2=list2.get(1);
		
		boolean n3=list2.get(0);

	}

}
