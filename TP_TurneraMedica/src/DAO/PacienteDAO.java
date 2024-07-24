package DAO;

import java.util.List;

import Entidades.Paciente;

public interface PacienteDAO {
	
	void altaPaciente(Paciente unPaciente) throws ConexionException, EjecucionSentenciaException;
	
	void borrarPaciente(int DNI) throws ConexionException, EjecucionSentenciaException;
	
	void actualizarPaciente(Paciente nuevoPaciente, int dniBusqueda) throws ConexionException, EjecucionSentenciaException;
	
	Paciente consultarPaciente(int DNI) throws ConexionException, EjecucionSentenciaException;
	
	List<Paciente> enlistarPaciente() throws ConexionException, EjecucionSentenciaException;
}
