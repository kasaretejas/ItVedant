package basics;

public class _1WithoutTryCatch {

	public static void main(String[] args) 
	{
		//if we dont have exception handling(try-catch) then 
		//exception will be handled by JVM : abnormal termination
		
		System.out.println("start");
		
		int x=20;
		//int y=5;
		int y=0;
		System.out.println(x/y);
		
		System.out.println("end");

	}

}
