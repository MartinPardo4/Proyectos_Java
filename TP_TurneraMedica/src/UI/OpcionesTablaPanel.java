package UI;

import javax.swing.*;

public class OpcionesTablaPanel extends JPanel{
	
	private UIManager manager;
	private JPanel panelBusqueda;
	private JPanel panelBotones;
	private JButton botonAgregar;
	private JButton botonBorrar;
	private JButton botonBuscar;
	private JButton botonEditar;
	private JButton botonVolver;
	private JTextField textoBusqueda;
	private JLabel labelBuscar;
	
	public OpcionesTablaPanel(UIManager manager) {
		this.manager = manager;
		crearOpcionesTablaPanel();
	}
	
	public void crearOpcionesTablaPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		labelBuscar = new JLabel("Filtrar por nombre");
		textoBusqueda = new JTextField();
		
		botonAgregar = new JButton("Agregar");
		botonBorrar = new JButton("Borrar");
		botonBuscar = new JButton("Filtrar");
		botonEditar = new JButton("Editar");
		botonVolver = new JButton("Volver");
		
		panelBusqueda = new JPanel();
		panelBusqueda.setLayout(new BoxLayout(panelBusqueda, BoxLayout.Y_AXIS));
		labelBuscar.setAlignmentX(CENTER_ALIGNMENT);
		panelBusqueda.add(labelBuscar);
		panelBusqueda.add(textoBusqueda);
		botonBuscar.setAlignmentX(CENTER_ALIGNMENT);
		panelBusqueda.add(botonBuscar);
		
		
		panelBotones = new JPanel();
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
		
		botonAgregar.setAlignmentX(CENTER_ALIGNMENT);
		panelBotones.add(botonAgregar);
		panelBotones.add(Box.createVerticalStrut(10));
		botonBorrar.setAlignmentX(CENTER_ALIGNMENT);
		panelBotones.add(botonBorrar);
		panelBotones.add(Box.createVerticalStrut(10));
		botonEditar.setAlignmentX(CENTER_ALIGNMENT);
		panelBotones.add(botonEditar);
		panelBotones.add(Box.createVerticalStrut(10));
		botonVolver.setAlignmentX(CENTER_ALIGNMENT);
		panelBotones.add(botonVolver);
		
		this.add(panelBusqueda);
		this.add(Box.createVerticalStrut(50));
		this.add(panelBotones);		

	}

	public UIManager getManager() {
		return manager;
	}

	public void setManager(UIManager manager) {
		this.manager = manager;
	}

	public JPanel getPanelBusqueda() {
		return panelBusqueda;
	}

	public void setPanelBusqueda(JPanel panelBusqueda) {
		this.panelBusqueda = panelBusqueda;
	}

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

	public JButton getBotonAgregar() {
		return botonAgregar;
	}

	public void setBotonAgregar(JButton botonAgregar) {
		this.botonAgregar = botonAgregar;
	}

	public JButton getBotonBorrar() {
		return botonBorrar;
	}

	public void setBotonBorrar(JButton botonBorrar) {
		this.botonBorrar = botonBorrar;
	}

	public JButton getBotonBuscar() {
		return botonBuscar;
	}

	public void setBotonBuscar(JButton botonBuscar) {
		this.botonBuscar = botonBuscar;
	}

	public JButton getBotonEditar() {
		return botonEditar;
	}

	public void setBotonEditar(JButton botonEditar) {
		this.botonEditar = botonEditar;
	}

	public JTextField getTextoBusqueda() {
		return textoBusqueda;
	}

	public void setTextoBusqueda(JTextField textoBusqueda) {
		this.textoBusqueda = textoBusqueda;
	}

	public JLabel getLabelBuscar() {
		return labelBuscar;
	}

	public void setLabelBuscar(JLabel labelBuscar) {
		this.labelBuscar = labelBuscar;
	}

	public JButton getBotonVolver() {
		return botonVolver;
	}

	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
	}
	
}
