package queue_framework;

import java.util.Collections;
import java.util.PriorityQueue;

public class Priority_Queue {

	public static void main(String[] args) 
	{
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(99); //not recomonded for queue
		priorityQueue.offer(55);
		priorityQueue.offer(11);
		priorityQueue.offer(66);
		priorityQueue.offer(55);
		System.out.println(priorityQueue);
		
		System.out.println(priorityQueue.peek());
		
		priorityQueue.poll();
		System.out.println(priorityQueue);
		System.out.println(priorityQueue.peek());
		
		System.out.println(priorityQueue.size());
		
		priorityQueue.remove();
		System.out.println(priorityQueue);
		System.out.println(priorityQueue.peek());
		
		
		PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());
		priorityQueue2.add(99); //not recomonded for queue
		priorityQueue2.offer(55);
		priorityQueue2.offer(11);
		priorityQueue2.offer(66);
		priorityQueue2.offer(55);
		System.out.println(priorityQueue2);

	}

}
