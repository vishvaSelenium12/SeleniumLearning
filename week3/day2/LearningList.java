package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class LearningList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> familyName=new ArrayList<String>();
		
		List<String> parent= new ArrayList<String>();
		//List is an interface
		// Array list is implementing class
		//Show only methods avaialble in list 
		
		//to add item in list
		familyName.add("Vishvanathan");
		familyName.add("Gomathi");
		familyName.add("Mouneesh");
		familyName.add("Sreenish");
		System.out.println(familyName);
		
		System.out.println("Family size:" + familyName.size());
		//to add aal item in another list
		parent.addAll(familyName);
		System.out.println("{arent Size:" +parent.size());
		parent.add("veerabathiran");
		parent.add("Suseela");
		System.out.println("parent Size:" +parent.size());
		System.out.println(parent);
		
		System.out.println(parent.get(4));
		//To add item in particular index
		familyName.add(1, "GomVishva");
		System.out.println(familyName);
		
		//to remove the item from specific index
		familyName.remove(1);
		//to remove all element from list
		parent.removeAll(familyName);
		System.out.println(parent);
		

	}

}
