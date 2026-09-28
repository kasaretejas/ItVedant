package package_2;

import package_1.Parent;

public class Child extends Parent{

	public static void main(String[] args) 
	{
		Child child = new Child();
		System.out.println(child.iamPublic);
		System.out.println(child.iamProtected);
		
		//System.out.println(child.iamDefault);
		//System.out.println(child.iamPrivate);

	}

}
