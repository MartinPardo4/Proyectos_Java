package com.example.Calculadora_Java;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class InterfazCalculadora {
	public static void main(String [] args) {
		

		//UIManager.put("Button.border", new BorderUIResource(new LineBorder(Color.BLACK)));
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(350, 400));
		frame.setResizable(true);
		
		JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new BorderLayout());
        outerPanel.setBackground(new Color(200, 200, 200));

        // Create rigid areas for the sides
        outerPanel.add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.WEST);
        outerPanel.add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.EAST);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		outerPanel.add(panel, BorderLayout.CENTER);
		
		frame.add(outerPanel);
		
		
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		PanelTexto panelTexto = new PanelTexto();
		panel.add(panelTexto);
		
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		PanelBotonera panelBotonera = new PanelBotonera(panelTexto.getTexto());
		panel.add(panelBotonera);
		
		
	
		//frame.pack();
		frame.setVisible(true);
	
	}
	
	
}

