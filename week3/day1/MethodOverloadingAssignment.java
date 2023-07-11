package week3.day1;

public class MethodOverloadingAssignment {

	
	public void add(int a, int b) {
		System.out.println(a+b);
	}
	
	public void add(int a, int b, int c)
	{
		System.out.println(a+b+c);
	}
	
	public void add(double a, double b) {
		System.out.println(a+b);
	}
	
	public void add(float a, float b) {
		System.out.println(a+b);
	}
	
	public static void main(String[] args) {
		MethodOverloadingAssignment ml = new MethodOverloadingAssignment();
		ml.add(10, 20);
		ml.add(50, 100, 200);
		ml.add(1500.8888, 1600.888);
		ml.add(18f, 19.666f);
	}
}
