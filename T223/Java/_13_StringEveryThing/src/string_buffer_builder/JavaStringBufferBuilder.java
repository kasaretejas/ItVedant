package string_buffer_builder;

public class JavaStringBufferBuilder {

	public static void main(String[] args) 
	{
		//StringBuffer sb = new StringBuffer("java");
		StringBuilder sb = new StringBuilder("java");
		System.out.println(sb);
		
		sb.append("pythony"); //at the end
		System.out.println(sb);
		
		sb.insert(0, "y"); //particular index
		System.out.println(sb);
		
		sb.deleteCharAt(0);
		System.out.println(sb);
		
		sb.delete(0, 2);
		System.out.println(sb);
		
		sb.replace(0, 1, "-");
		System.out.println(sb);
		
		System.out.println(sb.indexOf("y"));
		System.out.println(sb.lastIndexOf("y"));
		System.out.println(sb.charAt(0));
		
		
		
	}

}
