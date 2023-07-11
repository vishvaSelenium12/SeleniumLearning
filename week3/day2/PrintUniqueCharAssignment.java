package week3.day2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class PrintUniqueCharAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name="mouneesh";
		char[] ch =name.toCharArray();
		
		Set<Character> setName = new LinkedHashSet<Character>();
		for(Character eachChar: ch) {
			setName.add(eachChar);
			
		}
		
		System.out.println(setName);
		
	}

}
