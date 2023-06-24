package week1.day1;

public class PrintFibbinocciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Print fibbinocci from 0 to 56
		
		int firstNum =0;
		int secondNum=1;
		int sum=0;
		System.out.println(firstNum);
		System.out.println(secondNum);
		for(int i=2;i<11;i++) {
			sum=firstNum+secondNum;
			System.out.println(sum);
			firstNum=secondNum;
			secondNum=sum;
			
		}
	}

}
