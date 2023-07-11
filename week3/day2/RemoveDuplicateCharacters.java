package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name= "PayPal India";
		char[] ch =name.toCharArray();
		
		Set<Character> setCh = new LinkedHashSet<Character>();
		Set<Character> dupSetCh = new LinkedHashSet<Character>();
		for(Character eachChar :ch) {
			boolean dup =setCh.add(eachChar);
			if(!dup) {
				dupSetCh.add(eachChar);
			}
		}
		
		System.out.println("Only unique character:" + setCh);
		
		System.out.println("Duplicate Character:" +dupSetCh);
	}

}
