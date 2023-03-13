package exercise_8;

public enum Genero {
	
	COMEDIA('C'), FICCION('F'), TERROR('T');
	
	private final char code;
	
	private Genero(char code) {
		this.code = code;
	}
	
	public char getCodigo() {
		return code;
	}

}
