package Service;                           

import DAO.*;
import Entidades.*;
import java.util.*;

public class MedicoService {
	
	MedicoDAO DAO = new MedicoDAOH2Imp();
	
	public void armarTabla() throws TablaException{
		String err = "Hubo un error en crear la tabla de médicos";
		String sql = "CREATE TABLE medicos (ID INTEGER AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(100), apellido VARCHAR(100), DNI INTEGER UNIQUE, cobro INTEGER)";
		
		try {
			TableManager.crearTabla(sql);
		}catch(ConexionException e) {
			throw new TablaException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new TablaException(err, ex);
		}
		
	}
	
	public void borrarTabla() throws TablaException{
		
		String err = "Hubo un error en eliminar la tabla de médicos";
		String sql = "DROP TABLE medicos";
		
		try {
			TableManager.eliminarTabla(sql);
		}catch(ConexionException e) {
			throw new TablaException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new TablaException(err, ex);
		}
	}
	
	public void altaMedico(Medico unMedico) throws AltaException{
		String err = "Hubo un error en el alta del médico";
		try {
			DAO.altaMedico(unMedico);
		}catch(ConexionException e) {
			throw new AltaException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new AltaException(err, ex);
		}
		
	}
	
	
	public void eliminarMedico(int DNI) throws BorrarException{
		String err = "Hubo un error en el borrado";
		
		try {
			DAO.borrarMedico(DNI);
		}catch(ConexionException e) {
			throw new BorrarException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new BorrarException(err, ex);
		}
	}
	
	public void editarMedico(Medico nuevoMedico, int dniBusqueda) throws EditarException{
		String err = "Hubo un error en la edición";
		try {
			DAO.actualizarMedico(nuevoMedico, dniBusqueda);
		}catch(ConexionException e) {
			throw new EditarException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new EditarException(err, ex);
		}
	}
	
	public Medico obtenerMedico(int DNI) throws ObtenerException{
		String err = "Hubo un error en la consulta a la tabla de médicos";
		Medico medico = new Medico();
		try {
			medico = DAO.consultarMedico(DNI);
			return medico;
		}catch(ConexionException e) {
			throw new ObtenerException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new ObtenerException(err, ex);
		}
	} 
	
	
	public List<Medico> enlistarMedico() throws EnlistarException{
		String err = "Hubo un error al enlistar los médicos";
		List<Medico> lista = new ArrayList<>();
		try {
			lista = DAO.enlistarMedico();
		}catch(ConexionException e) {
			throw new EnlistarException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new EnlistarException(err, ex);
		}
		return lista;
	}
	
}
