package string_programs;

public class ReverseString {

	public static void main(String[] args) {
		String inputString="java"; //3210
		String reverse="";
		
		for(int i=inputString.length()-1; i>=0; i--)
		{
			//System.out.println(inputString.charAt(i));
			reverse+=inputString.charAt(i);
		}
		
		System.out.println(inputString);
		System.out.println(reverse);
	}

}
