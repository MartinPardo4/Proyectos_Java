package Entidades;

public class Medico extends Usuario{
	

	private String apellido;
	private int cobro;
	

	public Medico() {
		super();
	}
	
	public Medico(String nombre,String apellido, int DNI, int cobro) {
		super(nombre, DNI);
		this.apellido = apellido;
		this.cobro = cobro;
	}
	

	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCobro() {
		return cobro;
	}

	public void setCobro(int cobro) {
		this.cobro = cobro;
	}

}
