package basics;

interface Bottle
{
	void storeWater();
	void storeMilk();
}

class Kitchen implements Bottle
{
	@Override
	public void storeWater()
	{
		System.out.println("storing water in bottle in the kitchen");
	}
	
	@Override
	public void storeMilk()
	{
		System.out.println("storing milk in bottle in the kitchen");
	}
}


public class _6_AnonymousClass {

	public static void main(String[] args) 
	{
		Kitchen kitchen = new Kitchen();
		kitchen.storeWater();
		kitchen.storeMilk();
		
		Bottle anonymousClass = new Bottle() 
		{
			
			@Override
			public void storeWater() {
				System.out.println("storing water in bottle in the anonymous");
				
			}
			
			@Override
			public void storeMilk() {
				System.out.println("storing milk in bottle in the anonymous");
				
			}
		};
		anonymousClass.storeWater();
		anonymousClass.storeMilk();
		
		

	}

}
