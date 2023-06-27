package week1.day2;

public class LearnPrimeNumberAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int input =13;
		boolean isPrime =false;
		
		for(int i=1;i<=input;i++) {
			
			if(i%2==0) {
				isPrime=true;
			}
		}
		
		if(isPrime) {
			System.out.println(input+" is a prime number");
		}
		else {
			System.out.println(input +" is not a prime number");
		}

	}

}
