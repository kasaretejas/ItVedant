package polymorphism;
class Database
{
	String connect (String dbname, String username, String passowrd) 
	{
		return "connected with database " + dbname;
	}
	
	String connect (String dbname) 
	{
		return "connected with database " + dbname;
	}
}
public class OverLoaing 
{

	public static void main(String[] args) 
	{
		Database database = new Database();
		System.out.println(database.connect("mySQLDB"));
		
		System.out.println(database.connect("myMongoDB", "tejas", "1234"));
		
		//System.out.println(database.connect("myMongoDB", "tejas"));
			
		
	}

}
