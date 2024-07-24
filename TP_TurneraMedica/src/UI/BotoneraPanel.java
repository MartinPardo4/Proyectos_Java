package UI;
import java.awt.FlowLayout;

import javax.swing.*;

import UI.UIManager;

public class BotoneraPanel extends JPanel{

	private UIManager manager;
	private JButton botonAceptar;
	private JButton botonCancelar;
	
	public BotoneraPanel(UIManager manager) {
		this.manager = manager;
		armarBotoneraPanel();
	}
	
	public void armarBotoneraPanel() {
		
		this.setLayout(new FlowLayout());
		
		botonAceptar = new JButton();
		botonCancelar = new JButton();
		
		this.add(botonAceptar);
		this.add(botonCancelar);
	}
	
	public UIManager getManager() {
		return manager;
	}

	public void setManager(UIManager manager) {
		this.manager = manager;
	}

	public JButton getBotonAceptar() {
		return botonAceptar;
	}

	public void setBotonAceptar(JButton botonAceptar) {
		this.botonAceptar = botonAceptar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public void setBotonCancelar(JButton botonCancelar) {
		this.botonCancelar = botonCancelar;
	}
	
		
}
