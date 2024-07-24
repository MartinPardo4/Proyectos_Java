package UI;

import javax.swing.*;
import Entidades.*;
import Service.*;


public class EditarMedicoPanel extends AbstractFormularioUsuarioPanel{
	
	private Medico medicoSeleccionado;
	private CamposFormularioMedicoPanel camposMedicoPanel;
	
	
	public EditarMedicoPanel(UIManager manager) {
		super(manager);
	}
	
	public void setCamposPanel() {
		this.camposMedicoPanel = new CamposFormularioMedicoPanel(manager);
		this.camposPanel = this.camposMedicoPanel;
	}
	
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
			
			if (medicoSeleccionado != null) {
				
				//Actualizar en la base de datos
				service.editarMedico(medico, medicoSeleccionado.getDNI());
				
				//Actualizar en la tabla
				actualizarMedico(medico, medicoSeleccionado);
			}
		
			
			this.camposMedicoPanel.getTextoNombre().setText("");
			this.camposMedicoPanel.getTextoApellido().setText("");
			this.camposMedicoPanel.getTextoDNI().setText("");
			this.camposMedicoPanel.getTextoCobro().setText("");
			
			modelo.fireTableDataChanged();
			
			manager.mostrarPantallaTablaMedicos();
			
		}catch(CampoNuloException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}catch(EnteroNoValidoException exc) {
			JOptionPane.showMessageDialog(this, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}catch(EditarException ax) {
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
	
		
	private void actualizarMedico(Medico medicoActualizado, Medico medicoSeleccionado) {
		ModeloTablaMedicos modelo = manager.getPantallaTablaMedicos().getTablaMedicosPanel().getModelo();
		
		for( int i=0; i < modelo.getMedicos().size(); i++) {
			if(modelo.getMedicos().get(i).getDNI() == medicoSeleccionado.getDNI()) {
				modelo.getMedicos().set(i, medicoActualizado);
				modelo.getFiltro().set(i, medicoActualizado);
				modelo.fireTableDataChanged();
				break;
			}
		}
	}
	

	public Medico getMedicoSeleccionado() {
		return medicoSeleccionado;
	}

	public void setMedicoSeleccionado(Medico medicoSeleccionado) {
		this.medicoSeleccionado = medicoSeleccionado;
	}

	public CamposFormularioMedicoPanel getCamposMedicoPanel() {
		return camposMedicoPanel;
	}

	public void setCamposMedicoPanel(CamposFormularioMedicoPanel camposMedicoPanel) {
		this.camposMedicoPanel = camposMedicoPanel;
	}
	
}
