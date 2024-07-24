package UI;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import Entidades.*;
import Service.*;

public class PantallaTablaPacientes extends AbstractTablaPanel{

	private TablaPacientesPanel tablaPacientesPanel;
	private PacienteService service = new PacienteService();
	
	public PantallaTablaPacientes(UIManager manager) {
		super(manager);
	}
	
	public void setTablaPanel() {
		tablaPacientesPanel = new TablaPacientesPanel(manager);
		tablaPanel = tablaPacientesPanel;
	}
	
	public void ejecutarAccionAgregar() {
		manager.mostrarPanelAgregarPaciente();
	}
	
	public void ejecutarAccionBorrar() {
		
		JTable tablaPacientes = tablaPacientesPanel.getTablaPacientes();
		ModeloTablaPacientes modelo = tablaPacientesPanel.getModelo();
		
		int filaSeleccionada = tablaPacientes.getSelectedRow();
		
		if(filaSeleccionada != -1){
			int DNISeleccionado = (Integer)tablaPacientes.getValueAt(filaSeleccionada, 2);
			modelo.getPacientes().remove(filaSeleccionada);
			modelo.filtrarTabla("");
			try {
				service.eliminarPaciente(DNISeleccionado);
			}catch(BorrarException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			modelo.fireTableDataChanged();
		}
	}
	
	public void ejecutarAccionBuscar() {
		
		String textoIngresado = opcionesTablaPanel.getTextoBusqueda().getText();
		tablaPacientesPanel.getModelo().filtrarTabla(textoIngresado);
	}
	
	public void ejecutarAccionEditar() {
		
		int filaSeleccionada = tablaPacientesPanel.getTablaPacientes().getSelectedRow();
		
		if(filaSeleccionada != -1) {
			Paciente pacienteSeleccionado = tablaPacientesPanel.getModelo().getPacientes().get(filaSeleccionada);
			manager.getPanelEditarPaciente().setPacienteSeleccionado(pacienteSeleccionado);
			manager.mostrarPanelEditarPaciente(pacienteSeleccionado);
		}
	}

	public TablaPacientesPanel getTablaPacientesPanel() {
		return tablaPacientesPanel;
	}

	public void setTablaPacientesPanel(TablaPacientesPanel tablaPacientesPanel) {
		this.tablaPacientesPanel = tablaPacientesPanel;
	}

	public PacienteService getService() {
		return service;
	}

	public void setService(PacienteService service) {
		this.service = service;
	}
	
	
}
