package UI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CampoFechaTurnoPanel extends CamposPanel{
	
	private JLabel labelFecha;
	private JTextField textoFecha;
	
	public CampoFechaTurnoPanel(UIManager manager) {
		super(manager);
	}
	
	public void armarFormulario() {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		labelFecha = new JLabel("Fecha y hora");
		textoFecha = new JTextField(30);
		
		
		gbc.gridy = 0;
		gbc.gridx = 0;
		this.add(labelFecha, gbc);
		gbc.gridy = 0;
		gbc.gridx = 1;
		this.add(textoFecha, gbc);

	}

	public JLabel getLabelFecha() {
		return labelFecha;
	}

	public void setLabelFecha(JLabel labelFecha) {
		this.labelFecha = labelFecha;
	}


	public JTextField getTextoFecha() {
		return textoFecha;
	}

	public void setTextoFecha(JTextField textoFecha) {
		this.textoFecha = textoFecha;
	}


	
	
}
