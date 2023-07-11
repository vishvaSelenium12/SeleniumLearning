package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

import net.bytebuddy.description.modifier.SynchronizationState;

public class RemoveDuplicatesWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "We learn java basics as part of java sessions in java week1";
		String[] splitWord = text.split("\\s+");
	
		Set<String> setWord = new LinkedHashSet<String>();
		for(int i=0;i<splitWord.length;i++) {
			setWord.add(splitWord[i]);
		}
		
		System.out.print(setWord);
	}

}
