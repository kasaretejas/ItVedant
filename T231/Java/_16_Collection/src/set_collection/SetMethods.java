package set_collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SetMethods {

	public static void main(String[] args) 
	{
		List<Integer> numbersList=Arrays.asList(13,89,34,65,55,13);
		System.out.println(numbersList);
		
		
		HashSet<Integer> hashSet = new HashSet<>();
		
		//adding elements
		hashSet.add(25);
		hashSet.add(99);
		System.out.println(hashSet);
		
		hashSet.addAll(numbersList);
		System.out.println(hashSet);
		
		//get elements
		System.out.println(hashSet.contains(13));
		System.out.println(hashSet.contains(234));
		System.out.println(hashSet.isEmpty());
		System.out.println(hashSet.size());
		
		//set to array
		Object[] hashSetArray=hashSet.toArray();
		System.out.println(hashSetArray);
		System.out.println(Arrays.toString(hashSetArray));
		
		//remove
		hashSet.remove(13);
		System.out.println(hashSet);
		hashSet.removeAll(numbersList);
		System.out.println(hashSet);


	}

}
