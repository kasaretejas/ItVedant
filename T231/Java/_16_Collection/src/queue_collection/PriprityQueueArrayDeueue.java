package queue_collection;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriprityQueueArrayDeueue {

	public static void main(String[] args) 
	{
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(45);
		priorityQueue.offer(29);
		priorityQueue.offer(16);
		priorityQueue.offer(9);
		priorityQueue.offer(87);
		priorityQueue.offer(-125);
		priorityQueue.offer(36);
		System.out.println(priorityQueue);
		
		PriorityQueue<Integer> priorityQueueReverse = new PriorityQueue<>(Comparator.reverseOrder());
		priorityQueueReverse.add(45);
		priorityQueueReverse.offer(29);
		priorityQueueReverse.offer(16);
		priorityQueueReverse.offer(9);
		priorityQueueReverse.offer(87);
		priorityQueueReverse.offer(-125);
		priorityQueueReverse.offer(36);
		System.out.println(priorityQueueReverse);
		
		ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
		arrayDeque.offer(12);
		arrayDeque.offer(34);
		arrayDeque.offer(10);
		arrayDeque.offerFirst(98);
		arrayDeque.offerFirst(879);
		arrayDeque.offerLast(8);
		System.out.println(arrayDeque);

	}

}
