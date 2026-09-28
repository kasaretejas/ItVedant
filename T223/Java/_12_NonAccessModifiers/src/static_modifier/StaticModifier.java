package static_modifier;


class College 
{
	String collegeName = "IIT";
	class Department  // inner class (non-static class inside a class)
	{
		String deptName="Computer";
	}
	static class Teacher  // nested class (static class inside a class)
	{
		String teacherName = "Mr. Sharma"; 
	}
}

public class StaticModifier 
{
	//for static variable and statuic method, check _7_OOP Project
	public static void main(String[] args) 
	{
		College college = new College();
		System.out.println(college.collegeName);
		
		//Department department = new Department(); ---> Cant create Department class's object
		College.Department department = college.new Department();
		System.out.println(department.deptName);
		
		College.Teacher teacher = new College.Teacher();
		System.out.println(teacher.teacherName);
	
	}

}
