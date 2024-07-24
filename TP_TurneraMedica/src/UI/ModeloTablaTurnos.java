package UI;

import java.util.*;
import javax.swing.table.AbstractTableModel;

import Entidades.Medico;
import Entidades.Turno;

public class ModeloTablaTurnos extends AbstractTableModel{
	
	private static final int COLUMNA_ID = 0;
	private static final int COLUMNA_FECHA = 1;
	private static final int COLUMNA_MEDICO = 2;
	private static final int COLUMNA_PACIENTE = 3;
	
	private String[] nombresColumnas = {"ID","Fecha", "Médico", "Paciente"};
	private Class[] tiposColumnas = {int.class, String.class, String.class, String.class};
	private List<Turno> turnos;
	private List<Turno> filtro;
	
	public ModeloTablaTurnos() {
		turnos = new ArrayList<>();
		filtro = new ArrayList<>(turnos);
	}
	
	
	public int getColumnCount() {
		return nombresColumnas.length;
	}
	
	public int getRowCount() {
		return filtro.size();
	}
	
	public String getColumnName(int col) {
		return nombresColumnas[col];
	}
	
	public Class getColumnClass(int col) {
		return tiposColumnas[col];
	}
	
	public Object getValueAt(int fila, int columna) {
		
		Turno turno = filtro.get(fila);
		
		
		Object resultado = null;
		switch(columna) {
		case COLUMNA_ID:
			resultado = turno.getID();
			break;
		case COLUMNA_FECHA:
			resultado = turno.getFecha();
			break;
		case COLUMNA_MEDICO:
			resultado = turno.getMedico().getNombre() + " " + turno.getMedico().getApellido();
			break;
		case COLUMNA_PACIENTE:
			resultado = turno.getPaciente().getNombre()+" "+turno.getPaciente().getApellido();
			break;
		
		default:
			resultado = ("");
		}
		return resultado;
	}

	
	public void filtrarTablaPorNombre(String nombreIngresado) {
		
		filtro.clear();
		
		for(Turno turno : turnos) {
			String nombreMedico = turno.getMedico().getNombre()+" "+turno.getMedico().getApellido();
			if(nombreMedico.toLowerCase().contains(nombreIngresado.toLowerCase())){
				filtro.add(turno);
			}
		}
		
		fireTableDataChanged();
		
	}
	
	public void filtrarTablaPorFecha(String fechaIngresada, Medico medicoUsuario) {
		
		filtro.clear();
		List<Turno> listaTurnos = new ArrayList<>();
		
		for(Turno turno : turnos) {
			Medico medico = turno.getMedico();
			String fecha = turno.getFechaSinHora();
			if(fecha.equals(fechaIngresada) && medico.getDNI() == medicoUsuario.getDNI()){
				listaTurnos.add(turno);
			}
		}
		filtro = listaTurnos;
		
		fireTableDataChanged();
		
	}


	public String[] getNombresColumnas() {
		return nombresColumnas;
	}


	public void setNombresColumnas(String[] nombresColumnas) {
		this.nombresColumnas = nombresColumnas;
	}


	public Class[] getTiposColumnas() {
		return tiposColumnas;
	}


	public void setTiposColumnas(Class[] tiposColumnas) {
		this.tiposColumnas = tiposColumnas;
	}


	public List<Turno> getTurnos() {
		return turnos;
	}


	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}


	public List<Turno> getFiltro() {
		return filtro;
	}


	public void setFiltro(List<Turno> filtro) {
		this.filtro = filtro;
	}
	
	
}
