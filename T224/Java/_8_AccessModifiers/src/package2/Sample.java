package package2;

import package1.Demo;

public class Sample extends Demo  //now everything that Demo has, now available to Sample
 { 
	//Sample IS-A child of Demo
	//Demo IS-A Parent of Sample
	

	public static void main(String[] args) 
	{
		Sample sample = new Sample();
		System.out.println(sample.iamPublic);
		System.out.println(sample.iamProtected);
		//System.out.println(sample.iamDefault);
		//System.out.println(sample.iamPrivate);

	}

}
