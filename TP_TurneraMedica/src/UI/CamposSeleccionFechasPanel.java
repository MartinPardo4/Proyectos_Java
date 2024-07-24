package UI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class CamposSeleccionFechasPanel extends CamposPanel{
	
	private JLabel labelFechaInicial;
	private JTextField textoFechaInicial;
	private JLabel labelFechaFinal;
	private JTextField textoFechaFinal;
	
	public CamposSeleccionFechasPanel(UIManager manager) {
		super(manager);
	}
	
	public void armarFormulario() {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		labelFechaInicial = new JLabel("Fecha inicial");
		textoFechaInicial = new JTextField(30);
		labelFechaFinal = new JLabel("Fecha final");
		textoFechaFinal = new JTextField(30);
		
		
		gbc.gridy = 0;
		gbc.gridx = 0;
		this.add(labelFechaInicial, gbc);
		gbc.gridy = 0;
		gbc.gridx = 1;
		this.add(textoFechaInicial, gbc);
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(labelFechaFinal, gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(textoFechaFinal, gbc);

	}

	public JLabel getLabelFechaInicial() {
		return labelFechaInicial;
	}

	public void setLabelFechaInicial(JLabel labelFechaInicial) {
		this.labelFechaInicial = labelFechaInicial;
	}

	public JTextField getTextoFechaInicial() {
		return textoFechaInicial;
	}

	public void setTextoFechaInicial(JTextField textoFechaInicial) {
		this.textoFechaInicial = textoFechaInicial;
	}

	public JLabel getLabelFechaFinal() {
		return labelFechaFinal;
	}

	public void setLabelFechaFinal(JLabel labelFechaFinal) {
		this.labelFechaFinal = labelFechaFinal;
	}

	public JTextField getTextoFechaFinal() {
		return textoFechaFinal;
	}

	public void setTextoFechaFinal(JTextField textoFechaFinal) {
		this.textoFechaFinal = textoFechaFinal;
	}
	
	
}
