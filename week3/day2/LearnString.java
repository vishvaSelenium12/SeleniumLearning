package week3.day2;

public class LearnString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name="vishva";
		String name1="vishva";
		
		String str = new String("Vishva");
		System.out.println(name.length());
		
		//compare reference id
		if(name==name1) {
			System.out.println("Both are equal  == Operator");
		}
		else {
			System.out.println("Both are not equal == Operator");
		}
		
		//compare two content of string
		if(name.equals(str)) {
			System.out.println("Both are equal - equal method'");
		}
		else {
			System.out.println("Both are not equal - equals method");
		}
		
		//ignore case sensitivity between two string values
		if(name.equalsIgnoreCase(str)) {
			System.out.println("Both are equal - equal method'");
		}
		else {
			System.out.println("Both are not equal - equals method");
		}
	}

}
