package queue_framework;

import java.util.ArrayDeque;

public class Array_Dqueue {

	public static void main(String[] args) 
	{
		ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
		arrayDeque.offer(10);
		arrayDeque.offer(20);
		arrayDeque.offerFirst(100);
		arrayDeque.offerFirst(200);
		arrayDeque.offerLast(11);
		arrayDeque.offerLast(22);
		System.out.println(arrayDeque);
		
		
		System.out.println(arrayDeque.peekFirst());
		System.out.println(arrayDeque.peekLast());
		
		arrayDeque.pollFirst();
		System.out.println(arrayDeque);
		System.out.println(arrayDeque.peekFirst());
		
		arrayDeque.pollLast();
		System.out.println(arrayDeque);
		System.out.println(arrayDeque.peekLast());

	}

}
