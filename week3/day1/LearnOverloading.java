package week3.day1;

public class LearnOverloading {

	
	public void add() {
		
		int a=10;
		int b=20;
		System.out.println(a+b);
	}
	
	public void add(int a , int b) {
		System.out.println(a+b);
	}
	
	public void add(int a, float b, int c) {
		System.out.println(a+b+c);
	}
	
	public static void main(String[] args) {
		LearnOverloading lo = new LearnOverloading();
		lo.add();
		lo.add(200, 300);
		lo.add(10, 39.66f, 100);
	}
}
