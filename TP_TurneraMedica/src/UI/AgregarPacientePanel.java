package UI;

import javax.swing.*;
import Entidades.*;
import Service.*;

public class AgregarPacientePanel extends AbstractFormularioUsuarioPanel{
	
	private CamposFormularioPacientePanel camposPacientePanel;
	
	public AgregarPacientePanel(UIManager manager) {
		super(manager);      
	}
	
	@Override
	public void setCamposPanel() {
		this.camposPacientePanel = new CamposFormularioPacientePanel(manager);
		this.camposPanel = this.camposPacientePanel;
	}
	
	@Override
	public void ejecutarAccionAceptar() {
		String nombreIngresado = this.camposPacientePanel.getTextoNombre().getText();
		String apellidoIngresado = this.camposPacientePanel.getTextoApellido().getText();
		String DNIIngresado = this.camposPacientePanel.getTextoDNI().getText();
		String obraIngresada = this.camposPacientePanel.getTextoObraSocial().getText();
	
		
		try {
			
			manager.validarCampoNoNulo(nombreIngresado, "nombre");
			
			manager.validarCampoNoNulo(apellidoIngresado, "apellido");
			
			manager.validarCampoNoNulo(DNIIngresado, "DNI");
			int dni = manager.validarDNI(DNIIngresado);
			
			manager.validarCampoNoNulo(obraIngresada, "obraSocial");
			int numObra = manager.validarEntero(obraIngresada, "número de obra social");
	
			Paciente paciente = new Paciente(nombreIngresado, apellidoIngresado, dni, numObra);
			
			PacienteService service = new PacienteService();
			ModeloTablaPacientes modelo = manager.getPantallaTablaPacientes().getTablaPacientesPanel().getModelo();
			
			service.altaPaciente(paciente);
			modelo.getPacientes().add(paciente);
			modelo.filtrarTabla("");
			modelo.fireTableDataChanged();
			
			this.camposPacientePanel.getTextoNombre().setText("");
			this.camposPacientePanel.getTextoApellido().setText("");
			this.camposPacientePanel.getTextoDNI().setText("");
			this.camposPacientePanel.getTextoObraSocial().setText("");
			
			manager.mostrarPantallaTablaPacientes();
			
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
		
		this.camposPacientePanel.getTextoNombre().setText("");
		this.camposPacientePanel.getTextoApellido().setText("");
		this.camposPacientePanel.getTextoDNI().setText("");
		this.camposPacientePanel.getTextoObraSocial().setText("");
		
		manager.mostrarPantallaTablaPacientes();
	}
	


	public CamposFormularioPacientePanel getCamposPacientePanel() {
		return camposPacientePanel;
	}

	public void setCamposPacientePanel(CamposFormularioPacientePanel camposPacientePanel) {
		this.camposPacientePanel = camposPacientePanel;
	}
	
	
}
