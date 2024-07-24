package UI;

import java.awt.FlowLayout;

import javax.swing.*;

public class CamposLogInPanel extends CamposPanel{
	
	private JLabel labelNombre;
	private JLabel labelDNI;
	private JTextField textoNombre;
	private JTextField textoDNI;
	private JPanel panelTexto;
	private JPanel panelLabel;
	
	public CamposLogInPanel(UIManager manager) {
		super(manager);
	}
	
	public void armarFormulario() {
		
		this.setLayout(new FlowLayout());
	
		labelNombre = new JLabel("Nombre de usuario");
		labelDNI = new JLabel("DNI");
		textoNombre = new JTextField(30);
		textoDNI = new JTextField(30);
		
		panelLabel = new JPanel();
		panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.Y_AXIS));
		panelLabel.add(labelNombre);
		panelLabel.add(labelDNI);
		this.add(panelLabel);
		
		panelTexto = new JPanel();
		panelTexto.setLayout(new BoxLayout(panelTexto, BoxLayout.Y_AXIS));
		panelTexto.add(textoNombre);
		panelTexto.add(textoDNI);
		this.add(panelTexto);
	}

	public JLabel getLabelNombre() {
		return labelNombre;
	}

	public void setLabelNombre(JLabel labelNombre) {
		this.labelNombre = labelNombre;
	}

	public JLabel getLabelDNI() {
		return labelDNI;
	}

	public void setLabelDNI(JLabel labelDNI) {
		this.labelDNI = labelDNI;
	}

	public JTextField getTextoNombre() {
		return textoNombre;
	}

	public void setTextoNombre(JTextField textoNombre) {
		this.textoNombre = textoNombre;
	}

	public JTextField getTextoDNI() {
		return textoDNI;
	}

	public void setTextoDNI(JTextField textoDNI) {
		this.textoDNI = textoDNI;
	}

	public JPanel getPanelTexto() {
		return panelTexto;
	}

	public void setPanelTexto(JPanel panelTexto) {
		this.panelTexto = panelTexto;
	}

	public JPanel getPanelLabel() {
		return panelLabel;
	}

	public void setPanelLabel(JPanel panelLabel) {
		this.panelLabel = panelLabel;
	}
	
	
}
