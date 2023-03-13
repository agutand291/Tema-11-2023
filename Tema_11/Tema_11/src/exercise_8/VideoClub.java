package exercise_8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class VideoClub {
	
	List<Pelicula> moviesList = new ArrayList<>();

	public static void main(String[] args) {
		
		new VideoClub().lists();
		
	}
	
	private void lists() {
		
		movies();
		listOne();
		listTwo();
		listThree();
		listFour();
		listFive();
		
	}
	
	private void movies() {
		
		moviesList.add(new Pelicula("Poltergeist, juegos diabolicos.", Genero.TERROR, LocalDate.of(2015, 5, 22), LocalDate.of(2015, 9, 22)));
		moviesList.add(new Pelicula("La cumbre escarlata", Genero.TERROR, LocalDate.of(2015, 10, 9), LocalDate.of(2016, 2, 12)));
		
		moviesList.add(new Pelicula("Ocho apellidos catalanes", Genero.COMEDIA, LocalDate.of(2015, 11, 20), LocalDate.of(2016, 3, 18)));
		moviesList.add(new Pelicula("Padres por desigual", Genero.COMEDIA, LocalDate.of(2016, 1, 1), LocalDate.of(2016, 5, 11)));
		
		moviesList.add(new Pelicula("Star Warrs: El despertar de la Fuerza", Genero.FICCION, LocalDate.of(2015, 12, 18), LocalDate.of(2016, 4, 20)));
		moviesList.add(new Pelicula("Mad Max: Furia en la carretera", Genero.FICCION, LocalDate.of(2015, 5, 15), LocalDate.of(2015, 9, 1)));
		
		moviesList.add(moviesList.get(0));
		moviesList.add(moviesList.get(4));
		
	}
	
	private void listOne() {
		
		Set<Pelicula> listOne = new LinkedHashSet<>(moviesList);
		
		System.out.println("Lista sin duplicados que consigue mantener el orden en el que los datos fueron insertados");
		
		for (Pelicula e : listOne) {
			System.out.println(e);
		}
		
		System.out.println();
		
	}
	
	private void listTwo() {
		
		System.out.println("Arbol ordenador descendentemente por dias que ha tardado en salir en DVD desde que se estrenó.");
		
		SortedSet<Pelicula> listTwo = new TreeSet<>(moviesList);
		
		for (Pelicula e : listTwo) {
			System.out.printf("%s Dias: %s \n", e, e.compareDays());
		}
		
		System.out.println();
		
	}
	
	private void listThree() {
		
		System.out.println("Arbol ordenado ascendentemente por fecha de estreno.");
		
		SortedSet<Pelicula> listThree = new TreeSet<>(new Comparator<Pelicula>() {
			
			/*
			 * Override al comparator para ordenar por fecha de estreno, en vez del default.
			 */
			
			@Override
			public int compare(Pelicula o1, Pelicula o2) {
				return o1.getFechaEstreno().compareTo(o2.getFechaEstreno());
			}
		});
		listThree.addAll(moviesList);
		
		for (Pelicula e : listThree) {
			System.out.println(e);
		}
		
		System.out.println();
		
	}
	
	private void listFour() {
		
		System.out.println("Mapa ordenado por clave");
		
		SortedMap<Clave, Pelicula> listFour = new TreeMap<>();
		
		for (int i = 0; i < moviesList.size(); i++) {
			listFour.put(moviesList.get(i).getClave(), moviesList.get(i));
		}
		
		for (Pelicula e : listFour.values()) {
			System.out.println(e);
		}
		
		System.out.println();
		
	}
	
	private void listFive() {
		
		System.out.println("Mapa anterior mostrado al revés");
		
		
		SortedMap<Clave, Pelicula> listFive = new TreeMap<>(new Comparator<Clave>() {
			
			/*
			 * Override para compara con claves, comparando la segunda con la primera para hacer un orden inverso.
			 */
			
			@Override
			public int compare(Clave o1, Clave o2) {
				int result = o2.compareTo(o1);
				if (result == 0) {
					result = Integer.compare(o1.getNum(), o2.getNum());
				}
				return result;
			}			
		});
		
		for (int i = 0; i < moviesList.size(); i++) {
			listFive.put(moviesList.get(i).getClave(), moviesList.get(i));
		}
		for (Pelicula e : listFive.values()) {
			System.out.println(e);
		}
		
	}

}
