package exercise_10;

import java.util.ArrayDeque;
import java.util.ListIterator;
import java.util.Queue;
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
		
		ListIterator<Byte> it;
		Queue<Byte> byteQueue = new ArrayDeque<>();
		it = (ListIterator<Byte>) byteQueue.iterator();
		
		System.out.println("Introduzca un numero para la gestion de bytes.\n");
		
		do {
			
			System.out.println("1.Nueva lista \n2.Consultar elemento \n3.Añadir elemento \n4.Eliminar elemento \n5.Consultar toda la pila \n6.Salir");
			
			int numRange = input.readIntInRange(0, 7);
			byte number;
			
			switch (numRange) {
			case 1: {
				byteQueue.clear();
				break;
			}
			case 2: {
				if (byteQueue.isEmpty()) {
					System.err.println("Lista vacia");
				} else if (it.hasNext()){
					it.next();
					System.out.println(it);
				} else {
					System.err.println("No hay siguiente.");
				}
				break;
			}
			case 3: {
				number = input.readByte();
				it.add(number);
				break;
			}
			case 4: {
				it.remove();
				break;
			}
			case 5: {
				System.out.println(byteQueue);
				break;
			}
			case 6: {
				exit = false;
			}
			}
			
		} while (exit);
		
	}

}
