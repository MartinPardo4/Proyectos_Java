package UI;

import javax.swing.*;

import Entidades.Medico;
import Service.*;

public class PantallaTablaMedicos extends AbstractTablaPanel{
	
	private TablaMedicosPanel tablaMedicosPanel;
	private MedicoService service = new MedicoService();
	
	public PantallaTablaMedicos(UIManager manager) {
		super(manager);
	}
	
	public void setTablaPanel() {
		this.tablaMedicosPanel = new TablaMedicosPanel(manager);
		tablaPanel = tablaMedicosPanel;
	}
	
	public void ejecutarAccionAgregar() {
		manager.mostrarPanelAgregarMedico();
	}
	
	public void ejecutarAccionBorrar() {
		
		JTable tablaMedicos = tablaMedicosPanel.getTablaMedicos();
		ModeloTablaMedicos modelo = tablaMedicosPanel.getModelo();
		
		int filaSeleccionada = tablaMedicos.getSelectedRow();
		
		if(filaSeleccionada != -1){
			int DNISeleccionado = (Integer)tablaMedicos.getValueAt(filaSeleccionada, 2);
			modelo.getMedicos().remove(filaSeleccionada);
			modelo.filtrarTabla("");
			try {
				service.eliminarMedico(DNISeleccionado);
			}catch(BorrarException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			modelo.fireTableDataChanged();
		}
	}
	
	public void ejecutarAccionBuscar() {
		
		String textoIngresado = opcionesTablaPanel.getTextoBusqueda().getText();
		tablaMedicosPanel.getModelo().filtrarTabla(textoIngresado);
	}
	
	public void ejecutarAccionEditar() {
		
		int filaSeleccionada = tablaMedicosPanel.getTablaMedicos().getSelectedRow();
		
		if(filaSeleccionada != -1) {
			Medico medicoSeleccionado = tablaMedicosPanel.getModelo().getMedicos().get(filaSeleccionada);
			manager.getPanelEditarMedico().setMedicoSeleccionado(medicoSeleccionado);
			manager.mostrarPanelEditarMedico(medicoSeleccionado);
		}
	}

	public TablaMedicosPanel getTablaMedicosPanel() {
		return tablaMedicosPanel;
	}

	public void setTablaMedicosPanel(TablaMedicosPanel tablaMedicosPanel) {
		this.tablaMedicosPanel = tablaMedicosPanel;
	}

	public MedicoService getService() {
		return service;
	}

	public void setService(MedicoService service) {
		this.service = service;
	}
	
	
	
}
