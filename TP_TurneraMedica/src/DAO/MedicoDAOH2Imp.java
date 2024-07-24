package DAO;

import java.sql.*;
import Entidades.*;
import java.util.*;

public class MedicoDAOH2Imp implements MedicoDAO{
	
	public void altaMedico(Medico unMedico) throws ConexionException, EjecucionSentenciaException{
		
		String nombre = unMedico.getNombre();
		String apellido = unMedico.getApellido();
		int DNI = unMedico.getDNI();
		int cobro = unMedico.getCobro();
		
		String sql = "INSERT INTO medicos (nombre, apellido, DNI, cobro) VALUES ('"+ nombre + "','"+ apellido + "' , " + DNI + ","+ cobro + ")";
		
		try {
			DBManager.actualizar(sql);
		}catch(ConexionException e) {
			throw new ConexionException(e.getMessage(), e);
		}catch(EjecucionSentenciaException ex) {
			throw new EjecucionSentenciaException(ex.getMessage(), ex);
		}
	}
	
	public void borrarMedico(int DNI) throws ConexionException, EjecucionSentenciaException{
		
		String sql = "DELETE FROM medicos WHERE DNI = "+ DNI + " ";
		
		try {
			DBManager.actualizar(sql);
		}catch(ConexionException e) {
			throw new ConexionException(e.getMessage(), e);
		}catch(EjecucionSentenciaException ex) {
			throw new EjecucionSentenciaException(ex.getMessage(), ex);
		}
		
	}
	
	public void actualizarMedico(Medico nuevoMedico, int dniBusqueda) throws ConexionException, EjecucionSentenciaException{
		
		String nombre = nuevoMedico.getNombre();
		String apellido = nuevoMedico.getApellido();
		int DNI = nuevoMedico.getDNI();
		int cobro = nuevoMedico.getCobro();
		
		
		String sql = "UPDATE medicos set nombre = '"+nombre+"', apellido = '"+apellido+"', DNI = "+DNI+", cobro = "+cobro+" WHERE DNI = "+dniBusqueda +" ";
		
		try {
			DBManager.actualizar(sql);
		}catch(ConexionException e) {
			throw new ConexionException(e.getMessage(), e);
		}catch(EjecucionSentenciaException ex) {
			throw new EjecucionSentenciaException(ex.getMessage(), ex);
		}
	}
	
	public Medico consultarMedico(int DNI) throws ConexionException, EjecucionSentenciaException{
		
	String sql = "SELECT * FROM medicos WHERE DNI = "+ DNI +" ";
		
		Connection c = null; 
		try {
			c = DBManager.conectar();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int dni = rs.getInt("DNI");
				int cobro = rs.getInt("cobro");
				Medico nuevoMedico = new Medico(nombre, apellido, dni, cobro);
				return nuevoMedico;
			}		
			
		}catch(AbrirConexionException e) {
			throw new ConexionException(e.getMessage());
		}catch(SQLException ex) {
			try{
				c.rollback();
				throw new ActualizacionException("Hubo un error en la actualizacion");
			}catch(SQLException exc) {
				throw new RolbakeoException("Hubo un error en el rolbakeo");
			}
		}
		
		finally {
			try {
				DBManager.desconectar(c);
			}catch(CerrarConexionException e) {
				throw new ConexionException(e.getMessage());
			}
		}
		return null;
	}
	
	public List<Medico> enlistarMedico() throws ConexionException, EjecucionSentenciaException{
		
		String sql = "SELECT * FROM medicos";
		List<Medico> medicos = new ArrayList<>();
		Connection c = null;
		
		try {
			c = DBManager.conectar();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int DNI = rs.getInt("DNI");
				int cobro = rs.getInt("cobro");
				Medico medico = new Medico(nombre, apellido, DNI, cobro);
				medicos.add(medico);
			}
			return medicos;
		}catch(AbrirConexionException e) {
			throw new ConexionException(e.getMessage());
		}catch(SQLException ex) {
			throw new ConsultaException("Hubo un error en la consulta");
		}
		finally {
			try{
			DBManager.desconectar(c);
			}catch(CerrarConexionException e) { 
				throw new ConexionException(e.getMessage());
			}
		}
	}
	
		
}

