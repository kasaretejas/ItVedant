package basics;

interface Demo
{
	void test();
	//public abstract void test();
	int age=10;
	//public static final
}

class Display implements Demo
{
	int weight=100;
	@Override
	public void test() 
	{
		System.out.println("calling test from Display");	
	}	
}


public class _1_WhatIsInterface {

	public static void main(String[] args) 
	{
		Display display = new Display();
		display.test();
		System.out.println(display.weight);
		System.out.println(display.age);
		System.out.println(Display.age);
		
		display.weight=200;
		System.out.println(display.weight);
		//Display.age=20; //The final field Demo.age cannot be assigned

	}

}
