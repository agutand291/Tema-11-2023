package exercise_1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		new Main().show();

	}
	
	public void show() {
		
		Integer nums[] = {1, 2, 3};
		Character chars[] = {'a', 'b', 'c'};
		
		List<Integer> resOne = list(nums);
		List<Character> resTwo = list(chars);
		List<Integer> resOneSec = list(nums);
		List<Character> resTwoSec = list(chars);
		
		
		System.out.println(resOne);
		System.out.println(resTwo);
		System.out.println(resOneSec);
		System.out.println(resTwoSec);
		
	}
	
	<T> List<T> list(T[] array) {
		
		List<T> arrList = new ArrayList<>();
		
		for(int i = 0; i < array.length; i++) {
			arrList.add(array[i]);
		}
		
		return arrList;
	}
	
	<T> List<T> listTwo(T[] array) {
	
		List<T> arrList = new ArrayList<>();
		
		for(T a: array) {
			arrList.add(a);
		}
		
		return arrList;
		
	}

}
