package week3.day2;

public class StringReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name="Chennai 600097";
		
		//To print only numbers
		String pincodeOnly=name.replaceAll("[^0-9]", "");
		System.out.println(pincodeOnly);
		
		//To print only ASCII values
		String onlyCityName=name.replaceAll("[^a-zA-Z]", "");
		System.out.println(onlyCityName);
		
		String values="9,87,100";
		String num =values.replaceAll(",", "");
		System.out.println(num);
		
		//String to integer
		
		int number =Integer.parseInt(num);
		System.out.println(number);

	}

}
