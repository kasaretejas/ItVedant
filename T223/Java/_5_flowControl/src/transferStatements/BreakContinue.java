package transferStatements;

public class BreakContinue {

	public static void main(String[] args) 
	{
		//display even numbers between 1 to 10 : using continue
		for(int i=1; i<=10; i++)
		{
			if(i%2==0)
			{
				System.out.println(i);
			}
			else
			{
				continue;
			}
		}
		
		//in given string, if you got n do not processed
		String subject = "spring boot"; 
		//string is zero based index
		for(int i=0; i<subject.length(); i++)
		{
			if(subject.charAt(i) == 'n')
			{
				break;
			}
			else
			{
				System.out.println(subject.charAt(i));
			}
		}
		
		

	}

}
