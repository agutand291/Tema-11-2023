package exercise_8;

import java.util.Objects;

public class Clave implements Comparable<Clave> {
	
	private Genero type;
	private int num;
	
	private static int numFic = 0;
	private static int numCom = 0;
	private static int numTer = 0;
	
	/*
	 * Genera una clave a partir del tipo de la pelicula y el número de veces que se ha visto.
	 * @param type Tipo de pelicula en el Enum
	 */
	
	public Clave(Genero type) {
		this.type = type;
		num = counter(type);
	}
	
	public int getNum() {
		return num;
	}
	
	public Genero getGenero() {
		return type;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(num, type);
	}
	
	/*
	 * Metodo para comprobar las claves. Devuelve 0 si es el mismo.
	 */

	@Override
	public int compareTo(Clave o) {
		int res = type.compareTo(o.type);
		if (res == 0) {
			res = Integer.compare(num, o.num);
		}
		return res;
	}
	
	private int counter(Genero type) {
		if (type == Genero.FICCION) {
			return ++numFic;
		} else if (type == Genero.COMEDIA) {
			return ++numCom;
		} else {
			return ++numTer;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%c%d", type.getCodigo(), num);
	}

}
