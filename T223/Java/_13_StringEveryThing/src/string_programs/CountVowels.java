package string_programs;

public class CountVowels {

	public static void main(String[] args) 
	{
		String inputString = "kalsubai";
		String vowels = "aeiou";
		
		int count=0;
		
		char[] characters=inputString.toCharArray();
		for(char character:characters)
		{
			int index=vowels.indexOf(character);
			if(index!=-1)
			{
				count++;
			}
		}
		
		System.out.println(count);
		

	}

}
