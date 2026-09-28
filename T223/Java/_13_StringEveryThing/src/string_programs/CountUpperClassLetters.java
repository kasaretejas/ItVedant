package string_programs;

public class CountUpperClassLetters {

	public static void main(String[] args) {
		String inputString="MaHArasHtRa";
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int count = 0;
		for(char character:inputString.toCharArray())
		{
			if(upperCase.indexOf(character)!=-1)
			{
				count++;
			}
		}
		System.out.println(count);
		
		
		int countAgain=0;
		for(char character:inputString.toCharArray())
		{
			if(Character.isUpperCase(character))
			{
				countAgain++;
			}
		}
		System.out.println(countAgain);
		
	}

}
