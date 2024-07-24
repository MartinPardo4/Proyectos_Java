package UI;

import javax.swing.*;

public abstract class TablaPanel extends JPanel{
	
	private UIManager manager;
	
	public TablaPanel(UIManager manager) {
		this.manager = manager;
		crearTablaPanel();
	}
	
	public abstract void crearTablaPanel();

	public UIManager getManager() {
		return manager;
	}

	public void setManager(UIManager manager) {
		this.manager = manager;
	}
	
	
}
