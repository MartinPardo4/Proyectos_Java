package UI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class HomePanel extends JPanel implements ActionListener{
	
	private UIManager manager;
	private JLabel labelBienvenida;
	private JButton botonMisTurnos;
	private JButton botonTablas;
	private JButton botonRecaudacion;
	private JPanel panelBotones;
	private JPanel panelAux1;
	private JPanel panelAux2; 
	private JPanel panelAux3;
	
	public HomePanel(UIManager manager) {
		this.manager = manager;
		armarHomePanel();
	}
	
	public void armarHomePanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout());
		panelAux1 = new JPanel();
		panelAux2 = new JPanel();
		panelAux3 = new JPanel();
		
		labelBienvenida = new JLabel();
		labelBienvenida.setAlignmentX(CENTER_ALIGNMENT);
		
		botonMisTurnos = new JButton("Mis turnos");
		botonTablas = new JButton("Tablas");
		botonRecaudacion = new JButton("Recaudación");
		
		panelAux1.add(botonMisTurnos);
		panelAux2.add(botonTablas);
		panelAux3.add(botonRecaudacion);
		
		panelBotones.add(panelAux1);
		panelBotones.add(panelAux2);
		panelBotones.add(panelAux3);
		
		this.add(labelBienvenida);
		this.add(panelBotones);
		
		botonMisTurnos.addActionListener(this);
		botonTablas.addActionListener(this);
		botonRecaudacion.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonMisTurnos) {
			manager.mostrarPanelConsultaTurnos();
		}
		else {
			if(e.getSource() == botonTablas) {
				manager.mostrarPanelMenuTablas();
			}
			else {
				if(e.getSource() == botonRecaudacion) {
					manager.mostrarPanelSeleccionFechas();
				}
			}
		}
	}

	public UIManager getManager() {
		return manager;
	}

	public void setManager(UIManager manager) {
		this.manager = manager;
	}

	public JLabel getLabelBienvenida() {
		return labelBienvenida;
	}

	public void setLabelBienvenida(JLabel labelBienvenida) {
		this.labelBienvenida = labelBienvenida;
	}

	public JButton getBotonMisTurnos() {
		return botonMisTurnos;
	}

	public void setBotonMisTurnos(JButton botonMisTurnos) {
		this.botonMisTurnos = botonMisTurnos;
	}

	public JButton getBotonTablas() {
		return botonTablas;
	}

	public void setBotonTablas(JButton botonTablas) {
		this.botonTablas = botonTablas;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
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
