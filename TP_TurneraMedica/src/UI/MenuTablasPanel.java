package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuTablasPanel extends JPanel implements ActionListener{

	private UIManager manager;
	private JButton botonMedicos;
	private JButton botonPacientes;
	private JButton botonTurnos;
	private JButton botonVolver;
	private JPanel panelAux1;
	private JPanel panelAux2;
	private JPanel panelAux3;
	private JPanel panelAux4;
	
	public MenuTablasPanel(UIManager manager) {
		this.manager = manager;
		armarMenuTablas();
	}
	
	public void armarMenuTablas() {
		this.setLayout(new GridLayout(1,2));
		
		botonMedicos = new JButton("Médicos");
		botonPacientes = new JButton("Pacientes");
		botonTurnos = new JButton("Turnos");
		botonVolver = new JButton("Volver");
		
		panelAux1 = new JPanel();
		panelAux2 = new JPanel();
		panelAux3 = new JPanel();
		panelAux4 = new JPanel();
		
		panelAux1.add(botonMedicos);
		panelAux2.add(botonPacientes);
		panelAux3.add(botonTurnos);
		panelAux4.add(botonVolver);
		
		panelAux1.setSize(100,100);
		panelAux2.setSize(100,100);
		panelAux3.setSize(100,100);
		panelAux4.setSize(100,100);
		
		this.add(panelAux1);
		this.add(panelAux2);
		this.add(panelAux3);
		this.add(panelAux4);
		
		botonMedicos.addActionListener(this);
		botonPacientes.addActionListener(this);
		botonTurnos.addActionListener(this);
		botonVolver.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonMedicos) {
			manager.mostrarPantallaTablaMedicos();
		}
		else {
			if(e.getSource() == botonPacientes) {
				manager.mostrarPantallaTablaPacientes();
			}
			else {
				if(e.getSource() == botonTurnos) {
					manager.mostrarPantallaTablaTurnos();
				}
				else {
					if(e.getSource() == botonVolver) {
						manager.mostrarPanelHome();
					}
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

	public JButton getBotonMedicos() {
		return botonMedicos;
	}

	public void setBotonMedicos(JButton botonMedicos) {
		this.botonMedicos = botonMedicos;
	}

	public JButton getBotonPacientes() {
		return botonPacientes;
	}

	public void setBotonPacientes(JButton botonPacientes) {
		this.botonPacientes = botonPacientes;
	}

	public JButton getBotonTurnos() {
		return botonTurnos;
	}

	public void setBotonTurnos(JButton botonTurnos) {
		this.botonTurnos = botonTurnos;
	}

	public JButton getBotonVolver() {
		return botonVolver;
	}

	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
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

	public JPanel getPanelAux3() {
		return panelAux3;
	}

	public void setPanelAux3(JPanel panelAux3) {
		this.panelAux3 = panelAux3;
	}

	public JPanel getPanelAux4() {
		return panelAux4;
	}

	public void setPanelAux4(JPanel panelAux4) {
		this.panelAux4 = panelAux4;
	}
	
}
