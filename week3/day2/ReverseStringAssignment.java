package week3.day2;

public class ReverseStringAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name="TestLeaf Learning";
		System.out.println("Length of String:" + name.length());
		char[] ch= name.toCharArray();
		for(int i=name.length()-1;i>=0;i--) {
			System.out.print(ch[i]);
			
			
		}

	}

}
