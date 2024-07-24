package Service;

import DAO.*;
import java.util.*;
import Entidades.Paciente;

public class PacienteService {
	
	PacienteDAO DAO = new PacienteDAOH2Imp();
	
	public void armarTabla() throws TablaException{
		String err = "Hubo un error en crear la tabla de pacientes";
		String sql = "CREATE TABLE pacientes (ID INTEGER AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100), apellido VARCHAR(100), DNI INTEGER UNIQUE, numeroObraSocial INTEGER)";
		
		try {
			TableManager.crearTabla(sql);
		}catch(ConexionException e) {
			throw new TablaException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new TablaException(err, ex);
		}
		
	}
	
	public void borrarTabla() throws TablaException{
		
		String err = "Hubo un error en eliminar la tabla de pacientes";
		String sql = "DROP TABLE pacientes";
		
		try {
			TableManager.eliminarTabla(sql);
		}catch(ConexionException e) {
			throw new TablaException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new TablaException(err, ex);
		}
	}
	
	public void altaPaciente(Paciente unPaciente) throws AltaException{
		String err = "Hubo un error en el alta del paciente";
		try {
			DAO.altaPaciente(unPaciente);
		}catch(ConexionException e) {
			throw new AltaException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new AltaException(err, ex);
		}
		
	}
	
	
	public void eliminarPaciente(int DNI) throws BorrarException{
		String err = "Hubo un error en el borrado";
		
		try {
			DAO.borrarPaciente(DNI);
		}catch(ConexionException e) {
			throw new BorrarException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new BorrarException(err, ex);
		}
	}
	
	public void editarPaciente(Paciente nuevoPaciente, int dniBusqueda) throws EditarException{
		String err = "Hubo un error en la edición";
		try {
			DAO.actualizarPaciente(nuevoPaciente, dniBusqueda);
		}catch(ConexionException e) {
			throw new EditarException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new EditarException(ex.getMessage(), ex);
		}
	}
	
	public Paciente obtenerPaciente(int DNI) throws ObtenerException{
		String err = "Hubo un error en la consulta a la tabla de pacientes";
		Paciente paciente = new Paciente();
		try {
			paciente = DAO.consultarPaciente(DNI);
			return paciente;
		}catch(ConexionException e) {
			throw new ObtenerException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new ObtenerException(err, ex);
		}
	} 
	
	
	public List<Paciente> enlistarPaciente() throws EnlistarException{
		String err = "Hubo un error al enlistar los pacientes";
		List<Paciente> lista = new ArrayList<>();
		try {
			lista = DAO.enlistarPaciente();
		}catch(ConexionException e) {
			throw new EnlistarException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new EnlistarException(err, ex);
		}
		return lista;
	}
	
}
