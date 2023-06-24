package week1.day1;

public class LearnForLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Print number 1 to 10
		
		for(int i=1 ;i<=10;i++) {
			System.out.println(i);
		}
		
		//Print number 100 to 1
		for(int j=100;j>=1;j--) {
			System.out.println(j);
		}

		//Printing even number
		for(int k=1;k<=20;k++){
			if(k%2==0) {
				System.out.println(k);
			}
			
		}
	}

}
