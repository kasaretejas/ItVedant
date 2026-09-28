package encapsulation;

public class OperationOnEmployee {

	public static void main(String[] args) 
	{
		Employee employee1 = new Employee();
		//employee1.id=10;  //ERROR - accessing private variable
		employee1.setId(10);
		System.out.println(employee1.getId());
		
		Employee employee2 = new Employee();
		System.out.println(employee2.getId()); //here you will get id as 0, bcoz default value of int is 0
		employee2.setId(20);
		System.out.println(employee2.getId()); 

	}

}
