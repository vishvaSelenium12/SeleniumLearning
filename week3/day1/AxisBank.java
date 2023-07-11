package week3.day1;

public class AxisBank extends Axis{

	@Override
	public void withdrawalLimit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void axisCibliScore() {
		// TODO Auto-generated method stub
		
	}
	
	public void axisBankDepitLimit() {
		System.out.println("Axis ban debit limit from Axis bank class");
	}
	
	public static void main(String[] args) {
		
		AxisBank ab = new AxisBank();
		ab.axisBankDepitLimit();
		ab.axisCibliScore();
		ab.withdrawalLimit();
		ab.knowYourCustomer();
		
	}

}
