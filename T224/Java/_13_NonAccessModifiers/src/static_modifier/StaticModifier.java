package static_modifier;

class College //outer class
{
	class Department {} //inner class	
	static class Teacher {} //nested class
}
public class StaticModifier {

	public static void main(String[] args) 
	{
		College college = new College();
		//Department department = new Department();
		College.Department department = college.new Department();
		
		//Teacher teacher = new Teacher();
		College.Teacher teacher = new College.Teacher();

	}

}
