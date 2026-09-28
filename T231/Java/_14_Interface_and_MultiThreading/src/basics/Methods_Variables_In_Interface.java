package basics;
interface Database
{
	int age = 20; // ----> public static final int age = 20;
	void connection();
	default void databaseOperations() { System.out.println("Database default method"); }
	static void dataOperations() { System.out.println("Database static method"); }
}

class Mysql implements Database
{
	@Override
	public void connection() 
	{
		System.out.println("conneted to mysql database");
	}	
}

public class Methods_Variables_In_Interface {

	public static void main(String[] args) 
	{
		Mysql mysql = new Mysql();
		mysql.connection();
		mysql.databaseOperations();
		Database.dataOperations();
		System.out.println(mysql.age); //prrof that age is static variable
		mysql.age=30;  //proof that age is final variable

	}

}
