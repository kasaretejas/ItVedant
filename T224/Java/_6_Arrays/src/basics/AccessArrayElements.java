package basics;

public class AccessArrayElements {

	public static void main(String[] args) 
	{
		int marks[] = {79, 95, 43, 68};
		//              0   1   2   3
		
		//1- accessing using index
		System.out.println(marks[0]); //79
		//System.out.println(marks[4]); //ERROR
		
		//2- accessing using simple for loop
		System.out.println(marks.length); //4, index=0,1,2,3
		for(int i=0; i<marks.length; i++)
		{
			System.out.println(i + ":" +marks[i]);
		}
		
		
		//3- accessing using enhanced for loop
		for(int mark:marks)
		{
			System.out.println(mark);
		}
		
		

	}

}
