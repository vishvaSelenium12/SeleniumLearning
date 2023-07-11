package week3.day1;

public class SmartPhoneOverriding extends AndroidPhoneOverriding{

	public void takeVideo() {
		System.out.println("Take video from Smart Phone -- Overridding method");
	}
	
	public static void main(String[] args) {
		SmartPhoneOverriding sp = new SmartPhoneOverriding();
		sp.takeVideo();
		
		
		AndroidPhoneOverriding ap = new AndroidPhoneOverriding();
		ap.takeVideo();
	}
}
