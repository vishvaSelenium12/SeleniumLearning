package week1.day2;

public class LearnMethodReturnTypes {



	public void getVoidMethod() {

		System.out.println("Void Method");
	}

	public int getCycleNumber() {

		return 10;
	}

	public boolean isMarried() {

		return true;
	}

	public String getCarName(String carName, int carCount) {

		return carName +" "+carCount;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LearnMethodReturnTypes ob = new LearnMethodReturnTypes();
		int cycleNum =ob.getCycleNumber();
		System.out.println("CycleCount:" + cycleNum);
		String carName=ob.getCarName("Maruthi", 1);
		System.out.println("CarName is:" + carName);
		boolean marraiedAns =ob.isMarried();
		System.out.println("Married Status:" + marraiedAns);

	}
}
