package _1_basics;

class Employee
{
	//name, phone are instance variables because their value is chnaging from Employee to Employee
	//companyName is static variable because its value will be same for all Employees
	//dressCode is final variable because we cant change its value
	String name; //declaration
	String phone; //declaration
	static String companyName="Google"; //declaration + initialization
	final String dressCode = "pink shirt, blue pant"; //this value is FIXED
	
	void task()
	{
		int result = 10+2; //result is local variable
		System.out.println("the result is "+result);
	}
	
}




public class _2_TypesOfVariable {
	
	public static void main(String[] args) 
	{
		Employee e1 = new Employee(); //e1 is reference variable
		System.out.println(e1.name); //null 
		System.out.println(e1.phone); //null 
		
		System.out.println(e1.companyName); //Google 
		System.out.println(Employee.companyName); //Google 
		
		e1.companyName = "Tata"; //value of static variable can be changed
		System.out.println(e1.companyName); //Tata 
		System.out.println(Employee.companyName); //Tata
		
		System.out.println(e1.dressCode);
		//e1.dressCode="green pant, yellow shirt"; //final variables can not be changed
		
		//System.out.println(e1.result);//result cannot be resolved or is not a field

	}

}
