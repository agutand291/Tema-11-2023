package exercise_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		new Main().show();

	}
	
	void show() {
		
		List<String> strListOne = new ArrayList<>();
		List<String> strListTwo = new ArrayList<>();
		
		strListOne.add("Uno");
		strListOne.add("Dos");
		strListOne.add("Tres");
		
		strListTwo.add("Cuatro");
		strListTwo.add("Cinco");
		strListTwo.add("Seis");
		
		System.out.println(Arrays.toString(twoListArray(strListOne, strListTwo)));
		
	}
	
	<T> T[] twoListArray(List<T> listOne, List<T> listTwo) {
		
		List<T> retArray;
		
		if(listOne.isEmpty() && listTwo.isEmpty()) {
			throw new IllegalArgumentException("Empty Lists");
		} else if (listOne.isEmpty()) {
			return ((T[])listOne.toArray());
		} else if (listTwo.isEmpty()) {
			return ((T[])listTwo.toArray());
		} else {
			
			retArray = new ArrayList<>();
			retArray.addAll(listOne);
			retArray.addAll(listTwo);
			
			return (T[])retArray.toArray();	
		}
		
	}

}
