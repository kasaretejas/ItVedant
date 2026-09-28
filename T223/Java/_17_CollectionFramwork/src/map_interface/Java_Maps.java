package map_interface;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Java_Maps {

	public static void main(String[] args) 
	{
		HashMap<Integer, String> students = new HashMap<>();
		
		students.put(10, "ajay");
		students.put(15, "rani");
		System.out.println(students);
		students.put(10, "pratik");
		System.out.println(students);
		students.putIfAbsent(18, "sumit");
		System.out.println(students);
		students.putIfAbsent(10, "raj");
		System.out.println(students);
		
		System.out.println(students.get(10));
		
		students.remove(10);
		System.out.println(students);
		
		students.remove(15, "amit");
		System.out.println(students);
		
		System.out.println(students.keySet());
		
		//string as a key
		HashMap<String, Integer> countryPopulation = new HashMap<>();
		countryPopulation.put("india", 5);
		countryPopulation.put("china", 2);
		System.out.println(countryPopulation);
		
		
		//linked hash map : insertion order preserved!
		LinkedHashMap<Integer, String> employee = new LinkedHashMap<>();
		employee.put(101, "raj");
		employee.put(99, "amit");
		employee.put(201, "sumit");
		employee.put(305, "raj");
		System.out.println(employee);
		
		//treemap : sort according to keys
		TreeMap<String, Integer> furniture = new TreeMap<>();
		furniture.put("bench", 10);
		furniture.put("table", 5);
		furniture.put("chair", 3);
		furniture.put("bed", 1);
		System.out.println(furniture);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
