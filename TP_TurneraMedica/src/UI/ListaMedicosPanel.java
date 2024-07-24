package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Entidades.*;
import javax.swing.*;

public class ListaMedicosPanel extends JPanel implements ActionListener{
	
	private UIManager manager;
	private TablaMedicosPanel tablaMedicosPanel;
	private String fecha;
	private JPanel panelOpciones;
	private JLabel labelSeleccion;
	private JButton botonAceptar;
	private JButton botonAtras;
	
	
	public ListaMedicosPanel(UIManager manager) {
		this.manager = manager;
		setTablaMedicosPanel();
		armarLista();
	}
	
	public void armarLista() {
		this.setLayout(new FlowLayout());
		
		panelOpciones = new JPanel();
		panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
		
		labelSeleccion = new JLabel("Seleccione un médico");
		
		botonAceptar = new JButton("Aceptar");
		botonAtras = new JButton("Atrás");
		
		panelOpciones.add(labelSeleccion);
		panelOpciones.add(botonAceptar);
		panelOpciones.add(botonAtras);
		
		this.add(tablaMedicosPanel);
		this.add(panelOpciones);
		
		botonAceptar.addActionListener(this);
		botonAtras.addActionListener(this);
	}
					
	public void actionPerformed(ActionEvent e) {
			
		if(e.getSource() == botonAceptar) {
			int filaSeleccionada = tablaMedicosPanel.getTablaMedicos().getSelectedRow();
			try {
				if(filaSeleccionada != -1) {
					Medico medicoSeleccionado = tablaMedicosPanel.getModelo().getMedicos().get(filaSeleccionada);
					manager.validarHorario(fecha, medicoSeleccionado);
					manager.mostrarPanelListaPacientes(fecha, medicoSeleccionado);
				}
			}catch(HorarioException hx) {
					JOptionPane.showMessageDialog(this, hx.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			if(e.getSource() == botonAtras) {
				manager.mostrarPanelAgregarTurno();
			}
		}
		
	}
	
	public UIManager getManager() {
		return manager;
	}

	public void setManager(UIManager manager) {
		this.manager = manager;
	}

	public TablaMedicosPanel getTablaMedicosPanel() {
		return tablaMedicosPanel;
	}

	public void setTablaMedicosPanel() {
		this.tablaMedicosPanel = new TablaMedicosPanel(this.manager);
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
}
