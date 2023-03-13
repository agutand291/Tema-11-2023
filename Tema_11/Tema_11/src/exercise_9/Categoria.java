package exercise_9;

public enum Categoria {
	
	JEFE('J'), ENCARGADO('E'), EMPLEADO('D');
	
	private final char code;
	
	private Categoria(char code) {
		this.code = code;
	}
	
	public char getCodigo() {
		return code;
	}

}
