package com.example.Calculadora_Java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelTexto extends JPanel{
	
	private JLabel texto;
	
	public PanelTexto() {
		armarPanelTexto();
	}
	
	public void armarPanelTexto() {
		
		this.setLayout(new FlowLayout());
		this.setBackground(Color.BLACK);
	    this.setPreferredSize(new Dimension(300, 40));
	    
		texto = new JLabel("");
		//texto.setBorder(new LineBorder(Color.BLACK));
		texto.setSize(new Dimension(300, 35));
		texto.setFont(new Font("Arial", Font.PLAIN, 24));
		texto.setForeground(Color.WHITE);
		texto.setHorizontalAlignment(SwingConstants.RIGHT);
		this.add(texto);
	}

	public JLabel getTexto() {
		return texto;
	}

	public void setTexto(JLabel texto) {
		this.texto = texto;
	}
	
	
}
