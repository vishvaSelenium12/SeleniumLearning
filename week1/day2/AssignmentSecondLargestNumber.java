package week1.day2;

import java.util.Arrays;

public class AssignmentSecondLargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data = {3,2,11,4,6,7};
		Arrays.sort(data);
		int secondValue =data.length-2;
		System.out.println("Second Largest Value:" +data[secondValue]);
	} 

}
