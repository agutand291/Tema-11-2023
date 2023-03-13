package exercise_9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Empleado implements Comparable<Empleado> {
	
	private Clave clave;
	private String name;
	private LocalDate fechaAlta, fechaBaja;
	
	Empleado(String name, Categoria categoria, LocalDate fechaAlta, LocalDate fechaBaja) {
		this.name = name;
		this.clave = new Clave(categoria);
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
	}
	
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	
	public LocalDate getFechaBaja() {
		return fechaBaja;
	}
	
	public String getName() {
		return name;
	}
	
	public Clave getClave() {
		return clave;
	}
	
	public int workDays(LocalDate fechaAlta, LocalDate fechaBaja) {
		if (fechaBaja == null) {
			return (int) ChronoUnit.DAYS.between(fechaAlta, LocalDate.now());
		} else {
			return (int) ChronoUnit.DAYS.between(fechaAlta, fechaBaja);
		}
	}
	
	private String baja() {
		if (fechaBaja == null) {
			return "No tiene";
		} else {
			return fechaBaja.toString();
		}
	}
	
	public int workDays() {
		if (fechaBaja == null) {
			return (int) ChronoUnit.DAYS.between(fechaAlta, LocalDate.now());
		} else {
			return (int) ChronoUnit.DAYS.between(fechaAlta, fechaBaja);
		}
	}

	@Override
	public int compareTo(Empleado o) {
		int res = Integer.compare(o.workDays(), workDays());
		if (res == 0) {
			res = name.compareTo(o.name);
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fechaAlta, fechaBaja, clave, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(fechaAlta, other.fechaAlta) && Objects.equals(fechaBaja, other.fechaBaja) && Objects.equals(clave, other.clave) && Objects.equals(name, other.name);
	}
	
	public String toString() {
		return String.format("%-10s Nombre:%-9s Clave:%s Fecha Alta:%s Fecha Baja:%s Dias Trabajados: %d ", clave.getCategoria(), name, clave, fechaAlta.getDayOfMonth()+"/"+fechaAlta.getMonthValue()+"/"+fechaAlta.getYear(), baja(), workDays());
	}

}
