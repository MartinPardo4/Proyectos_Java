package UI;

import java.text.ParseException;
import javax.swing.*;
import Entidades.*;
import Service.*;

public class AgregarTurnoPanel extends AbstractFormularioUsuarioPanel{
	
private CampoFechaTurnoPanel camposTurnoPanel;
	
	public AgregarTurnoPanel(UIManager manager) {
		super(manager);      
	}
	
	@Override
	public void setCamposPanel() {
		this.camposTurnoPanel = new CampoFechaTurnoPanel(manager);
		this.camposPanel = this.camposTurnoPanel;
	}
	
	@Override
	public void ejecutarAccionAceptar() {
		
		
		String fechaIngresada = this.camposTurnoPanel.getTextoFecha().getText();
		
		try {
			
			manager.validarCampoNoNulo(fechaIngresada, "fecha");
			manager.validarFormato(fechaIngresada, "dd/MM/yyyy HH:mm");
				
			this.camposTurnoPanel.getTextoFecha().setText("");

			manager.mostrarPanelListaMedicos(fechaIngresada);
			
		}catch (ParseException px) {
			JOptionPane.showMessageDialog(this, "El formato de la fecha no es válido, el formato debe ser: dd/MM/yyyy HH:mm", "Error", JOptionPane.ERROR_MESSAGE);
		}catch(CampoNuloException nx) {
			JOptionPane.showMessageDialog(this, nx.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void ejecutarAccionCancelar() {
		
		this.camposTurnoPanel.getTextoFecha().setText("");
		
		manager.mostrarPantallaTablaTurnos();
	}

	public CampoFechaTurnoPanel getCamposTurnoPanel() {
		return camposTurnoPanel;
	}

	public void setCamposTurnoPanel(CampoFechaTurnoPanel camposTurnoPanel) {
		this.camposTurnoPanel = camposTurnoPanel;
	}
	
	
	
}
