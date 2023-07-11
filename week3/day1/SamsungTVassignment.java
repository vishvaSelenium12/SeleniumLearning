package week3.day1;

public class SamsungTVassignment extends AndroidTVAssignment {

	@Override
	public void watchVideo() {
		
		System.out.println("Watch video from Samsung Tv");
		
	}
	
	public void pauseVideo() {
		System.out.println("Pause video features from Samsung Tv");
	}
	
	@Override
	public void sonyAndroid() {
		System.out.println("SonyAndroid from ---> Samsung Tv");
		
	}

	public static void main(String[] args) {
		SamsungTVassignment sam = new SamsungTVassignment();
		sam.watchVideo();
		sam.pauseVideo();
		sam.openApp();
		sam.sonyAndroid();
	}

	

	
}
