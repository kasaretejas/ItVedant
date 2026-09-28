package _1_basics;

class Employeee
{
	String name;  //declaration of instance variable name
	String phone; //declaration of instance variable phone
	static String companyName="Tata";
	
	Employeee(String name, String phone) //name=raj, phone=989876789 ---> Constructor
	{
		this.name=name; //name=raj ----------> initialization of instance variable name
		this.phone=phone; //phone=989876789--> initialization of instance variable phone
		System.out.println("costructor called....."); //---> to prove that constructor get called automatically
	}
}



public class _3_Constructor {

	public static void main(String[] args) 
	{
		Employeee e1 = new Employeee("raj","989876789");//raj=name , 989876789=phone
		System.out.println(e1.name);

		Employeee e2 = new Employeee("amit", "9845456789");
		System.out.println(e2.name);
		
		//below understance instance variable clearly
		System.out.println(e1.phone);
		System.out.println(e2.phone);
		//above, variables are same but their values are different ---> instance variable
		
		System.out.println(e1.companyName);
		System.out.println(e2.companyName);
		//above, variables are same and their values are also same ---> static variable
	}

}

















