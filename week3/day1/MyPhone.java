package week3.day1;

public class MyPhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IPhone iph = new IPhone();
		iph.startApp();
		iph.increaseVolume();
		iph.shutdown();
		iph.makeCall();
		iph.sendSMS();
		
		IOS io =new IPhone();
		io.startApp();
		io.shutdown();
		io.increaseVolume();
		
	}

}
