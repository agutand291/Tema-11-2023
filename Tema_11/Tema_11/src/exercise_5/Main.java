package exercise_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import Exercise_4.ConsoleInput;

public class Main {

	public static void main(String[] args) {
		
		new Main().show();

	}
	
	void show() {
		
		Scanner keyboard = new Scanner(System.in);
		ConsoleInput input = new ConsoleInput(keyboard);
		boolean exit = true;
		
		ListIterator<Float> it;
		List<Float> floatList = new ArrayList<>();
		it = floatList.listIterator();
		
		System.out.println("Introduzca un número para la gestion de... Más numeros.");
	
		do {
			
			System.out.println("1.Mostar Lista \n2.Mostar siguiente \n3.Mostar anterior \n4.Añadir elemento \n5.Eliminar el último mostrado \n6.Sustituir el último mostrado \n7. Salir");
			
			int numRange = input.readIntInRange(0, 8);
			float number;
			
			switch(numRange) {
			case 1: {
				System.out.println(floatList);
			break;
			}
			case 2: {
				if (floatList.isEmpty()) {
					System.err.println("Lista vacia");
				} else if (it.hasNext()) {
					System.out.println(it.next());
				} else {
					it = floatList.listIterator();
				}
			break;
			}
			case 3: {
				if (floatList.isEmpty()) {
					System.err.println("List vacia");
				} else if (it.hasPrevious()) {
					it.previous();
				} else {
					System.err.println("No hay anterior.");
				}
			break;
			}
			case 4: {
				number = input.readFloat();
				it.add(number);
			break;
			}
			case 5: {
				if (it.hasPrevious()) {
					it.remove();
				} else {
					System.err.println("No hay anterior.");
				}
			break;
			}
			case 6: {
				if (it.hasPrevious()) {
					number = input.readFloat();
					it.set(number);
				} else {
					System.err.println("No se ha mostrado ningun elemento.");
				}
			break;
			}
			case 7: {
				exit = false;
			}
			}
			
		} while (exit);
		
	}

}
