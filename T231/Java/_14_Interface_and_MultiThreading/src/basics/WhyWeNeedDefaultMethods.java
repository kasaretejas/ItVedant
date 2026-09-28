package basics;
interface ATM
{
	void withdraw();
	//void deposite();
	default void deposite() {}
}

class HDFCBankATM implements ATM
{
	@Override
	public void withdraw() 
	{
		System.out.println("withdraw from HDFCBank ATM");
	}

	@Override
	public void deposite() 
	{
		System.out.println("HDFCBank ATM deposite allowed");
		
	}
	
}

class SBIBankATM implements ATM
{
	@Override
	public void withdraw() {}
}

public class WhyWeNeedDefaultMethods {

	public static void main(String[] args) 
	{
		HDFCBankATM hdfcBankATM = new HDFCBankATM();
		hdfcBankATM.withdraw();
		hdfcBankATM.deposite();
		

	}

}
