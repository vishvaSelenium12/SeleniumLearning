package week3.day2;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String name = "changeme";
		 char[] ch= name.toCharArray();
		 
		 for(int i=0;i<name.length();i++) {
			 if(i%2 !=0) {
			Character upperCase= Character.toUpperCase(ch[i]);
				 System.out.print(upperCase);
		 }
			 else {
				 System.out.print(ch[i]);
			 }
	}

}}
