package exercise_8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Pelicula implements Comparable<Pelicula> {
	
	private Clave clave;
	private String name;
	private LocalDate fechaEstreno, fechaDVD;
	
	Pelicula(String name, Genero genero, LocalDate fechaEstreno, LocalDate fechaDVD) {
			this.name = name;
			clave = new Clave(genero);
			compareDates(fechaEstreno, fechaDVD);
	}
	
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}
	
	public String getName() {
		return name;
	}
	
	public Clave getClave() {
		return clave;
	}
	
	public void compareDates(LocalDate fechaEstreno, LocalDate fechaDVD) {
		if (fechaEstreno.isAfter(fechaDVD)) {
			throw new IllegalArgumentException("la fecha de DVD es anterior a la del estreno");
		} else {
			this.fechaEstreno = fechaEstreno;
			this.fechaDVD = fechaDVD;
		}
	}
	
	public int compareDays() {
		return (int) ChronoUnit.DAYS.between(fechaEstreno, fechaDVD);
	}

	@Override
	public int compareTo(Pelicula o) {
		int res = Integer.compare(o.compareDays(), compareDays());
		if (res == 0) {
			res = name.compareTo(o.name);
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fechaDVD, fechaEstreno, clave, name);
	}
	
	/*
	 * Colección sin duplicados
	 * Con este metodo no habrá duplicados en las colecciones que se creen.
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(fechaDVD, other.fechaDVD) && Objects.equals(fechaEstreno, other.fechaEstreno) && Objects.equals(clave, other.clave) && Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("%-9s%-38sClave: %s Fecha estreno: %s Fecha DVD %S", clave.getGenero(), name, clave, format.format(fechaEstreno), format.format(fechaDVD));
	}

}
