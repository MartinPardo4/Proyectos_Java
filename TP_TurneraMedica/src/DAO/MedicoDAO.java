package DAO;
import Entidades.*;
import java.util.*;

public interface MedicoDAO {
	
	void altaMedico(Medico unMedico) throws ConexionException, EjecucionSentenciaException;
	
	void borrarMedico(int DNI) throws ConexionException, EjecucionSentenciaException;
	
	void actualizarMedico(Medico nuevoMedico, int dniBusqueda) throws ConexionException, EjecucionSentenciaException;
	
	Medico consultarMedico(int DNI) throws ConexionException, EjecucionSentenciaException;
	
	List<Medico> enlistarMedico() throws ConexionException, EjecucionSentenciaException;
}
