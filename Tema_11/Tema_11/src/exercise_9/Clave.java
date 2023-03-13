package exercise_9;

import java.util.Objects;

public class Clave implements Comparable<Clave> {
	
	private Categoria categoria;
	private int num;
	
	private static int numJefe = 0;
	private static int numEnc = 0;
	private static int numEmp = 0;
	
	public Clave(Categoria categoria) {
		this.categoria = categoria;
		num = counter(categoria);
	}
	
	public int getNum() {
		return num;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public int hashCode() {
		return Objects.hash(num, categoria);
	}
	
	private int counter(Categoria categoria) {
		if (categoria == Categoria.JEFE) {
			return ++numJefe;
		} else if (categoria == Categoria.ENCARGADO) {
			return ++numEnc;
		} else {
			return ++numEmp;
		}
	}
	
	@Override
	public int compareTo(Clave o) {
		int res = categoria.compareTo(o.categoria);
		if (res == 0) {
			res = Integer.compare(num, o.num);
		}
		return res;
	}
	
	@Override
	public String toString() {
		return String.format("%c%d", categoria.getCodigo(), num);
	}

}
