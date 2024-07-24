package DAO;

import java.sql.*;
import java.text.ParseException;
import java.util.*;
import Entidades.*;

public class TurnoDAOH2Imp implements TurnoDAO{
	
	public void altaTurno(Turno unTurno) throws ConexionException, EjecucionSentenciaException{
		
		int DNIMedico = unTurno.getMedico().getDNI();
		int DNIPaciente = unTurno.getPaciente().getDNI();
		String fecha = unTurno.getFecha();
		
		String sql = "INSERT INTO turnos (fecha, medico, paciente) VALUES ('"+fecha+"', "+DNIMedico+", "+DNIPaciente+")";
		
		
		try {
			DBManager.actualizar(sql);
		}catch(ConexionException e) {
			throw new ConexionException(e.getMessage(), e);
		}catch(EjecucionSentenciaException ex) {
			throw new EjecucionSentenciaException(ex.getMessage(), ex);
		}
	}
	public void borrarTurno(int ID) throws ConexionException, EjecucionSentenciaException{
		
		String sql = "DELETE FROM turnos WHERE ID = "+ ID + " ";
		
		try {
			DBManager.actualizar(sql);
		}catch(ConexionException e) {
			throw new ConexionException(e.getMessage(), e);
		}catch(EjecucionSentenciaException ex) {
			throw new EjecucionSentenciaException(ex.getMessage(), ex);
		}

	}
	
	public void actualizarTurno(Turno nuevoTurno, int idBusqueda) throws ConexionException, EjecucionSentenciaException{
		
		int DNIMedico = nuevoTurno.getMedico().getDNI();
		int DNIPaciente = nuevoTurno.getPaciente().getDNI();
		String fecha = nuevoTurno.getFecha();
		
		String sql = "UPDATE turnos set medico = "+DNIMedico+", paciente = "+DNIPaciente+", fecha = '"+fecha+"'  WHERE ID = "+idBusqueda +" ";
		
		try {
			DBManager.actualizar(sql);
		}catch(ConexionException e) {
			throw new ConexionException(e.getMessage(), e);
		}catch(EjecucionSentenciaException ex) {
			throw new EjecucionSentenciaException(ex.getMessage(), ex);
		}
	}
	
	public Turno consultarTurno(int ID) throws ConexionException, EjecucionSentenciaException{
		
		String sql = "SELECT * FROM turnos WHERE ID = "+ ID +" ";
		
		Connection c = null; 
		try {
			c = DBManager.conectar();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				MedicoDAO DAO = new MedicoDAOH2Imp();
				PacienteDAO DAO2 = new PacienteDAOH2Imp();
				
				int DNIMedico = rs.getInt("medico");
				int DNIPaciente = rs.getInt("paciente");
				String fecha = rs.getString("fecha");
				Medico medico = DAO.consultarMedico(DNIMedico);
				Paciente paciente = DAO2.consultarPaciente(DNIPaciente);
				Turno nuevoTurno = new Turno(fecha, medico, paciente);
				
				return nuevoTurno;
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
		}catch(ParseException pe) {
			throw new FormateoException("Hubo un error en el formateo");
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
	
	public List<Turno> enlistarTurno() throws ConexionException, EjecucionSentenciaException{
		
		MedicoDAO DAO = new MedicoDAOH2Imp();
		PacienteDAO DAO2 = new PacienteDAOH2Imp();
		
		String sql = "SELECT * FROM turnos";
		List<Turno> turnos = new ArrayList<>();
		Connection c = null;
		
		try {
			c = DBManager.conectar();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				
				int ID = rs.getInt("ID");
				int DNIMedico = rs.getInt("medico");
				int DNIPaciente = rs.getInt("paciente");
				String fecha = rs.getString("fecha");
				
				Medico medico = DAO.consultarMedico(DNIMedico);
				Paciente paciente = DAO2.consultarPaciente(DNIPaciente);
				Turno turno = new Turno(fecha, medico, paciente);
				turno.setID(ID);
				
				turnos.add(turno);
			}
			return turnos;
		}catch(AbrirConexionException e) {
			throw new ConexionException(e.getMessage());
		}catch(SQLException ex) {
			throw new ConsultaException("Hubo un error en la consulta");
		}catch(ParseException pe) {
			throw new FormateoException("Hubo un error en el formateo");
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
	
