package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class MissingNumberinArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers= {1,2,3,4,6};
		//output 5
		
		Set<Integer> set = new TreeSet<Integer>();
		for(Integer eachValue :numbers) {
			set.add(eachValue);
		}
		System.out.println("Set value is:" + set);
		List<Integer> li = new ArrayList<Integer>(set);
		System.out.println("List value is :"+ li);
		for(int i=0;i<li.size();i++) {
			if(li.get(i) != i+1) {
				System.out.println(i+1);
			}
			
		}
		
		
		
	}

}
