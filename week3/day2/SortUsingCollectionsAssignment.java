package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortUsingCollectionsAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)
		
		// Required Output: Wipro, HCL , CTS, Aspire Systems
		
		String[] companyName= {"HCL", "Wipro", "Aspire Systems", "CTS"};
		System.out.println(companyName.length);
		List<String> liName= new ArrayList<String>();
		for(String eachString: companyName) {
			liName.add(eachString);
		}
		System.out.println(liName);
		
		Collections.sort(liName);
		System.out.println("After sorting :" + liName);
		for(int i=liName.size()-1;i>=0;i--) {
			System.out.print(liName.get(i) +"," );
		}

	}

}
