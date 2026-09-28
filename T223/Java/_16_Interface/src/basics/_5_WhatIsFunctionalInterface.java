package basics;
@FunctionalInterface
interface Pen
{
	void writting();
	//void khelna();
	default void test() {}
	static void demo() {}
}

class NoteBook implements Pen
{
	@Override
	public void writting()
	{
		System.out.println("writting notes");
	}
}

public class _5_WhatIsFunctionalInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
