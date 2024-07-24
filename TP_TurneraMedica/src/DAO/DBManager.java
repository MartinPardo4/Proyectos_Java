package DAO;

import java.sql.*;


public class DBManager {
	
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_BASE_URL = "jdbc:mysql://localhost:3306/BD_Turnera?serverTimezone=UTC";
	private static final String user = "root";
	private static final String pass = "Rafael5763";
	
	public static Connection conectar() throws AbrirConexionException{
		Connection c = null;
		
		try {
		Class.forName(DB_DRIVER);
		}catch(ClassNotFoundException e) {

			throw new AbrirConexionException("Hubo un error al abrir la conexión");
			
		}
		try {
			c = DriverManager.getConnection(DB_BASE_URL, user, pass);
			c.setAutoCommit(false);
		}catch(SQLException e) {
			throw new AbrirConexionException("Hubo un error al abrir la conexión");
		}
		
		return c;
	}
	
	public static void desconectar(Connection c) throws CerrarConexionException{
		if(c != null) {
			try {
			c.close();
		}catch(SQLException e) {
			throw new CerrarConexionException("Hubo un error al cerrar la conexión");
		}
		
		}
		
	}
	
	public static void actualizar(String sql) throws ConexionException, EjecucionSentenciaException{
		
		Connection c = null; 
		try {
			c = DBManager.conectar();
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
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
	}
	
	public static ResultSet consultar(String sql) throws ConexionException, EjecucionSentenciaException {
		
		Connection c = null; 
		try {
			c = DBManager.conectar();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
	
			return rs;
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
	}
}
	