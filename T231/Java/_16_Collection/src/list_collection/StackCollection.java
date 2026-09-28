package list_collection;

import java.util.Stack;

public class StackCollection {

	public static void main(String[] args) 
	{
		Stack<Integer> stack = new Stack<>();
		stack.add(71); //from Collection
		stack.push(13); //from statck and only for stack
		stack.push(47);
		stack.push(98);
		System.out.println(stack);
		
		//stack.get();
		System.out.println(stack.peek()); //gives top of stack
		
		//stack.remove(1); ----> not rec.
		//System.out.println(stack);
		
		stack.pop(); //removes top of stack
		System.out.println(stack);
		System.out.println(stack.peek()); 
		
		

	}

}
