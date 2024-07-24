package DAO;

import java.sql.*;


public class TableManager {
	
	
	
	public static void crearTabla(String sql) throws ConexionException, EjecucionSentenciaException{
		
		Connection c = null;
		
		try {
			c = DBManager.conectar();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
			System.out.println("Conexion exitosa!!");
	
		}catch(AbrirConexionException e) {
			throw new ConexionException(e.getMessage());
		}catch(SQLException e) {
			try {
				c.rollback();
				throw new ActualizacionException("Hubo un error en la actualización");
				
			}catch(SQLException ex) {
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
	}
	
	public static void eliminarTabla(String sql) throws ConexionException, EjecucionSentenciaException{
		
		Connection c = null;
		try {
			c = DBManager.conectar();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		}catch(AbrirConexionException e) {
			throw new ConexionException(e.getMessage());
		}catch(SQLException e) {
			try {
				c.rollback();
				throw new ActualizacionException("Hubo un error en la actualización");
			}catch(SQLException ex) {
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

	}
	
}
