package week3.day2;

public class LearnStringMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="Amazon";

		//to find length of string
		System.out.println(name.length());

		//to check whether any part of value in string
		if(name.contains("ma")) {
			System.out.println("Present");
		}
		else {
			System.out.println("Not present");
		}

		//to convert string value to lower case
		String nameLower=name.toLowerCase();
		System.out.println(nameLower);

		//to convert string value to upper case
		String nameUpper=name.toUpperCase();
		System.out.println(nameUpper);


		//to retrieve particular character from given string using index
		char c=name.charAt(4);
		System.out.println("Character at 4th Index:" + c);

		// to convert string to character array
		char[] ch=name.toCharArray();
		System.out.println(ch);//A,m,a,z,o,n
		
		System.out.println("Print all values from char Array");
		for (int i = 0; i < ch.length; i++) {
			System.out.println(ch[i]);
		}
	}

}
