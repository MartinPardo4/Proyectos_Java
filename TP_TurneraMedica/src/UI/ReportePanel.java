package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ReportePanel extends JPanel{
	
	private UIManager manager;
	private JLabel labelCantidadTurnos;
	private JLabel labelRecaudacion;
	private JPanel panelAux1;
	private JPanel panelAux2;
	private JButton botonVolver;
	private int cont;
	private int recaudacion;
	
	public ReportePanel(UIManager manager) {
		this.manager = manager;
	}
	
	public void armarReporte() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		labelCantidadTurnos = new JLabel("La cantidad de turnos en este período es de: "+cont);
		labelRecaudacion = new JLabel("El monto recaudado en este período es de: $"+recaudacion);
		panelAux1 = new JPanel();
		panelAux2 = new JPanel();
		
		botonVolver = new JButton("Volver");
		botonVolver.setAlignmentX(CENTER_ALIGNMENT);
		
		panelAux1.add(labelCantidadTurnos);
		panelAux2.add(labelRecaudacion);
		
		this.add(panelAux1);
		this.add(Box.createVerticalStrut(50));
		this.add(panelAux2);
		this.add(botonVolver);
		
		botonVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager.mostrarPanelSeleccionFechas();
				
			}
		});
	}

	public UIManager getManager() {
		return manager;
	}

	public void setManager(UIManager manager) {
		this.manager = manager;
	}

	public JLabel getLabelCantidadTurnos() {
		return labelCantidadTurnos;
	}

	public void setLabelCantidadTurnos(JLabel labelCantidadTurnos) {
		this.labelCantidadTurnos = labelCantidadTurnos;
	}

	public JLabel getLabelRecaudacion() {
		return labelRecaudacion;
	}

	public void setLabelRecaudacion(JLabel labelRecaudacion) {
		this.labelRecaudacion = labelRecaudacion;
	}

	public JButton getBotonVolver() {
		return botonVolver;
	}

	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public int getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(int recaudacion) {
		this.recaudacion = recaudacion;
	}

	public JPanel getPanelAux1() {
		return panelAux1;
	}

	public void setPanelAux1(JPanel panelAux1) {
		this.panelAux1 = panelAux1;
	}

	public JPanel getPanelAux2() {
		return panelAux2;
	}

	public void setPanelAux2(JPanel panelAux2) {
		this.panelAux2 = panelAux2;
	}
	
	
}
