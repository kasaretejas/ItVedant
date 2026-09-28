package string_programs;

public class SumOfDigitsInString {

	public static void main(String[] args) 
	{
		String s = "Ja4v5a1"; //4+5+1=10
		char charArray[] = s.toCharArray();
		int sum=0;
		for(char myChar: charArray)
		{
			System.out.println(myChar +":" + Character.isDigit(myChar));
			if(Character.isDigit(myChar))
			{
				sum+=Character.getNumericValue(myChar);
			}
		}
		System.out.println(sum);
	}

}
