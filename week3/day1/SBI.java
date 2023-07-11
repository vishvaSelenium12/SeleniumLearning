package week3.day1;

public class SBI implements RBI {

	@Override
	public void withdrawalLimit() {
		// TODO Auto-generated method stub
		System.out.println("withdrawal from SBI");
	}

	@Override
	public void knowYourCustomer() {
		// TODO Auto-generated method stub
		System.out.println("KYC from SBI");
		
	}
	
	public void carLoan() {
		System.out.println("Car loan amount 10L from SBI");
	}

	
	public static void main(String[] args) {
		
		SBI sb = new SBI();
		sb.carLoan();
		sb.knowYourCustomer();
		sb.withdrawalLimit();
		System.out.println(sb.depositAmount);
	}
}
