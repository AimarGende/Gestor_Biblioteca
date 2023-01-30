package packLibreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conector {
	Connection con;
	
	public void  conectar() throws ClassNotFoundException, SQLException {
		System.out.println("Conectando");
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String HOST="jdbc:mysql://localhost/";
		final String BBDD="biblioteca";
		final String USERNAME="root";
		final String PASSWORD="";
		con=DriverManager.getConnection(HOST+BBDD,USERNAME,PASSWORD);
	}
	
	public void cerrar() throws SQLException {
		System.out.println("Cerrando conexion");
		con.close();
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	
}
