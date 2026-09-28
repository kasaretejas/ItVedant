package java_string;

public class StringBufferStringBuilder {

	public static void main(String[] args) 
	{
		//StringBuffer  sb = new StringBuffer("hello");
		StringBuilder  sb = new StringBuilder("hello");
		
		System.out.println(sb); //hello
		sb.append("bye");
		System.out.println(sb); //hellobye
		
		sb.insert(1, "-");
		System.out.println(sb);
		
		sb.replace(0, 2, "H");
		System.out.println(sb);
		
		sb.delete(0, 4);
		System.out.println(sb);
		
		sb.deleteCharAt(0);
		System.out.println(sb);
		
		sb.setCharAt(0, 'H');
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		
		System.out.println(sb.charAt(0));
		System.out.println(sb.indexOf("e"));
		System.out.println(sb.lastIndexOf("e"));
		System.out.println(sb.length());
		
		System.out.println(sb.substring(0, 2));
		
		String s = sb.toString();
		System.out.println(s);
		

	}

}
