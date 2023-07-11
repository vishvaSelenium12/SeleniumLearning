package week3.day2;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "I am a software tester";
		String[] splitName=name.split(" ");
		
		for(int i=0;i<=splitName.length-1;i++) {
			if(i%2 !=0) {
				char[] evenWord =splitName[i].toCharArray();
				for(int j=evenWord.length-1;j>=0;j--) {
					System.out.print(evenWord[j] +"");
					
				}
				System.out.print(" ");
			}
			else {
				System.out.print(splitName[i]+" ");
			}
		}
		
	}

}
