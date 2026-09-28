package basics;

class Employee
{
	int id; //declare ---> instance variable
	String name; //declare ----> instance variable
	static String companyName="ITVedant"; //initialize  ----> static variable
	
	Employee(int empId,String empName) //id,name ===> parameters
	{
		this.id = empId; //here id instance variable got initialize
		this.name = empName; //here name instance variable got initialize
	}	
}

public class _2_InstanceVariableStaticVariableAndConstructor 
{

	public static void main(String[] args) 
	{
		Employee employee1 = new Employee(10, "Raj");//10,"raj" ==> arguments
		Employee employee2 = new Employee(20, "Rani");
		
		System.out.println(employee1.id); //for employee1, id is 10
		System.out.println(employee2.id); //for employee2, id is 20
	}

}


//		function employee(id)
//		{
	
//		}


//     employee(10)  ----> function call

//  addition(10,30)













