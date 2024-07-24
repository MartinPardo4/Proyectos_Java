package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public abstract class AbstractFormularioUsuarioPanel extends JPanel{
	
	protected UIManager manager;
	protected CamposPanel camposPanel;
	protected BotoneraPanel botoneraPanel;
	
	public AbstractFormularioUsuarioPanel(UIManager manager) {
		this.manager = manager;
		this.setCamposPanel();
		this.setBotoneraPanel();
		armarFormularioUsuarioPanel();
		
	}
	
	public void armarFormularioUsuarioPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(camposPanel);
		this.add(botoneraPanel);
		
		this.botoneraPanel.getBotonAceptar().setText("Aceptar");
		this.botoneraPanel.getBotonCancelar().setText("Cancelar");
		
		this.botoneraPanel.getBotonAceptar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ejecutarAccionAceptar();
				
			}
		});
		
		this.botoneraPanel.getBotonCancelar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ejecutarAccionCancelar();
				
			}
		});
		
	}
	
	public abstract void ejecutarAccionAceptar();
	public abstract void ejecutarAccionCancelar();
	public abstract void setCamposPanel();
	
	public UIManager getManager() {
		return manager;
	}

	public void setManager(UIManager manager) {
		this.manager = manager;
	}

	public BotoneraPanel getBotoneraPanel() {
		return botoneraPanel;
	}

	public void setBotoneraPanel() {
		this.botoneraPanel =  new BotoneraPanel(this.manager);
	}	
	
}
