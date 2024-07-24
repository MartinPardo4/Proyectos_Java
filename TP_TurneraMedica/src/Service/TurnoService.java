package Service;

import java.util.*;
import DAO.*;
import Entidades.Turno;

public class TurnoService {
	
	TurnoDAO DAO = new TurnoDAOH2Imp();
	
	public void armarTabla() throws TablaException{
		String err = "Hubo un error en crear la tabla de turnos";
		String sql = "CREATE TABLE turnos (ID INTEGER AUTO_INCREMENT PRIMARY KEY,fecha VARCHAR(100), medico INTEGER, paciente INTEGER)";
		
		try {
			TableManager.crearTabla(sql);
		}catch(ConexionException e) {
			throw new TablaException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new TablaException(err, ex);
		}
		
	}
	
	public void borrarTabla() throws TablaException{
		
		String err = "Hubo un error en eliminar la tabla de turnos";
		String sql = "DROP TABLE turnos";
		
		try {
			TableManager.eliminarTabla(sql);
		}catch(ConexionException e) {
			throw new TablaException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new TablaException(err, ex);
		}
	}
	
	public void altaTurno(Turno unTurno) throws AltaException{
		
		String err = "Hubo un error en el alta del turno";
		try {
			DAO.altaTurno(unTurno);
		}catch(ConexionException e) {
			throw new AltaException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new AltaException(err, ex);
		}
		
	}
	
	public void eliminarTurno(int ID) throws BorrarException{
		String err = "Hubo un error en el borrado";
		
		try {
			DAO.borrarTurno(ID);
		}catch(ConexionException e) {
			throw new BorrarException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new BorrarException(err, ex);
		}
	}
	
	public void editarTurno(Turno nuevoTurno, int idBusqueda) throws EditarException{
		String err = "Hubo un error en la edición";
		try {
			DAO.actualizarTurno(nuevoTurno, idBusqueda);
		}catch(ConexionException e) {
			throw new EditarException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new EditarException(err, ex);
		}
	}
	
	public Turno obtenerTurno(int ID) throws ObtenerException{
		String err = "Hubo un error en la consulta a la tabla de turnos";
		Turno turno = new Turno();
		try {
			turno = DAO.consultarTurno(ID);
			return turno;
		}catch(ConexionException e) {
			throw new ObtenerException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new ObtenerException(err, ex);
		}
	} 
	

	public List<Turno> enlistarTurno() throws EnlistarException{
		String err = "Hubo un error al enlistar los turnos";
		List<Turno> lista = new ArrayList<>();
		try {
			lista = DAO.enlistarTurno();
		}catch(ConexionException e) {
			throw new EnlistarException(err, e);
		}catch(EjecucionSentenciaException ex) {
			throw new EnlistarException(err, ex);
		}
		return lista;
	}
}
