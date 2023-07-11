package week3.day1;

public class HDFC implements RBI{

	int depositAmount =25000;
	@Override
	public void withdrawalLimit() {
		// TODO Auto-generated method stub
		System.out.println("40L withdrawal from HDFC");
		
	}

	@Override
	public void knowYourCustomer() {
		// TODO Auto-generated method stub
		System.out.println("KYC aadhar friom HDFC");
	}
	
	public void primeCustomer() {
		System.out.println("Prime customer from HDFC");
	}
	
	public static void main(String[] args) {
		
		HDFC hd = new HDFC();
		hd.withdrawalLimit();
		hd.knowYourCustomer();
		hd.primeCustomer();
		System.out.println(hd.depositAmount);
	}

}
