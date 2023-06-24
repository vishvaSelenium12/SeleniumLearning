package week1.day1;

public class LearnSwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String browserType="Chrome";
		
		switch(browserType) {
		case "Chrome":
			System.out.println("Open Chrome browser");
			//break;
		case "Edge":
			System.out.println("Open edge browser");
			break;

			default:
			System.out.println("Open default browser");
			
		
		}
	}

}
