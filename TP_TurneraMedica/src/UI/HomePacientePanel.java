package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomePacientePanel extends JPanel implements ActionListener{
	private UIManager manager;
	private JLabel labelBienvenida;
	private JButton botonMisTurnos;
	private JButton botonTablas;
	private JPanel panelBotones;
	private JPanel panelAux1;
	private JPanel panelAux2; 
	
	public HomePacientePanel(UIManager manager) {
		this.manager = manager;
		armarHomePacientePanel();
	}
	
	public void armarHomePacientePanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout());
		panelAux1 = new JPanel();
		panelAux2 = new JPanel();
		
		labelBienvenida = new JLabel();
		labelBienvenida.setAlignmentX(CENTER_ALIGNMENT);
		
		botonMisTurnos = new JButton("Mis turnos");
		botonTablas = new JButton("Tablas");
		
		panelAux1.add(botonMisTurnos);
		panelAux2.add(botonTablas);
		
		panelBotones.add(panelAux1);
		panelBotones.add(panelAux2);
		
		this.add(labelBienvenida);
		this.add(panelBotones);
		
		botonMisTurnos.addActionListener(this);
		botonTablas.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonMisTurnos) {
			manager.mostrarPanelConsultaTurnos();
		}
		else {
			if(e.getSource() == botonTablas) {
				manager.mostrarPanelMenuTablas();
			}

		}
	}
}
