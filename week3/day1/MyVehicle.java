package week3.day1;

public class MyVehicle {

		public static void main(String[] args) {
			
			Car c = new Car();
			c.reverseGear();
			c.applyBrake();
			c.soundHorbn();

			Auto au = new Auto();
			au.applyMeter();
			au.applyBrake();
			au.soundHorbn();
	
			BMW bm = new BMW();
			bm.applyBrake();
			bm.soundHorbn();
			bm.reverseGear();
			bm.moonRoof();
			
			Audi ad= new Audi();
			ad.applyBrake();
			ad.soundHorbn();
			ad.reverseGear();
			ad.autoParking();
			
			Bajaj bj = new Bajaj();
			bj.applyBrake();
			bj.soundHorbn();
			bj.applyMeter();
			bj.autoStart();
			System.out.println(bj.noOfWheels);
		}
	

}
