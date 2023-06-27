package week1.day2;

public class Calculator {
	
	public int addTwoNumbers(int a, int b, int c ) {
	
		int sum=a+b+c;
		
		return sum ;
	}
	
	public float subTwoNumbers(int d, float e) {
		
		float sub=d-e;
		return sub;
	}
	
	public int divTwoNumbers(int f, int g) {

		int div =f/g;
		return div;
		
	}

	public static void main(String[] args) {
		
		Calculator obj = new Calculator();
		int additionOfNum =obj.addTwoNumbers(10, 100, 1000);
		System.out.println("Sum of Two Number is:" +additionOfNum);
		float subtractionAns =obj.subTwoNumbers(100, 10.55f);
		System.out.println("Subtraction of Two number is:" +subtractionAns);
		int divAns=obj.divTwoNumbers(20, 2);
		System.out.println("Divsion of two number is:" + divAns);
	}
	
	
}
