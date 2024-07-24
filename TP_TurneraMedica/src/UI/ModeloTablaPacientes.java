package UI;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import Entidades.*;
import java.util.*;
import Service.*;

public class ModeloTablaPacientes extends AbstractTableModel{
	
	private static final int COLUMNA_NOMBRE = 0;
	private static final int COLUMNA_APELLIDO = 1;
	private static final int COLUMNA_DNI = 2;
	private static final int COLUMNA_OBRA_SOCIAL = 3;
	
	private String[] nombresColumnas = {"nombre", "apellido", "DNI", "obraSocial"};
	private Class[] tiposColumnas = {String.class, String.class, int.class, int.class};
	private List<Paciente> pacientes;
	private List<Paciente> filtro;
	
	public ModeloTablaPacientes() {
		pacientes = new ArrayList<>();
		filtro = new ArrayList<>(pacientes);
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
		
		Paciente paciente = filtro.get(fila);
		
		
		Object resultado = null;
		switch(columna) {
		case COLUMNA_NOMBRE:
			resultado = paciente.getNombre();
			break;
		case COLUMNA_APELLIDO:
			resultado = paciente.getApellido();
			break;
		case COLUMNA_DNI:
			resultado = paciente.getDNI();
			break;
		case COLUMNA_OBRA_SOCIAL:
			resultado = paciente.getNumeroObraSocial();
			break;
		default:
			resultado = ("");
		}
		return resultado;
	}

	
	public void filtrarTabla(String textoIngresado) {
		
		filtro.clear();
		
		for(Paciente paciente : pacientes) {
			if(paciente.getNombre().toLowerCase().contains(textoIngresado.toLowerCase())){
				filtro.add(paciente);
			}
		}
		
		fireTableDataChanged();
		
	}
	
	public List<Paciente> getPacientes() {		
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}


	public List<Paciente> getFiltro() {
		return filtro;
	}


	public void setFiltro(List<Paciente> filtro) {
		this.filtro = filtro;
	}


	
}
