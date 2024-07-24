package UI;

import java.awt.*;
import javax.swing.*;
import Entidades.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Service.*;

public class AgregarMedicoPanel extends AbstractFormularioUsuarioPanel{
	
	private CamposFormularioMedicoPanel camposMedicoPanel;
	
	public AgregarMedicoPanel(UIManager manager) {
		super(manager);      
	}
	
	@Override
	public void setCamposPanel() {
		this.camposMedicoPanel = new CamposFormularioMedicoPanel(manager);
		this.camposPanel = this.camposMedicoPanel;
	}
	
	@Override
	public void ejecutarAccionAceptar() {
		String nombreIngresado = this.camposMedicoPanel.getTextoNombre().getText();
		String apellidoIngresado = this.camposMedicoPanel.getTextoApellido().getText();
		String DNIIngresado = this.camposMedicoPanel.getTextoDNI().getText();
		String cobroIngresado = this.camposMedicoPanel.getTextoCobro().getText();
	
		
		try {
			
			manager.validarCampoNoNulo(nombreIngresado, "nombre");
			
			manager.validarCampoNoNulo(apellidoIngresado, "apellido");
			
			manager.validarCampoNoNulo(DNIIngresado, "DNI");
			int dni = manager.validarDNI(DNIIngresado);
			
			manager.validarCampoNoNulo(cobroIngresado, "cobro");
			int cobro = manager.validarEntero(cobroIngresado, "cobro");
	
			Medico medico = new Medico(nombreIngresado, apellidoIngresado, dni, cobro);
			
			MedicoService service = new MedicoService();
			ModeloTablaMedicos modelo = manager.getPantallaTablaMedicos().getTablaMedicosPanel().getModelo();
			
			service.altaMedico(medico);
			modelo.getMedicos().add(medico);
			modelo.filtrarTabla("");
			modelo.fireTableDataChanged();
			
			this.camposMedicoPanel.getTextoNombre().setText("");
			this.camposMedicoPanel.getTextoApellido().setText("");
			this.camposMedicoPanel.getTextoDNI().setText("");
			this.camposMedicoPanel.getTextoCobro().setText("");
			
			manager.mostrarPantallaTablaMedicos();
			
		}catch(CampoNuloException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}catch(EnteroNoValidoException exc) {
			JOptionPane.showMessageDialog(this, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}catch(AltaException ax) {
			JOptionPane.showMessageDialog(this, ax.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (LongitudException lx) {
			JOptionPane.showMessageDialog(this, lx.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void ejecutarAccionCancelar() {
		
		this.camposMedicoPanel.getTextoNombre().setText("");
		this.camposMedicoPanel.getTextoApellido().setText("");
		this.camposMedicoPanel.getTextoDNI().setText("");
		this.camposMedicoPanel.getTextoCobro().setText("");
		
		manager.mostrarPantallaTablaMedicos();
	}

	public CamposFormularioMedicoPanel getCamposMedicoPanel() {
		return camposMedicoPanel;
	}

	public void setCamposMedicoPanel(CamposFormularioMedicoPanel camposMedicoPanel) {
		this.camposMedicoPanel = camposMedicoPanel;
	}
	
	
}