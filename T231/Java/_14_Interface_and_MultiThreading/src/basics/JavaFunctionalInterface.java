package basics;

@FunctionalInterface
interface Demo
{
	void show();
	void display(); //comment this and error will go
	default void print() {}
	static void view() {}
}


public class JavaFunctionalInterface extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
