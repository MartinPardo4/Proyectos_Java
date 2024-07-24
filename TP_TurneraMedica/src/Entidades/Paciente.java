package Entidades;

public class Paciente extends Usuario{
	
	private String apellido;
	private int numeroObraSocial;
	
	public Paciente() {
		super();
	}
	
	public Paciente(String nombre, String apellido, int DNI, int numeroObraSocial) {
		super(nombre, DNI);
		this.apellido = apellido;
		this.numeroObraSocial = numeroObraSocial;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNumeroObraSocial() {
		return numeroObraSocial;
	}

	public void setNumeroObraSocial(int numeroObraSocial) {
		this.numeroObraSocial = numeroObraSocial;
	}
	
	
}
