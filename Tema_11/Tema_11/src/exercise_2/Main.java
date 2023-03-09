package exercise_2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		new Main().show();

	}
	
	void show() {
		
		List<Integer> resOne = new ArrayList<>();
		resOne.add(1);
		resOne.add(2);
		resOne.add(3);
		
		System.out.println(resOne);
		System.out.println(reverse(resOne));
		
	}
	
	<T> List<T> reverse(List<T> list) {
		
		if(list.isEmpty()) {
			throw new IllegalArgumentException("Empty list");
		}
		
		int listSize = list.size();
		List<T> reversed = new ArrayList<>();
		
		for (int i = 0; i < listSize; i++) {
			reversed.add(list.get((listSize-i-1)));
		}
		
		return reversed;
	}

}
