package functional_interface;

@FunctionalInterface
interface Pen
{
	void writting();
	//void playing();
	default void x() {}
	default void y() {}
	static  void z() {}
}

class Notebook implements Pen
{
	@Override
	public void writting() 
	{
		System.out.println("writing on notebook using pen");	
	}
}

public class JavaFunctionalInterface 
{

	public static void main(String[] args) 
	{
		//1. traditional way of accessing abstract method of interface
		Notebook notebook =new Notebook();
		notebook.writting();
		
		//2. anonymous way of accessing abstract method of interface
		Pen paper = new Pen() 
		{
			@Override
			public void writting() 
			{
				System.out.println("writting on paper using pen");	
			}
		};
		
		paper.writting();
		
		//1. accessing abstract method of functional interface using lambda expression
		Pen book = () ->
			{
				System.out.println("writting on book using pen");	
			};
		book.writting();
		book.x();
			
		
	}

}
