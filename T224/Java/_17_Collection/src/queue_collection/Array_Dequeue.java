package queue_collection;

import java.util.ArrayDeque;

public class Array_Dequeue {

	public static void main(String[] args) 
	{
		ArrayDeque<Integer> adq = new ArrayDeque<>();
		//adding from both ends
		adq.offer(30);
		adq.offer(10);
		System.out.println(adq);
		
		adq.offerLast(40);
		System.out.println(adq);
		
		adq.offerFirst(20);
		System.out.println(adq);
		
		
		//accessing from both ends
		System.out.println(adq.peek());
		System.out.println(adq.peekFirst());
		System.out.println(adq.peekLast());
		
		//removing from both ends
		adq.poll();
		System.out.println(adq);
		
		adq.pollFirst();
		System.out.println(adq);
		
		adq.pollLast();
		System.out.println(adq);
		
		//all other methods are same as PQ

	}

}
