package exercise_9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Arboles {
	
	List<Empleado> empList = new ArrayList<>();

	public static void main(String[] args) {
		
		new Arboles().trees();

	}
	
	private void trees() {
		
		empleados();
		treeOne();
		treeTwo();
		treeThree();
		
	}
	
	private void empleados() {
		
		empList.add(new Empleado("Pepe", Categoria.EMPLEADO, LocalDate.of(2011, 3, 21), LocalDate.of(2013, 3, 21)));
		empList.add(new Empleado("Juan", Categoria.ENCARGADO, LocalDate.of(2012, 2, 29), null));
		empList.add(new Empleado("Maria", Categoria.JEFE, LocalDate.of(2010, 4, 30), LocalDate.of(2014, 5, 31)));
		empList.add(new Empleado("Laura", Categoria.EMPLEADO, LocalDate.of(2010, 12, 30), null));
		empList.add(new Empleado("Esteban", Categoria.ENCARGADO, LocalDate.of(2010, 11, 5), LocalDate.of(2015, 2, 11)));
		empList.add(new Empleado("Pedro", Categoria.JEFE, LocalDate.of(2009, 8, 16), null));
		empList.add(new Empleado("Yolanda", Categoria.EMPLEADO, LocalDate.of(2012, 7, 27), LocalDate.of(2013, 10, 1)));
		empList.add(new Empleado("Nuria", Categoria.JEFE, LocalDate.of(2009, 8, 21), null));
		empList.add(new Empleado("Antonio", Categoria.ENCARGADO, LocalDate.of(2011, 1, 28), LocalDate.of(2014, 5, 14)));
		
		empList.add(empList.get(0));
		empList.add(empList.get(6));
		empList.add(empList.get(7));
		
	}
	
	private void treeOne() {
		
		System.out.println("ARBOL1: Ordenado descendentemente por días trabajados.");
		
		SortedSet<Empleado> treeOne = new TreeSet<>(empList);
		
		for (Empleado e : treeOne) {
			System.out.println(e);
		}
		
		System.out.println();
		
	}
	
	private void treeTwo() {
		
		System.out.println("ARBOL2: Ordenado ascendentemente por orden alfabetico del nombre");
		
		SortedSet<Empleado> treeTwo = new TreeSet<>(new Comparator<Empleado>() {
			
			@Override
			public int compare(Empleado o1, Empleado o2) {
				int res = o1.getName().compareTo(o2.getName());
				return res;
			}
		});
		treeTwo.addAll(empList);
		for (Empleado e : treeTwo) {
			System.out.println(e);
		}
		
	}
	
	private void treeThree() {
		
		SortedMap<Clave, Empleado> treeThree = new TreeMap<>();
		
		for (int i = 0; i < empList.size(); i++) {
			treeThree.put(empList.get(i).getClave(), empList.get(i));
		}
		for (Empleado e : treeThree.values()) {
			System.out.println(e);
		}
		
	}

}
