package string_programs;

public class SumOfNumbersInString {

	public static void main(String[] args) 
	{
		String s = "ja4v7a3"; //14
		char[] charactersArray = s.toCharArray();
		int sum=0;
		
		for(char character : charactersArray)
		{
			if(Character.isDigit(character))
			{
				System.out.println(character);
				int num  = Character.getNumericValue(character);
				sum+=num;
			}
		}
		System.out.println(sum);
			

	}

}
