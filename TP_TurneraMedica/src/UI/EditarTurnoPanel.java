package UI;

import java.text.ParseException;

import javax.swing.*;
import Entidades.*;
import Service.*;

public class EditarTurnoPanel extends AbstractFormularioUsuarioPanel{
	
	private Turno turnoSeleccionado;
	private CampoFechaTurnoPanel camposTurnoPanel;
	
	
	public EditarTurnoPanel(UIManager manager) {
		super(manager);
	}
	
	public void setCamposPanel() {
		this.camposTurnoPanel = new CampoFechaTurnoPanel(manager);
		this.camposPanel = this.camposTurnoPanel;
	}
	
	public void ejecutarAccionAceptar() {
		
		String fechaIngresada = this.camposTurnoPanel.getTextoFecha().getText();
	
		
		try {
			
			manager.validarCampoNoNulo(fechaIngresada, "fecha y hora");
			manager.validarFormato(fechaIngresada, "dd/MM/yyyy HH:mm");
			
			this.camposTurnoPanel.getTextoFecha().setText("");
			
			manager.mostrarPanelListaMedicos(fechaIngresada);
			
		}catch(CampoNuloException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ParseException px) {
			JOptionPane.showMessageDialog(this, "El formato de la fecha no es válido, el formato debe ser: dd/MM/yyyy HH:mm", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void ejecutarAccionCancelar() {
			
		this.camposTurnoPanel.getTextoFecha().setText("");
		
		manager.mostrarPantallaTablaTurnos();
	}
	

	public Turno getTurnoSeleccionado() {
		return turnoSeleccionado;
	}

	public void setTurnoSeleccionado(Turno turnoSeleccionado) {
		this.turnoSeleccionado = turnoSeleccionado;
	}

	public CampoFechaTurnoPanel getCamposTurnoPanel() {
		return camposTurnoPanel;
	}

	public void setCamposTurnoPanel(CampoFechaTurnoPanel camposTurnoPanel) {
		this.camposTurnoPanel = camposTurnoPanel;
	}
	
	

}
