package UI;

import javax.swing.*;
import Entidades.Turno;
import Service.*;

public class PantallaTablaTurnos extends AbstractTablaPanel{
	
	private TablaTurnosPanel tablaTurnosPanel;
	private TurnoService service = new TurnoService();
	
	public PantallaTablaTurnos(UIManager manager) {
		super(manager);
		this.opcionesTablaPanel.getLabelBuscar().setText("Buscar por nombre del médico");;
	}
	
	public void setTablaPanel() {
		tablaTurnosPanel = new TablaTurnosPanel(manager);
		tablaPanel = tablaTurnosPanel;
	}
	
	public void ejecutarAccionAgregar() {
		manager.mostrarPanelAgregarTurno();
	}
	
	public void ejecutarAccionBorrar() {
		
		JTable tablaTurnos = tablaTurnosPanel.getTablaTurnos();
		ModeloTablaTurnos modelo = tablaTurnosPanel.getModelo();
		
		int filaSeleccionada = tablaTurnos.getSelectedRow();
		
		if(filaSeleccionada != -1){
			int idSeleccionado = (Integer)tablaTurnos.getValueAt(filaSeleccionada, 0);
			modelo.getTurnos().remove(filaSeleccionada);
			modelo.filtrarTablaPorNombre("");
			try {
				service.eliminarTurno(idSeleccionado);
			}catch(BorrarException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			modelo.fireTableDataChanged();
		}
	}
	
	public void ejecutarAccionBuscar() {
		
		String textoIngresado = opcionesTablaPanel.getTextoBusqueda().getText();
		tablaTurnosPanel.getModelo().filtrarTablaPorNombre(textoIngresado);
	}
	
	public void ejecutarAccionEditar() {
		
		int filaSeleccionada = tablaTurnosPanel.getTablaTurnos().getSelectedRow();
		
		if(filaSeleccionada != -1) {
			Turno turnoSeleccionado = tablaTurnosPanel.getModelo().getTurnos().get(filaSeleccionada);
			manager.getPanelListaPacientes().setTurnoSeleccionado(turnoSeleccionado);
			manager.mostrarPanelEditarTurno(turnoSeleccionado);
		}
	}

	public TablaTurnosPanel getTablaTurnosPanel() {
		return tablaTurnosPanel;
	}

	public void setTablaTurnosPanel(TablaTurnosPanel tablaTurnosPanel) {
		this.tablaTurnosPanel = tablaTurnosPanel;
	}

	public TurnoService getService() {
		return service;
	}

	public void setService(TurnoService service) {
		this.service = service;
	}
	
	
}
