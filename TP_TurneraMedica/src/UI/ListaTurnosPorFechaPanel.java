package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ListaTurnosPorFechaPanel extends JPanel{
	
	private UIManager manager;
	private TablaTurnosPanel tablaTurnosPanel;
	private JButton botonAtras;
	private JPanel panelAux;
	
	public ListaTurnosPorFechaPanel(UIManager manager) {
		this.manager = manager;
		setTablaTurnosPanel();
		getTablaTurnosPanel().getModelo().setFiltro(manager.getPantallaTablaTurnos().getTablaTurnosPanel().getModelo().getFiltro());
		armarLista();
	}
	
	public void armarLista() {
		this.setLayout(new FlowLayout());
		
		this.add(tablaTurnosPanel);
		
		panelAux = new JPanel();
		botonAtras = new JButton("Atrás");
		botonAtras.setAlignmentX(CENTER_ALIGNMENT);
		
		panelAux.add(botonAtras);
		
		this.add(panelAux);
		
		botonAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				ModeloTablaTurnos modelo = manager.getPantallaTablaTurnos().getTablaTurnosPanel().getModelo();
				modelo.filtrarTablaPorNombre(" ");
				manager.mostrarPanelConsultaTurnos();
				
			}
		});
		
	}

	public UIManager getManager() {
		return manager;
	}

	public void setManager(UIManager manager) {
		this.manager = manager;
	}

	public TablaTurnosPanel getTablaTurnosPanel() {
		return tablaTurnosPanel;
	}

	public void setTablaTurnosPanel() {
		this.tablaTurnosPanel = new TablaTurnosPanel(manager);
	}

	public JButton getBotonAtras() {
		return botonAtras;
	}

	public void setBotonAtras(JButton botonAtras) {
		this.botonAtras = botonAtras;
	}

	public JPanel getPanelAux() {
		return panelAux;
	}

	public void setPanelAux(JPanel panelAux) {
		this.panelAux = panelAux;
	}
	
	
}
