package week1.day2;

import java.util.Arrays;

public class DuplicateNumbersinArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers= {2,5,7,7,5,9,2,3};
		Arrays.sort(numbers);
		
		System.out.println("******Printing All arrays data using 2 for loop *******");
		for(int i=0;i<numbers.length;i++) {
			
			for(int j=i+1;j<numbers.length;j++) {
				
				if(numbers[i]==numbers[j]) {
					System.out.println("Duplicate number in array is:" + numbers[i]);
					
				}
			}
			
		}
		
		System.out.println("******Printing All arrays data using 1 for loop ******* ");
		for(int k=0;k<numbers.length;k++) {
			
			if(numbers[k]==numbers[k+1]) {
				System.out.println("Duplicate numbers in array is:" + numbers[k]);
			}
		}
	}

}
