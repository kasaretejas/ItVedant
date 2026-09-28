package basics;

class Update1 extends Thread
{
	//StringBuffer buffer;
	StringBuilder builder;
	public Update1(StringBuilder builder) {this.builder = builder;}
	String[] names = {
		    "Aarav",
		    "Aditi",
		    "Aditya",
		    "Akash",
		    "Amit",
		    "Ananya",
		    "Anil",
		    "Anjali",
		    "Arjun",
		    "Arnav",
		    "Aryan",
		    "Ashish",
		    "Bhavna",
		    "Chetan",
		    "Deepak",
		    "Deepika",
		    "Dev",
		    "Divya",
		    "Gaurav",
		    "Harish",
		    "Isha",
		    "Jatin",
		    "Kajal",
		    "Karan",
		    "Kavita",
		    "Kiran",
		    "Krishna",
		    "Manish",
		    "Meena",
		    "Mihir",
		    "Neha",
		    "Nikhil",
		    "Nisha",
		    "Pankaj",
		    "Pooja",
		    "Prakash",
		    "Priya",
		    "Rahul",
		    "Raj",
		    "Rakesh",
		    "Ravi",
		    "Riya",
		    "Rohan",
		    "Sachin",
		    "Sahil",
		    "Sanjay",
		    "Shivam",
		    "Shraddha",
		    "Sneha",
		    "Sonali",
		    "Suresh",
		    "Tanvi",
		    "Varun",
		    "Vijay",
		    "Vikas",
		    "Vishal",
		    "Yash"
		};
	
	@Override
	public void run() 
	{
		for(String name:names )
		{
			builder.append(name);
		}
	}
	
}

class Update2 extends Thread
{
	//StringBuffer buffer;
	StringBuilder builder;
	public Update2(StringBuilder builder) {this.builder = builder;}
	int[] numbers = {
		    1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
		    11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
		    21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
		    31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
		    41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
		    51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
		    61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
		    71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
		    81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
		    91, 92, 93, 94, 95, 96, 97, 98, 99, 100
		};
	@Override
	public void run() 
	{
		for(int number:numbers )
		{
			builder.append(number);
		}
	}
	
}
public class SB_Proof
{

	public static void main(String[] args) throws InterruptedException 
	{
		//StringBuffer buffer=new StringBuffer("");
		StringBuilder builder=new StringBuilder("");
		Update1 update1 = new Update1(builder);
		Update2 update2 = new Update2(builder);
		
		
		update2.start();
		update1.start();
		
		update1.join();
		update2.join();
		
		
		System.out.println(builder);

	}

}
