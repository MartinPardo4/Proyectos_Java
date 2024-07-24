package DAO;

import java.util.List;
import Entidades.Turno;

public interface TurnoDAO {
	
	void altaTurno(Turno unTurno) throws ConexionException, EjecucionSentenciaException;
	
	void borrarTurno(int DNI) throws ConexionException, EjecucionSentenciaException;
	
	void actualizarTurno(Turno nuevoTurno, int dniBusqueda) throws ConexionException, EjecucionSentenciaException;
	
	Turno consultarTurno(int DNI) throws ConexionException, EjecucionSentenciaException;
	
	List<Turno> enlistarTurno() throws ConexionException, EjecucionSentenciaException;
}
