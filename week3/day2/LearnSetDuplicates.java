package week3.day2;

import java.util.Set;
import java.util.TreeSet;

public class LearnSetDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {4,3,4,5,3,4,9,7,9};
		//output 3,4,7
		
		Set<Integer> uniques = new TreeSet<Integer>();
		Set<Integer> duplicates = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
		boolean add = uniques.add(nums[i]);
		if(!add) {
			duplicates.add(nums[i]);
		}
		}
		System.out.println(uniques);
		System.out.println(duplicates);
	}

}
