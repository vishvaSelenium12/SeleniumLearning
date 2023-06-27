package week1.day2;

public class LearnBreakStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//find 3 and break the loop
		
		for(int i=50;i>=1;i--) {
			
			if(i==3) {
				System.out.println("Printing identifying number is :" + i);
				break; //Stop the execution of for loop 
			}
			
			System.out.println(i);
		}
		
	
	}

}
