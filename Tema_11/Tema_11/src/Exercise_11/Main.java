package Exercise_11;

import java.util.ArrayDeque;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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
		Queue<Byte> byteStack = new ArrayDeque<Byte>();
		it = (ListIterator<Byte>) byteStack.iterator();
		
		System.out.println("Introduzca un numero para la gestion de bytes.");
		
		do {
			
			System.out.println("1.Nueva lista \n2.Consultar elemento \n3.Añadir elemento \n4.Eliminar elemento \n5.Consultar toda la pila \n6.Salir");
		
			int numRange = input.readIntInRange(0, 7);
			byte number;
			
			switch (numRange) {
			case 1: {
				byteStack.clear();
				break;
			}
			case 2: {
				if (byteStack.isEmpty()) {
					System.err.println("Lista vacia");
				} else if (it.hasNext()) {
					it.next();
					System.out.println(it);
				} else {
					System.err.println("No hay siguiente");
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
				System.out.println(byteStack);
			}
			case 6: {
				exit = false;
			}
			}

		} while (exit);
		
	}

}
