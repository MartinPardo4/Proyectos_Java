package UI;

import java.util.*;
import Entidades.*;


import javax.swing.*;

public class LogInPanel extends AbstractFormularioUsuarioPanel{
	
	private CamposLogInPanel camposLogInPanel;
	private Usuario user;
	
	public LogInPanel(UIManager manager) {
		super(manager);
		this.botoneraPanel.getBotonAceptar().setText("Ingresar");
		this.botoneraPanel.getBotonCancelar().setText("Registrarse");
	}
	
	public void setCamposPanel() {
		this.camposLogInPanel = new CamposLogInPanel(this.manager);
		this.camposPanel = this.camposLogInPanel;
	}
	
	public void ejecutarAccionAceptar() {
		String nombreIngresado = this.camposLogInPanel.getTextoNombre().getText();
		String DNIIngresado = this.camposLogInPanel.getTextoDNI().getText();
		
		try {
				
				manager.validarCampoNoNulo(nombreIngresado, "nombre de usuario");
				manager.validarCampoNoNulo(DNIIngresado, "DNI");
				int dni = manager.validarDNI(DNIIngresado);
				user = this.validarUsuario(nombreIngresado, dni);
				
				manager.mostrarPanelHome();
			}catch(CampoNuloException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}catch(EnteroNoValidoException exc) {
				JOptionPane.showMessageDialog(this, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}catch(UsuarioNoValidoException ux) {
				JOptionPane.showMessageDialog(this, ux.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			} catch (LongitudException lx) {
				JOptionPane.showMessageDialog(this, lx.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
	}
	
	public void ejecutarAccionCancelar() {
		manager.mostrarPanelRegistrarUsuario();
	}

		
		private Usuario validarUsuario(String nombre, int dni) throws UsuarioNoValidoException{
			List<Usuario> usuarios = manager.crearListaUsuarios();
			
			int cont = 0;
			for(Usuario user : usuarios) {
				if(user.getNombre().equals(nombre) && user.getDNI() == dni) {
					cont++;
					return user;
				}
			}
			if(cont == 0) {
				throw new UsuarioNoValidoException("El usuario ingresado no es válido");
			}
			return null;
		}

		public CamposLogInPanel getCamposLogInPanel() {
			return camposLogInPanel;
		}

		public void setCamposLogInPanel(CamposLogInPanel camposLogInPanel) {
			this.camposLogInPanel = camposLogInPanel;
		}

		public Usuario getUser() {
			return user;
		}

		public void setUser(Usuario user) {
			this.user = user;
		}

}
