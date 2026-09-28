package queue_collection;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueMethods 
{
	public static void main(String[] args) 
	{
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		priorityQueue.offer(12);
		priorityQueue.offer(76);
		priorityQueue.offer(7);
		priorityQueue.offer(17);
		priorityQueue.offer(9);
		
		System.out.println(priorityQueue);
		System.out.println(priorityQueue.peek());
		System.out.println(priorityQueue.remove(17));
		System.out.println(priorityQueue);
		System.out.println(priorityQueue.peek());
		priorityQueue.poll();
		
		System.out.println(priorityQueue);
		
		
		ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
		arrayDeque.offer(12);
		arrayDeque.offer(19);
		arrayDeque.offer(65);
		System.out.println(arrayDeque);
		arrayDeque.offerFirst(34);
		System.out.println(arrayDeque);
		arrayDeque.offerLast(20);
		System.out.println(arrayDeque);
		
		System.out.println(arrayDeque.peek());
		System.out.println(arrayDeque.peekFirst());
		System.out.println(arrayDeque.peekLast());
		
		System.out.println(arrayDeque);
		arrayDeque.poll();
		System.out.println(arrayDeque);
		arrayDeque.pollFirst();
		System.out.println(arrayDeque);
		arrayDeque.pollLast();
		System.out.println(arrayDeque);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
