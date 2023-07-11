package week3.day2;

public class StringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name ="radar";
		String nameReverse ="";
		
		char[] ch =name.toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			//System.out.print(ch[i]);
			String nameReverseEachValue  =String.valueOf(ch[i]);
			nameReverse=nameReverse+nameReverseEachValue;
			
		}
		System.out.println("");
		System.out.println("After reversing:" + nameReverse);
		
		if(name.equalsIgnoreCase(nameReverse)) {
			System.out.println("The Given String is Palindrome :" + name);
		}
		else {
			System.out.println("The Given String is not a  Palindrome :" + nameReverse);
		}
	}

}
