package UI;

import javax.swing.*;
import Entidades.*;
import Service.*;


public class EditarPacientePanel extends AbstractFormularioUsuarioPanel{
	
	private Paciente pacienteSeleccionado;
	private CamposFormularioPacientePanel camposPacientePanel;
	
	
	public EditarPacientePanel(UIManager manager) {
		super(manager);
	}
	
	public void setCamposPanel() {
		this.camposPacientePanel = new CamposFormularioPacientePanel(manager);
		this.camposPanel = this.camposPacientePanel;
	}
	
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
			
			manager.validarCampoNoNulo(obraIngresada, "número de obra social");
			int numObra = manager.validarEntero(obraIngresada, "número de obra social");
	
			Paciente paciente = new Paciente(nombreIngresado, apellidoIngresado, dni, numObra);
			
			
			
			PacienteService service = new PacienteService();
			ModeloTablaPacientes modelo = manager.getPantallaTablaPacientes().getTablaPacientesPanel().getModelo();
			
			if (pacienteSeleccionado != null) {
				
				//Actualizar en la base de datos
				service.editarPaciente(paciente, pacienteSeleccionado.getDNI());
				
				//Actualizar en la tabla
				actualizarPaciente(paciente, pacienteSeleccionado);
			}
		
			
			this.camposPacientePanel.getTextoNombre().setText("");
			this.camposPacientePanel.getTextoApellido().setText("");
			this.camposPacientePanel.getTextoDNI().setText("");
			this.camposPacientePanel.getTextoObraSocial().setText("");
			
			modelo.fireTableDataChanged();
			
			manager.mostrarPantallaTablaPacientes();
			
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
			
		this.camposPacientePanel.getTextoNombre().setText("");
		this.camposPacientePanel.getTextoApellido().setText("");
		this.camposPacientePanel.getTextoDNI().setText("");
		this.camposPacientePanel.getTextoObraSocial().setText("");
		
		manager.mostrarPantallaTablaPacientes();
	}
	
		
	private void actualizarPaciente(Paciente pacienteActualizado, Paciente pacienteSeleccionado) {
		ModeloTablaPacientes modelo = manager.getPantallaTablaPacientes().getTablaPacientesPanel().getModelo();
		
		for( int i=0; i < modelo.getPacientes().size(); i++) {
			if(modelo.getPacientes().get(i).getDNI() == pacienteSeleccionado.getDNI()) {
				modelo.getPacientes().set(i, pacienteActualizado);
				modelo.getFiltro().set(i, pacienteActualizado);
				modelo.fireTableDataChanged();
				break;
			}
		}
	}

	public Paciente getPacienteSeleccionado() {
		return pacienteSeleccionado;
	}

	public void setPacienteSeleccionado(Paciente pacienteSeleccionado) {
		this.pacienteSeleccionado = pacienteSeleccionado;
	}

	public CamposFormularioPacientePanel getCamposPacientePanel() {
		return camposPacientePanel;
	}

	public void setCamposPacientePanel(CamposFormularioPacientePanel camposPacientePanel) {
		this.camposPacientePanel = camposPacientePanel;
	}
	
	
}
