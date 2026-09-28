package basics;

class Doctor
{
	String name; //"dr. amit"         "dr. punit"
	int age;     //34                  45
	
	Doctor(String name, int age) //"dr. amit",34 ....... "dr. punit", 45
	{
		this.name=name; //this.name --> instance variable, name ---> parameter
		this.age=age; //this.age --> instance variable, age ---> parameter
	}
}


public class _2_InstanceVariableConstaructor {

	public static void main(String[] args) 
	{
		//initializing instance variables using Reference Variable
		//Doctor doctor1 = new Doctor();
		//doctor1.name="dr. rani"; //this is not recommonded as there may be hundreds of instance variables

		//initializing instance variables using constructor
		Doctor doctor2 = new Doctor("dr. amit", 34);
		
		Doctor doctor3 = new Doctor("dr. punit", 45);
		
		System.out.println(doctor2.name);
		System.out.println(doctor3.name);
	}

}











