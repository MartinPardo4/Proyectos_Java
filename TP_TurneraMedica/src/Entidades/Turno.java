package Entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Turno {
	
	private int ID;
	private Date fecha;
	private Medico medico;
	private Paciente paciente;
	
	public Turno() {
		
	}
	
	public Turno(String fecha, Medico medico, Paciente paciente) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		this.fecha = sdf.parse(fecha);
		this.medico = medico;
		this.paciente = paciente;
	}
	
	public String getFecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return sdf.format(fecha);
	}
	
	public Date getFechaDate() {
		return fecha;
	}
	
	public String getFechaSinHora() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fecha);
	}

	public void setFecha(String fecha) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		this.fecha = sdf.parse(fecha);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
}
