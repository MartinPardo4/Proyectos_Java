package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;
import Entidades.*;
import Service.*;

public class ListaPacientesPanel extends JPanel implements ActionListener{
	
	private UIManager manager;
	private TablaPacientesPanel tablaPacientesPanel;
	private Turno turnoSeleccionado;
	private String fecha;
	private Medico medico;
	private JPanel panelOpciones;
	private JLabel labelSeleccion;
	private JButton botonAceptar;
	private JButton botonAtras;
	
	public ListaPacientesPanel(UIManager manager) {
		this.manager = manager;
		setTablaPacientesPanel();
		armarLista();
	}
	
	public void armarLista() {
		this.setLayout(new FlowLayout());
		
		panelOpciones = new JPanel();
		panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
		
		labelSeleccion = new JLabel("Seleccione un paciente");
		
		botonAceptar = new JButton("Aceptar");
		botonAtras = new JButton("Atrás");
		
		panelOpciones.add(labelSeleccion);
		panelOpciones.add(botonAceptar);
		panelOpciones.add(botonAtras);
		
		this.add(tablaPacientesPanel);
		this.add(panelOpciones);
		
		botonAceptar.addActionListener(this);
		botonAtras.addActionListener(this);
	}
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == botonAceptar) {
				
				TurnoService turnoService = new TurnoService();
				
				int filaSeleccionada = tablaPacientesPanel.getTablaPacientes().getSelectedRow();
				if(filaSeleccionada != -1) {
					Paciente pacienteSeleccionado = tablaPacientesPanel.getModelo().getPacientes().get(filaSeleccionada);
				
					
					try {
						
						Turno turno = new Turno(fecha, medico, pacienteSeleccionado);
						
						ModeloTablaTurnos modelo = manager.getPantallaTablaTurnos().getTablaTurnosPanel().getModelo();
						
						turnoService.altaTurno(turno);
						if(turnoSeleccionado == null) {
							modelo.getTurnos().add(turno);
						}else {
							actualizarTurno(turno, turnoSeleccionado);
						}
						
						modelo.filtrarTablaPorNombre("");
						modelo.fireTableDataChanged();
						
						manager.mostrarPantallaTablaTurnos();
						
					}catch(AltaException ex) {
						JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}catch(ParseException px) {
						JOptionPane.showMessageDialog(this, "Hubo un error en el formateo", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}else {
				if(e.getSource() == botonAtras) {
					manager.mostrarPanelListaMedicos(fecha);
				}
			}
				
		}
		
		private void actualizarTurno(Turno turnoActualizado, Turno turnoSeleccionado) {
			ModeloTablaTurnos modelo = manager.getPantallaTablaTurnos().getTablaTurnosPanel().getModelo();
			
			for( int i=0; i < modelo.getTurnos().size(); i++) {
				if(modelo.getTurnos().get(i).getID() == turnoSeleccionado.getID()) {
					modelo.getTurnos().set(i, turnoActualizado);
					modelo.getFiltro().set(i, turnoActualizado);
					modelo.fireTableDataChanged();
					break;
				}
			}
		}
	
	
	
	
	public UIManager getManager() {
		return manager;
	}

	public void setManager(UIManager manager) {
		this.manager = manager;
	}

	public JPanel getPanelOpciones() {
		return panelOpciones;
	}

	public void setPanelOpciones(JPanel panelOpciones) {
		this.panelOpciones = panelOpciones;
	}

	public JLabel getLabelSeleccion() {
		return labelSeleccion;
	}

	public void setLabelSeleccion(JLabel labelSeleccion) {
		this.labelSeleccion = labelSeleccion;
	}

	public JButton getBotonAceptar() {
		return botonAceptar;
	}

	public void setBotonAceptar(JButton botonAceptar) {
		this.botonAceptar = botonAceptar;
	}

	public JButton getBotonAtras() {
		return botonAtras;
	}

	public void setBotonAtras(JButton botonAtras) {
		this.botonAtras = botonAtras;
	}

	public TablaPacientesPanel getTablaPacientesPanel() {
		return tablaPacientesPanel;
	}

	public void setTablaPacientesPanel() {
		this.tablaPacientesPanel = new TablaPacientesPanel(this.manager);
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Turno getTurnoSeleccionado() {
		return turnoSeleccionado;
	}

	public void setTurnoSeleccionado(Turno turnoSeleccionado) {
		this.turnoSeleccionado = turnoSeleccionado;
	}
	
}
