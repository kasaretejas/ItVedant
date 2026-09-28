package _19_Stream;

import java.util.Arrays;
import java.util.List;
class Teacher
{
	Teacher() {}
	Teacher(int a) {}
}

class Student
{
	//Teacher() {}
	Student() {}
}

class College extends Teacher
{
	//Teacher() {}
}
public class _1_EvenNumberStream {

	public static void main(String[] args) 
	{
		List<Integer> numbers=Arrays.asList(2,5,4,8,3,7,4);
		for(int n:numbers)
		{
			if(n%2==0)
			{
				System.out.println(n);
			}
		}
		
		numbers.stream().filter(n -> n%2==0).forEach(n -> System.out.println(n));
		
		List<Integer> evenNumbers=numbers.stream().filter(n -> n%2==0).toList();
		
		System.out.println(evenNumbers);

	}

}
