package exercise_6;

import java.util.EnumSet;

public class Main {

	public static void main(String[] args) {
		
		new Main().show();

	}
	
	void show() {
		
		EnumSet<Meses> allMonths, summerMonths, noSummerMonths, enumCopy, sepToDec;
		
		allMonths = EnumSet.allOf(Meses.class);
		
		summerMonths = EnumSet.noneOf(Meses.class);
		summerMonths.add(Meses.JUNIO);
		summerMonths.add(Meses.JULIO);
		summerMonths.add(Meses.AGOSTO);
		
		noSummerMonths = EnumSet.complementOf(summerMonths);
		
		enumCopy = EnumSet.copyOf(noSummerMonths);
		
		sepToDec = EnumSet.range(Meses.SEPTIEMBRE, Meses.DICIEMBRE);
		
		System.out.println(allMonths);
		System.out.println(summerMonths);
		System.out.println(noSummerMonths);
		System.out.println(enumCopy);
		System.out.println(sepToDec);
		
	}

}
