package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargestValueFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {3,2,11,4,6,7,2,3,3,6,7};
		//       output= 7;
		
		Set<Integer> num = new TreeSet<Integer>();
		for (Integer eachInteger : data) {
			num.add(eachInteger);
		}
		System.out.println(num.size());
		System.out.println("Values from Set: " + num);
		
		List<Integer> li = new ArrayList<Integer>(num);
		System.out.println(li.size());
		System.out.println("Second Largest Value:" + li.get(li.size()-2));
	}

}
