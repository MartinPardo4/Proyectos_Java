package UI;


public class Interfaz {
	
	private UIManager manager;
	
	public static void main(String [] args) {
				
		Interfaz interfaz = new Interfaz();

		interfaz.iniciarManager();
		interfaz.mostrarFrame();

	}
	
	public void iniciarManager() {
		manager = new UIManager();
		manager.crearManager();
		manager.mostrarPanelLogIn();
		 }
	
		public void mostrarFrame() {
		manager.mostrarFrame();
		 }
	
}
