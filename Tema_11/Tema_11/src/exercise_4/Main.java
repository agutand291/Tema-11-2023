package exercise_4;

import java.util.ArrayList;
import java.util.List;
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
		
		List<String> strList = new ArrayList<>();
		
		System.out.println("Introduzca un número para la gestión de cadenas. \n");
		
		do {
			
			System.out.println("1.Nueva lista \n2.Número de cadenas \n3.Añadir cadena \n4.Eliminar cadena \n5.Contiene cadena \n6.Mostar lista entera \n7.Salir");
			
			int numRange = input.readIntInRange(0, 8);
			int inputNum;
			String str = "";
			
			switch (numRange) {
			case 1: {
				if (strList.size()==0) {
					System.err.println("Lista vacia.");
				} else {
					strList.clear();
				}
				break;
			}
			case 2: {
				System.out.println(strList.size());
				break;
			}
			case 3: {
				str = input.readString();
				strList.add(str);
				break;
			}
			case 4: {
				
				if (strList.size()==0) {
					System.err.println("No hay cadena que borrar.");
				} else {
					inputNum = input.readIntInRange(0, strList.size()+1);
					strList.remove(inputNum-1);
				}
				break;
			}
			case 5: {
				
				if (strList.size()==0) {
					System.err.println("No hay lista en la que buscar.");
				} else {
					str = input.readString();
					System.out.println(strList.contains(str) ? "Contiene" : "No contiene");
				}
				break;
			}	
			case 6: {
				System.out.println(strList);
				break;
			}
			case 7: {
				exit = false;
				break;
				}
			}
			
		} while (exit);
		
	}
	
	
	}
