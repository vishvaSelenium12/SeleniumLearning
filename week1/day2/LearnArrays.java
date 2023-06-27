package week1.day2;

import java.util.Arrays;

public class LearnArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data = {1,3,2,5,6,7};
		Arrays.sort(data);
		System.out.println(data.length);

		int len =data.length;
		for (int i = 0; i <len; i++) {
			System.out.println(data[i]);
			
		}
	}

}
