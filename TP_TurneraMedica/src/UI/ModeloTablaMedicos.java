package UI;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import Entidades.Medico;
import java.util.*;
import Service.*;

public class ModeloTablaMedicos extends AbstractTableModel{
	
	private static final int COLUMNA_NOMBRE = 0;
	private static final int COLUMNA_APELLIDO = 1;
	private static final int COLUMNA_DNI = 2;
	private static final int COLUMNA_AREA = 3;
	
	private String[] nombresColumnas = {"nombre", "apellido", "DNI", "cobro"};
	private Class[] tiposColumnas = {String.class, String.class, int.class, int.class};
	private List<Medico> medicos;
	private List<Medico> filtro;
	
	public ModeloTablaMedicos() {
		medicos = new ArrayList<>();
		filtro = new ArrayList<>(medicos);
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
		
		Medico medico = filtro.get(fila);
		
		
		Object resultado = null;
		switch(columna) {
		case COLUMNA_NOMBRE:
			resultado = medico.getNombre();
			break;
		case COLUMNA_APELLIDO:
			resultado = medico.getApellido();
			break;
		case COLUMNA_DNI:
			resultado = medico.getDNI();
			break;
		case COLUMNA_AREA:
			resultado = medico.getCobro();
			break;
		default:
			resultado = ("");
		}
		return resultado;
	}

	
	public void filtrarTabla(String textoIngresado) {
		
		filtro.clear();
		
		for(Medico medico : medicos) {
			if(medico.getNombre().toLowerCase().contains(textoIngresado.toLowerCase())){
				filtro.add(medico);
			}
		}
		
		fireTableDataChanged();
		
	}
	
	public List<Medico> getMedicos() {		
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}


	public List<Medico> getFiltro() {
		return filtro;
	}


	public void setFiltro(List<Medico> filtro) {
		this.filtro = filtro;
	}


	
}
