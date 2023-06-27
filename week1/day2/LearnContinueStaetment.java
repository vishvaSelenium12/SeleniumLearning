package week1.day2;

public class LearnContinueStaetment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=1;i<=10;i++) {
			
			if(i==3) {
				System.out.println("Three");
				continue;
				//Exit /stop the current iteration 
			}
			
			System.out.println(i);
		}

	}

}
