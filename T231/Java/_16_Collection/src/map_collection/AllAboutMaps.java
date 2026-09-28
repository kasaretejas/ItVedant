package map_collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class AllAboutMaps {

	//data in key value pair
	//indexing is not allowed
	//duplicate keys are not allowed
	//value can be duplicate
	public static void main(String[] args) 
	{
		HashMap<Integer, String> hashMap = new HashMap<>();
		hashMap.put(8, "raj");
		hashMap.put(10, "raj");
		hashMap.put(7, "amit");
		hashMap.put(3, "amit");
		hashMap.put(10, "aniket"); //here value will be override
		System.out.println(hashMap);
		
		
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put(8, "raj");
		linkedHashMap.put(10, "raj");
		linkedHashMap.put(7, "amit");
		linkedHashMap.put(3, "amit");
		linkedHashMap.put(10, "aniket"); //here value will be override
		System.out.println(linkedHashMap);
		
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(8, "raj");
		treeMap.put(10, "raj");
		treeMap.put(7, "amit");
		treeMap.put(3, "amit");
		treeMap.put(10, "aniket"); //here value will be override
		System.out.println(treeMap);

	}

}
