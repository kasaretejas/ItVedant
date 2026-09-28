package basics;
class Student
{
	private int rollNo2;
	private double marks;
	
	public int getRollNo() 
	{
		return rollNo2;
	}
	public void setRollNo(int rollNo) 
	{
		this.rollNo2 = rollNo;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) 
	{
		if(marks<0)
		{
			System.out.println("marks must be greater than zero");
		}
		else
		{
			this.marks = marks;
		}
	}
	
	//Student(int rollNo, double marks){}
	
	
}



public class Encapuslation {

	public static void main(String[] args) {
		Student student = new Student();
		//System.out.println(student.rollNo);
		
		student.setRollNo(20);
		System.out.println(student.getRollNo());
		
		System.out.println(student.getMarks());
		
		student.setMarks(-92);
		System.out.println(student.getMarks());
		
		student.setMarks(92);
		System.out.println(student.getMarks());

	}

}
