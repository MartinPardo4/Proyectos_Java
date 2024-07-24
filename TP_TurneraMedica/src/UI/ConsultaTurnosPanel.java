package UI;

import java.text.ParseException;
import javax.swing.JOptionPane;
import Entidades.*;

public class ConsultaTurnosPanel extends AbstractFormularioUsuarioPanel{
	
	CampoFechaTurnoPanel campoFechaTurnoPanel;
	
	public ConsultaTurnosPanel(UIManager manager) {
		super(manager);
		campoFechaTurnoPanel.getLabelFecha().setText("Seleccione una fecha");
	}
	
	public void setCamposPanel() {
		this.campoFechaTurnoPanel = new CampoFechaTurnoPanel(manager);
		this.camposPanel = this.campoFechaTurnoPanel;
	}
	
	public void ejecutarAccionAceptar() {
		Usuario user = manager.getPanelLogIn().getUser();
		String fechaIngresada = campoFechaTurnoPanel.getTextoFecha().getText();
		try {
			manager.validarCampoNoNulo(fechaIngresada, "fecha");
			manager.validarFormato(fechaIngresada, "dd/MM/yyyy");
		
			manager.getPantallaTablaTurnos().getTablaTurnosPanel().getModelo().filtrarTablaPorFecha(fechaIngresada,(Medico)user);
			manager.mostrarPanelListaTurnosPorFecha();
		}catch(CampoNuloException nx) {
			JOptionPane.showMessageDialog(this, nx.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}catch(ParseException px) {
			JOptionPane.showMessageDialog(this, "El formato de la fecha no es válido, el formato debe ser: dd/MM/yyyy ", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void ejecutarAccionCancelar() {
		
		campoFechaTurnoPanel.getTextoFecha().setText(" ");
		manager.mostrarPanelHome();
	}

	public CampoFechaTurnoPanel getCampoFechaTurnoPanel() {
		return campoFechaTurnoPanel;
	}

	public void setCampoFechaTurnoPanel(CampoFechaTurnoPanel campoFechaTurnoPanel) {
		this.campoFechaTurnoPanel = campoFechaTurnoPanel;
	}

}
