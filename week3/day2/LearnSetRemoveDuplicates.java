package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class LearnSetRemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums= {1,2,4,3,6,5,7,9,10,11,33,44,12,1,2};
		//output 1,2,3,4,5,6,7,9,10,11,12,33,44
		
		Set<Integer> unique = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			unique.add(nums[i]);
		}

		System.out.println(unique);
	}

}
