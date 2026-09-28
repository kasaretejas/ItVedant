package queue_collection;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Priority_Queue {

	public static void main(String[] args) 
	{
		PriorityQueue<Integer> pqSmaller = new PriorityQueue<>();
		pqSmaller.offer(90);
		pqSmaller.offer(70);
		pqSmaller.offer(10);
		pqSmaller.offer(60);
		//pqSmaller.offer(null);
		System.out.println(pqSmaller);
		
		PriorityQueue<Integer> pqLarger = new PriorityQueue<>(Collections.reverseOrder());
		pqLarger.offer(90);
		pqLarger.offer(70);
		pqLarger.offer(10);
		pqLarger.offer(60);
		System.out.println(pqLarger);
		
		PriorityQueue<String> pqSmallerString = new PriorityQueue<>();
		pqSmallerString.offer("zebra");
		pqSmallerString.offer("banana");
		pqSmallerString.offer("apple"); //ASCII value comparision
		System.out.println(pqSmallerString);
		
		//add
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(10); //throws exception if failed to insert if capacity is full
		pq.offer(6); //returns false if failed to insert if capacity is full
		pq.addAll(pqSmaller);
		System.out.println(pq);
		
		//access
		System.out.println(pq.peek()); //null if queue is empty
		System.out.println(pq.element()); //exception if queue is empty
		
		//search
		System.out.println(pq.contains(6));
		System.out.println(pq.size());
		System.out.println(pq.isEmpty());
		
		//looping
		Iterator<Integer> itr=pq.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		for(int value:pq)
		{
			System.out.println(value);
		}
		
		pq.forEach((n)->System.out.println(n));
		
		//remove
		System.out.println(pq);
		pq.poll(); //returns null if queue is empty
		System.out.println(pq);
		
		pq.remove();
		System.out.println(pq);
		
		pq.remove(Integer.valueOf(90));
		System.out.println(pq);
		
		pq.clear();
		System.out.println(pq);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
