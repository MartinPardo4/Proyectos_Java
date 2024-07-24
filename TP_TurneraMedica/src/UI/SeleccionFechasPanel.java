package UI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;

import Entidades.*;

public class SeleccionFechasPanel extends AbstractFormularioUsuarioPanel{
	
	private CamposSeleccionFechasPanel campoSeleccionFechasPanel;
	
	public SeleccionFechasPanel(UIManager manager) {
		super(manager);
	}
	
	public void setCamposPanel() {
		campoSeleccionFechasPanel = new CamposSeleccionFechasPanel(manager);
		camposPanel = campoSeleccionFechasPanel;
	}
	
	public void ejecutarAccionAceptar() {
		
		Medico medico = (Medico)manager.getPanelLogIn().getUser();
		List<Turno> turnos = manager.getPantallaTablaTurnos().getTablaTurnosPanel().getModelo().getTurnos();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String fechaInicial = campoSeleccionFechasPanel.getTextoFechaInicial().getText();
		String fechaFinal = campoSeleccionFechasPanel.getTextoFechaFinal().getText();
		
		try {
			int cont = 0;
			int recaudacion = 0;
			Date fechaInicialForm = sdf.parse(fechaInicial);
			Date fechaFinalForm = sdf.parse(fechaFinal);
		
			for(Turno turno : turnos){
				int DNI = turno.getMedico().getDNI();
				Date fechaTurno = turno.getFechaDate();
				if(fechaTurno.after(fechaInicialForm) && fechaTurno.before(fechaFinalForm) && DNI == medico.getDNI()){
					cont++;
					recaudacion += medico.getCobro(); 
				}
			}System.out.println(recaudacion);
			manager.mostrarPanelReporte(cont, recaudacion);
		}catch(ParseException px) {
			JOptionPane.showMessageDialog(this, "Hubo un error de formateo", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void ejecutarAccionCancelar() {
		campoSeleccionFechasPanel.getTextoFechaInicial().setText("");
		campoSeleccionFechasPanel.getTextoFechaFinal().setText("");
		manager.mostrarPanelHome(); 
	}

	public CamposSeleccionFechasPanel getCampoSeleccionFechasPanel() {
		return campoSeleccionFechasPanel;
	}

	public void setCampoSeleccionFechasPanel(CamposSeleccionFechasPanel campoSeleccionFechasPanel) {
		this.campoSeleccionFechasPanel = campoSeleccionFechasPanel;
	}
	
}
