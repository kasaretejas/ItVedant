package map_collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class AllAboutJavaMaps {

	public static void main(String[] args) 
	{
		HashMap<Integer, String> student1 = new HashMap<>();
		student1.put(6, "raj");
		student1.put(1, "amit");
		student1.put(9, "sumit");
		System.out.println(student1);
		
		student1.put(6, "raju");
		student1.put(2, "sumit");
		System.out.println(student1);
		
		
		LinkedHashMap<Integer, String> student2 = new LinkedHashMap<>();
		student2.put(6, "raj");
		student2.put(1, "amit");
		student2.put(9, "sumit");
		System.out.println(student2);
		
		student2.put(6, "raju");
		student2.put(2, "sumit");
		System.out.println(student2);
		
		TreeMap<Integer, String> student3 = new TreeMap<>();
		student3.put(6, "raj");
		student3.put(1, "amit");
		student3.put(9, "sumit");
		System.out.println(student3);
		
		student3.put(6, "raju");
		student3.put(2, "sumit");
		System.out.println(student3);
		
		System.out.println("-------------------");
		//map methods
		HashMap<Integer, String> employee = new HashMap<>();
		
		//add
		employee.put(109, "raj");
		employee.put(139, "amit");
		System.out.println(employee);
		
		employee.put(109, "rani");
		System.out.println(employee);
		
		employee.putIfAbsent(109, "sumit");
		System.out.println(employee);
		
		employee.putAll(student1);
		System.out.println(employee);
		
		//access
		System.out.println(employee.get(109));
		System.out.println(employee.getOrDefault(1003, "employee not exists"));
		
		//update
		employee.replace(1, "aniket");
		System.out.println(employee);
		
		employee.replace(2, "sumita", "nidhi");
		System.out.println(employee);
		
		//utility
		System.out.println(employee.keySet());
		System.out.println(employee.values());
		System.out.println(employee.size());
		System.out.println(employee.containsKey(1));
		System.out.println(employee.containsValue("aniket"));
		
		//traverse
		for(int key:employee.keySet())
		{
			System.out.println(key +"-"+employee.get(key));
		}
		
		for(Map.Entry<Integer, String> entry:employee.entrySet())
		{
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		
		//remove
		employee.remove(1);
		System.out.println(employee);
		
		employee.remove(2, "sumita");
		System.out.println(employee);
		
		employee.clear();
		System.out.println(employee);
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
