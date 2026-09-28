package basics;
interface Payment
{
	void pay();
	static boolean checkMoney(int money)
	{
		if(money>0) return true;
		return false;
	}
}

class UPI implements Payment
{
	@Override
	public void pay() 
	{
		System.out.println("Payment done using UPI");
	}
	
}

class CreditCard implements Payment
{
	@Override
	public void pay() 
	{
		System.out.println("Payment done using Credit card");
	}
	
}

public class _4_WhyWeNeedStaticMethods 
{

	public static void main(String[] args) 
	{
		UPI upi = new UPI();
		upi.pay();
		
		if(Payment.checkMoney(20)) upi.pay();
		else System.out.println("money must > 0");
		
		
		CreditCard creditCard = new CreditCard();
		if(Payment.checkMoney(0)) creditCard.pay();
		else System.out.println("money must > 0");
			

	}

}
