package DAO;

import java.sql.*;
import java.util.*;
import Entidades.*;

import Entidades.Medico;

public class PacienteDAOH2Imp implements PacienteDAO{
	
	public void altaPaciente(Paciente unPaciente) throws ConexionException, EjecucionSentenciaException{
		
		String nombre = unPaciente.getNombre();
		String apellido = unPaciente.getApellido();
		int DNI = unPaciente.getDNI();
		int numObra = unPaciente.getNumeroObraSocial();
		
		String sql = "INSERT INTO pacientes (nombre, apellido, DNI, numeroObraSocial) VALUES ('"+ nombre + "','"+ apellido + "' , " + DNI + ", "+ numObra + " )";
		
		try {
			DBManager.actualizar(sql);
		}catch(ConexionException e) {
			throw new ConexionException(e.getMessage(), e);
		}catch(EjecucionSentenciaException ex) {
			throw new EjecucionSentenciaException(ex.getMessage(), ex);
		}
	}
	
	public void borrarPaciente(int DNI) throws ConexionException, EjecucionSentenciaException{
		
		String sql = "DELETE FROM pacientes WHERE DNI = "+ DNI + " ";
		
		try {
			DBManager.actualizar(sql);
		}catch(ConexionException e) {
			throw new ConexionException(e.getMessage(), e);
		}catch(EjecucionSentenciaException ex) {
			throw new EjecucionSentenciaException(ex.getMessage(), ex);
		}

	}
	
	public void actualizarPaciente(Paciente nuevoPaciente, int dniBusqueda) throws ConexionException, EjecucionSentenciaException{
		
		String nombre = nuevoPaciente.getNombre();
		String apellido = nuevoPaciente.getApellido();
		int DNI = nuevoPaciente.getDNI();
		int numObra = nuevoPaciente.getNumeroObraSocial();
		
		
		String sql = "UPDATE pacientes set nombre = '"+nombre+"', apellido = '"+apellido+"', DNI = "+DNI+", numeroObraSocial = '"+numObra+"' WHERE DNI = "+dniBusqueda +" ";
		
		try {
			DBManager.actualizar(sql);
		}catch(ConexionException e) {
			throw new ConexionException(e.getMessage(), e);
		}catch(EjecucionSentenciaException ex) {
			throw new EjecucionSentenciaException(ex.getMessage(), ex);
		}
	}
	
	public Paciente consultarPaciente(int DNI) throws ConexionException, EjecucionSentenciaException{
		
		String sql = "SELECT * FROM pacientes WHERE DNI = "+ DNI +" ";
		
		Connection c = null; 
		try {
			c = DBManager.conectar();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int dni = rs.getInt("DNI");
				int numObra = rs.getInt("numeroObraSocial");
				Paciente nuevoPaciente = new Paciente(nombre, apellido, dni, numObra);
				return nuevoPaciente;
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
	
	public List<Paciente> enlistarPaciente() throws ConexionException, EjecucionSentenciaException{
		
		String sql = "SELECT * FROM pacientes";
		List<Paciente> pacientes = new ArrayList<>();
		Connection c = null;
		
		try {
			c = DBManager.conectar();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int DNI = rs.getInt("DNI");
				int numObra = rs.getInt("numeroObraSocial");
				Paciente paciente = new Paciente(nombre, apellido, DNI, numObra);
				pacientes.add(paciente);
			}
			return pacientes;
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
