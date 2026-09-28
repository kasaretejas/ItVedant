package list_framework;

import java.util.Stack;
import java.util.Vector;

public class Vector_Stack {

	public static void main(String[] args) 
	{
		Vector<Integer> vector = new Vector<>();
		vector.add(10);
		vector.add(20);
		vector.add(30);
		vector.add(0,100);
		System.out.println(vector);
		
		System.out.println(vector.size());
		
		vector.remove(0);
		System.out.println(vector);
		
		System.out.println(vector.contains(30));
		
		System.out.println(vector.get(0));
		
		
		Stack<Integer> stack = new Stack<>();
		stack.push(11);
		stack.push(22);
		stack.push(33);
		stack.push(44);
		stack.add(44);
		System.out.println(stack);
		System.out.println(stack.peek());
		
		stack.pop();
		System.out.println(stack);
		System.out.println(stack.peek());
		
		System.out.println(stack.search(11)); //33 is at 1st index (from Stack)
		
		System.out.println(stack.size());
		System.out.println(stack.get(1)); //get starts counting from zero (from List)

	}

}
