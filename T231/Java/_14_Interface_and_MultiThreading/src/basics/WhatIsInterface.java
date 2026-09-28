package basics;

interface Vehicle
{
	void wheels(); //public abstract void wheels();
	//access modifier for above wheels method is : public
	
	void display() {} //---> you can not write a method with a body
}

class Car implements Vehicle
{
	void wheels() //------> wrong way of implementing interface method (reason: not using public)
	{
		System.out.println("car has 4 wheels");
	}
	
	public void wheels() //---> right way of implamenting interface method (how : using public)
	{
		System.out.println("car has 4 wheels");
	}
	
}

public class WhatIsInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
