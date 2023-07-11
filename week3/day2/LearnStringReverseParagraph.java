package week3.day2;

public class LearnStringReverseParagraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String companyName="Amazon Devlopment Center";
		String[] splitName=companyName.split(" ");
		
		for(int i=splitName.length-1;i>=0;i--) {
			System.out.println(splitName[i]);
		}

	}

}
