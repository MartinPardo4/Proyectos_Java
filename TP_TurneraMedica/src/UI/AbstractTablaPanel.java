package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public abstract class AbstractTablaPanel extends JPanel{
	
	protected UIManager manager;
	protected OpcionesTablaPanel opcionesTablaPanel;
	protected TablaPanel tablaPanel;
	
	public AbstractTablaPanel(UIManager manager) {
		this.manager = manager;
		setTablaPanel();
		setOpcionesTablaPanel();
		crearTabla();
	}
	
	public void crearTabla() {
		
		this.setLayout(new FlowLayout());
		
		this.add(tablaPanel);
		this.add(opcionesTablaPanel);
		
		opcionesTablaPanel.getBotonAgregar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ejecutarAccionAgregar();
				
			}
		});
		
		opcionesTablaPanel.getBotonBorrar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ejecutarAccionBorrar();
				
			}
		});
		
		opcionesTablaPanel.getBotonBuscar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ejecutarAccionBuscar();
				
			}
		});
		
		opcionesTablaPanel.getBotonEditar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ejecutarAccionEditar();
				
			}
		});
		
		opcionesTablaPanel.getBotonVolver().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager.mostrarPanelMenuTablas();
			}
		});
	}
	
	public abstract void setTablaPanel();
	public abstract void ejecutarAccionAgregar();
	public abstract void ejecutarAccionBorrar();
	public abstract void ejecutarAccionBuscar();
	public abstract void ejecutarAccionEditar();
	
	public UIManager getManager() {
		return manager;
	}

	public void setManager(UIManager manager) {
		this.manager = manager;
	}

	public OpcionesTablaPanel getOpcionesTablaPanel() {
		return opcionesTablaPanel;
	}

	public void setOpcionesTablaPanel() {
		this.opcionesTablaPanel = new OpcionesTablaPanel(this.manager);
	}

	public TablaPanel getTablaPanel() {
		return tablaPanel;
	}
	
}
