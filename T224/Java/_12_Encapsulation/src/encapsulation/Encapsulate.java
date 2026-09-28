package encapsulation;
class Employee
{
	private long id;
	private String name;
	private int age;
	
	
	public Employee(long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) 
	{
		if(age>18) this.age = age;
		
	}
	
	
	
}
public class Encapsulate {

	public static void main(String[] args) 
	{
		Employee employee1 = new Employee(11220, "Raj", 21);
		System.out.println(employee1.getId());
		
		employee1.setId(11330);
		System.out.println(employee1.getId());
		
		employee1.setAge(15);
		System.out.println(employee1.getAge());

	}

}
