package Entidades;

public class Usuario {
	

	private String nombre;
	private int DNI;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, int DNI) {
		this.nombre = nombre;
		this.DNI = DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int DNI) {
		this.DNI = DNI;
	}
	
	
}
