package UI;

import java.awt.*;
import javax.swing.*;

public class CamposFormularioMedicoPanel extends CamposPanel{
	
	private JLabel labelNombre;
	private JLabel labelApellido;
	private JLabel labelDNI;
	private JLabel labelCobro;
	private JTextField textoNombre;
	private JTextField textoApellido;
	private JTextField textoDNI;
	private JTextField textoCobro;
	
	public CamposFormularioMedicoPanel(UIManager manager) {
		super(manager);
	}
	
	public void armarFormulario() {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		labelNombre = new JLabel("Nombre");
		textoNombre = new JTextField(30);
		
		labelApellido = new JLabel("Apellido");
		textoApellido = new JTextField(30);
		
		labelDNI = new JLabel("DNI");
		textoDNI = new JTextField(30);
		
		labelCobro = new JLabel("Cobro por consulta");
		textoCobro = new JTextField(30);
		
		gbc.gridy = 0;
		gbc.gridx = 0;
		this.add(labelNombre, gbc);
		gbc.gridy = 0;
		gbc.gridx = 1;
		this.add(textoNombre, gbc);
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(labelApellido, gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(textoApellido, gbc);
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(labelDNI, gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(textoDNI, gbc);
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(labelCobro, gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(textoCobro, gbc);
	}


	public JLabel getLabelNombre() {
		return labelNombre;
	}

	public void setLabelNombre(JLabel labelNombre) {
		this.labelNombre = labelNombre;
	}

	public JLabel getLabelApellido() {
		return labelApellido;
	}

	public void setLabelApellido(JLabel labelApellido) {
		this.labelApellido = labelApellido;
	}

	public JLabel getLabelDNI() {
		return labelDNI;
	}

	public void setLabelDNI(JLabel labelDNI) {
		this.labelDNI = labelDNI;
	}

	public JLabel getLabelCobro() {
		return labelCobro;
	}

	public void setLabelCobro(JLabel labelCobro) {
		this.labelCobro = labelCobro;
	}

	public JTextField getTextoNombre() {
		return textoNombre;
	}

	public void setTextoNombre(JTextField textoNombre) {
		this.textoNombre = textoNombre;
	}

	public JTextField getTextoApellido() {
		return textoApellido;
	}

	public void setTextoApellido(JTextField textoApellido) {
		this.textoApellido = textoApellido;
	}

	public JTextField getTextoDNI() {
		return textoDNI;
	}

	public void setTextoDNI(JTextField textoDNI) {
		this.textoDNI = textoDNI;
	}

	public JTextField getTextoCobro() {
		return textoCobro;
	}

	public void setTextoCobro(JTextField textoCobro) {
		this.textoCobro = textoCobro;
	}
	
}
