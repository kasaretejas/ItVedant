package string_programs;

public class CountVowels {

	public static void main(String[] args) 
	{
		String s = "aezioupairou";
		char[]  characters = s.toCharArray();
		int count=0;
		for(char character : characters)
		{
			if("aeiou".contains(Character.toString(character)))
			{
				count++;
			}
		}
		System.out.println(count);

	}

}
