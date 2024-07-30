package com.example.Calculadora_Java;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class PanelBotonera extends JPanel{
	
	private JLabel texto;
	
	
	public PanelBotonera(JLabel texto) {
		this.texto = texto;
		armarPanelBotonera();
	}
	
	public void armarPanelBotonera() {
		
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.GRAY);
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		JButton bParentesis1 = new JButton("(");
		JButton bParentesis2 = new JButton(")");
		JButton bPunto = new JButton(".");
		JButton bReset = new JButton("AC");
		JButton bUno = new JButton("1");
		JButton bDos = new JButton("2");
		JButton bTres = new JButton("3");
		JButton bCuatro = new JButton("4");
		JButton bCinco = new JButton("5");
		JButton bSeis = new JButton("6");
		JButton bSiete = new JButton("7");
		JButton bOcho = new JButton("8");
		JButton bNueve = new JButton("9");
		JButton bCero = new JButton("0");
		JButton bDivision = new JButton("/");
		JButton bMultiplicacion = new JButton("x");
		JButton bSuma = new JButton("+");
		JButton bResta = new JButton("-");
		JButton bIgual = new JButton("=");
		JButton bPotencia = new JButton("^");
		JButton bRaiz = new JButton("√");
		
		bParentesis1.addActionListener(e -> texto.setText(texto.getText() + "("));
		bParentesis2.addActionListener(e -> texto.setText(texto.getText() + ")"));
		bPunto.addActionListener(e -> texto.setText(texto.getText() + "."));
		bReset.addActionListener(e -> texto.setText(""));
		bUno.addActionListener(e -> texto.setText(texto.getText() + "1"));
		bDos.addActionListener(e -> texto.setText(texto.getText() + "2"));
		bTres.addActionListener(e -> texto.setText(texto.getText() + "3"));
		bCuatro.addActionListener(e -> texto.setText(texto.getText() + "4"));
		bCinco.addActionListener(e -> texto.setText(texto.getText() + "5"));
		bSeis.addActionListener(e -> texto.setText(texto.getText() + "6"));
		bSiete.addActionListener(e -> texto.setText(texto.getText() + "7"));
		bOcho.addActionListener(e -> texto.setText(texto.getText() + "8"));
		bNueve.addActionListener(e -> texto.setText(texto.getText() + "9"));
		bCero.addActionListener(e -> texto.setText(texto.getText() + "0"));
		bDivision.addActionListener(e -> texto.setText(texto.getText() + "/"));
		bMultiplicacion.addActionListener(e -> texto.setText(texto.getText() + "*"));
		bSuma.addActionListener(e -> texto.setText(texto.getText() + "+"));
		bResta.addActionListener(e -> texto.setText(texto.getText() + "-"));
		bPotencia.addActionListener(e -> texto.setText(texto.getText() + "^"));
		bRaiz.addActionListener(e -> texto.setText("sqrt(" + texto.getText() + ")"));
		
		bIgual.addActionListener(e -> texto.setText(calcular(texto.getText())));
		
		
		
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bParentesis1, gbc);
		
		gbc.gridy = 0;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bParentesis2, gbc);
		
		gbc.gridy = 0;
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bPunto, gbc);
		
		gbc.gridy = 0;
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bReset, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bUno, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bDos, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bTres, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bDivision, gbc);
		
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bCuatro, gbc);
		
		gbc.gridy = 2;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bCinco, gbc);
		
		gbc.gridy = 2;
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bSeis, gbc);
		
		gbc.gridy = 2;
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bMultiplicacion, gbc);
		
		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bSiete, gbc);
		
		gbc.gridy = 3;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bOcho, gbc);
		
		gbc.gridy = 3;
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bNueve, gbc);
		
		gbc.gridy = 3;
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bSuma, gbc);
	
		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bCero, gbc);
		
		gbc.gridy = 4;
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bResta, gbc);
		
		gbc.gridy = 4;
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bIgual, gbc);
		
		gbc.gridy = 5;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bPotencia, gbc);
		
		gbc.gridy = 5;
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(bRaiz, gbc);
		
	}
	
	public String calcular(String expresion) {
		
		String resultadoStr;
		
		try {
			Expression exp = new ExpressionBuilder(expresion).build();
			double resultado = exp.evaluate();
			resultadoStr = String.valueOf(resultado);
			
		}catch(Exception ex) {
			resultadoStr = "Error";
		}
		
		
		return resultadoStr;
	}
}
