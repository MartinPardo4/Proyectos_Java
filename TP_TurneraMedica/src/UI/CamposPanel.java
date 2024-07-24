package UI;

import javax.swing.*;

public abstract class CamposPanel extends JPanel{
	
	private UIManager manager;
	
	public CamposPanel(UIManager manager) {
		this.manager = manager;
		armarFormulario();
	}
	
	public abstract void armarFormulario();

	public UIManager getManager() {
		return manager;
	}

	public void setManager(UIManager manager) {
		this.manager = manager;
	}
	
	
}
