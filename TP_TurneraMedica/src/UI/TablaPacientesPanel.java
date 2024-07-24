package UI;

import java.util.List;
import javax.swing.*;
import Entidades.*;
import Service.*;

public class TablaPacientesPanel extends TablaPanel{
	
	private JTable tablaPacientes;
	private ModeloTablaPacientes modelo;
	private JScrollPane scrollPane;
	private List<Paciente> listaPacientes;
	
	public TablaPacientesPanel(UIManager manager) {
		super(manager);
	}
	
	public void crearTablaPanel() {
		
		modelo = new ModeloTablaPacientes();
		tablaPacientes = new JTable(modelo);
		scrollPane = new JScrollPane(tablaPacientes);
		this.add(scrollPane);
		
		try {
			PacienteService service = new PacienteService();
			listaPacientes = service.enlistarPaciente();
			modelo.setPacientes(listaPacientes); 
			modelo.fireTableDataChanged();
		}catch(EnlistarException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		modelo.filtrarTabla("");
		
	}

	public JTable getTablaPacientes() {
		return tablaPacientes;
	}

	public void setTablaPacientes(JTable tablaPacientes) {
		this.tablaPacientes = tablaPacientes;
	}

	public ModeloTablaPacientes getModelo() {
		return modelo;
	}

	public void setModelo(ModeloTablaPacientes modelo) {
		this.modelo = modelo;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public List<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}
	
	
}