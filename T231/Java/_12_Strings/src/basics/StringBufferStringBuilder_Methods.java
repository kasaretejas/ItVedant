package basics;

public class StringBufferStringBuilder_Methods 
{

	public static void main(String[] args) 
	{
		StringBuilder sb = new StringBuilder("java");
		System.out.println(sb);
		sb.append("hello");
		System.out.println(sb);
		
		System.out.println(sb.charAt(0));;
		
		sb.deleteCharAt(0);
		System.out.println(sb);
		
		sb.insert(0, "W");
		System.out.println(sb);
		
		sb.replace(0, 3, "-");
		System.out.println(sb);

	}

}
