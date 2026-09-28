package basics;

public class StringBufferStringBuilder {

	public static void main(String[] args)
	{
		//immutable (String)   VS mutable (StringBuffer/StringBuilder)
		
		String name = new String("raj");
		name.concat("kumar"); //------> this will create new String
		String fullName=name.concat("kumar"); //------> this will create new String
		
		System.out.println(name); ///----> raj
		System.out.println(fullName); //rajkumar
		
		//StringBuilder sb = new StringBuilder("dilip");
		StringBuffer sb = new StringBuffer("dilip");
		System.out.println(sb);
		sb.append("kumar"); //-----> this will not create new String, instead it will update existing object that sb
		System.out.println(sb);

		
		//String buffer VS Builder
		//StringBuilder : supports multi-threading ----> this is not thread safe (Asynchronus)
		//------> local train
		//StringBuffer : supports multi-threading -----> this is thread safe (syncronously)
		//------>metro train
	}

}
