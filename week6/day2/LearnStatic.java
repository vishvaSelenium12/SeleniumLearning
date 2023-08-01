package week6.day2;

public class LearnStatic {

	int id;
	String name;
	static String companyName;

	public void setValues(int ids, String names, String cName) {
		id=ids;
		name=names;
		companyName=cName;
	}

	public void printValues() {
		System.out.println(id+name+companyName);
	}
	
	public static void add() {
		System.out.println("I am a static method");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LearnStatic ls = new LearnStatic();
		LearnStatic ls1 = new LearnStatic();
		ls.setValues(100,"Vishva","TCS");
		ls.printValues();
		//LearnStatic ls1 = new LearnStatic();
		ls1.setValues(200,"Gomathi","Info");
		ls.printValues();
		ls1.printValues();
		add();
	}

}
