package packLibreria;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorBBDD extends Conector{
	PreparedStatement pt;
	public GestorBBDD() {
	}
//Para GestorLibros---------------------------------------------------------------------------------------------
	public void insertarLibro(Libro libro) throws ClassNotFoundException, SQLException {
		
		pt = getCon().prepareStatement("INSERT INTO libros (titulo, autor, num_pag) VALUES (?,?,?)");
		pt.setString(1, libro.getTitulo());
		pt.setString(2,libro.getAutor());
		pt.setInt(3, libro.getNum_pag());
		pt.execute();
		System.out.println("Se ha insertado el libro");
	}
	
	public void eliminarLibro(int id) throws ClassNotFoundException, SQLException {
		pt = getCon().prepareStatement("DELETE FROM libros WHERE id=?");
		pt.setInt(1, id);
		pt.execute();
		
		System.out.println("Se ha eliminado el libro");
	
	}
	
	public void modificarLibro(Libro libro,int id, Scanner sc) throws SQLException {
		pt=getCon().prepareStatement("UPDATE libros SET titulo=?, autor=?, num_pag=? WHERE id=?");
		pt.setString(1,libro.getTitulo());
		pt.setString(2, libro.getAutor());
		pt.setInt(3, libro.getNum_pag());
		pt.setInt(4, id);
		pt.executeUpdate();
		System.out.println("Se ha actualizado el libro");
	}
	
	public Libro getLibro(int id) throws SQLException {
		String select="SELECT * FROM libros WHERE id=?";
		Libro libro=new Libro();
		
		pt=getCon().prepareStatement(select);
		pt.setInt(1, id);
		ResultSet result=pt.executeQuery();
		result.next();
		libro.setId(result.getInt("id"));
		libro.setTitulo(result.getString("titulo"));
		libro.setAutor(result.getString("autor"));
		libro.setNum_pag(result.getInt("num_pag"));
		
		return libro;
	}
	
	public ArrayList<Libro> getLibros() throws SQLException{
		ArrayList<Libro> libroList=new ArrayList<Libro>();
		String select="SELECT * FROM libros";
		
		
		pt=getCon().prepareStatement(select);

		ResultSet result=pt.executeQuery();
		while(result.next()) {
			Libro libro=new Libro();
			libro.setId(result.getInt("id"));
			libro.setTitulo(result.getString("titulo"));
			libro.setAutor(result.getString("autor"));
			libro.setNum_pag(result.getInt("num_pag"));
			libroList.add(libro);
		}
		return libroList;
	}
//Para GestorSocios---------------------------------------------------------------------------------
	public void insertarSocio(Socios socio) throws ClassNotFoundException, SQLException {
		
		pt = getCon().prepareStatement("INSERT INTO socios (nombre, apellido, direccion, poblacion, provincia, dni) VALUES (?,?,?,?,?,?)");
		pt.setString(1, socio.getNombre());
		pt.setString(2, socio.getApellido());
		pt.setString(3, socio.getDireccion());
		pt.setString(4, socio.getPoblacion());
		pt.setString(5, socio.getProvincia());
		pt.setString(6, socio.getDni());
		pt.execute();
		System.out.println("Se ha insertado el socio");
	}
	
	public void eliminarSocio(int id) throws ClassNotFoundException, SQLException {
		pt = getCon().prepareStatement("DELETE FROM socios WHERE id=?");
		pt.setInt(1, id);
		pt.execute();
		System.out.println("Se ha eliminado el socio");
	}
	
	public void modificarSocio(Socios socio,int id, Scanner sc) throws SQLException {
		pt=getCon().prepareStatement("UPDATE socios SET nombre=?, apellido=?, direccion=?, poblacion=?, provincia=?, dni=? WHERE id=?");
		pt.setString(1, socio.getNombre());
		pt.setString(2, socio.getApellido());
		pt.setString(3, socio.getDireccion());
		pt.setString(4, socio.getPoblacion());
		pt.setString(5, socio.getProvincia());
		pt.setString(6, socio.getDni());
		pt.setInt(7, id);
		pt.executeUpdate();
		System.out.println("Se ha actualizado el socio");
	}
	
	public Socios getSocio(int id) throws SQLException {
		String select="SELECT * FROM socios WHERE id=?";
		Socios socio=new Socios();
		
		pt=getCon().prepareStatement(select);
		pt.setInt(1, id);
		ResultSet result=pt.executeQuery();
		result.next();
		socio.setId(result.getInt("id"));
		socio.setNombre(result.getString("nombre"));
		socio.setApellido(result.getString("apellido"));
		socio.setDireccion(result.getString("direccion"));
		socio.setPoblacion(result.getString("poblacion"));
		socio.setProvincia(result.getString("provincia"));
		socio.setDni(result.getString("dni"));
		
		return socio;
	}
	
	public ArrayList<Socios> getSocios() throws SQLException{
		ArrayList<Socios> socioList=new ArrayList<Socios>();
		String select="SELECT * FROM socios";
		
		
		pt=getCon().prepareStatement(select);

		ResultSet result=pt.executeQuery();
		while(result.next()) {
			Socios socio=new Socios();
			socio.setId(result.getInt("id"));
			socio.setNombre(result.getString("nombre"));
			socio.setApellido(result.getString("apellido"));
			socio.setDireccion(result.getString("direccion"));
			socio.setPoblacion(result.getString("poblacion"));
			socio.setProvincia(result.getString("provincia"));
			socio.setDni(result.getString("dni"));
			
			socioList.add(socio);
		}
		return socioList;
	}
	//Para GestorPrestamo--------------------------------------------------------------------------------
	public void insertarPrestamo(Prestamos prestamo) throws ClassNotFoundException, SQLException {
		
		pt = getCon().prepareStatement("INSERT INTO prestamos VALUES (?,?,?,?)");
		pt.setInt(1, prestamo.getId_libro());
		pt.setInt(2, prestamo.getId_socio());
		pt.setDate(3, (Date) prestamo.getFecha());
		pt.setInt(4, (prestamo.isDevuelto()== true ? 1:0));
		pt.execute();
		System.out.println("Se ha insertado el prestamo");
	}
	
	public void eliminarPrestmao(int id_libro, int id_socio) throws ClassNotFoundException, SQLException {
		pt = getCon().prepareStatement("DELETE FROM prestamos WHERE id_libro=? AND id_socio=?");
		pt.setInt(1, id_libro); //Comprobar que exista
		pt.setInt(2, id_socio); //Comprobar que exista
		pt.execute();
		
		System.out.println("Se ha eliminado el prestamo");
	
	}
	
	public void modificarPrestamo(Prestamos prestamo, int id_libro, int id_socio, Scanner sc) throws SQLException {
		pt=getCon().prepareStatement("UPDATE prestamos SET fecha=? devuelto=? WHERE id_libro=? AND id_socio=?");
		pt.setDate(1, (Date)prestamo.getFecha());
		pt.setInt(2, prestamo.isDevuelto()== true ? 1:0);
		pt.setInt(3, id_libro); //Comprobar que exista
		pt.setInt(4, id_socio); //Comprobar que exista
		pt.executeUpdate();
		System.out.println("Se ha actualizado el libro");
	}
	
	public Prestamos getPrestamo(int id_libro, int id_socio) throws SQLException {
		String select="SELECT * FROM prestamos WHERE id_libro=? AND id_socio=?";
		Prestamos prestamo=new Prestamos();
		
		pt=getCon().prepareStatement(select);
		pt.setInt(1, id_libro);
		pt.setInt(2, id_socio);
		ResultSet result=pt.executeQuery();
		result.next();
		prestamo.setId_libro(result.getInt("id_libro"));
		prestamo.setId_socio(result.getInt("id_socio"));
		prestamo.setFecha(result.getDate("fecha"));
		prestamo.setDevuelto(result.getInt("devuelto")== 1 ? true:false);
		
		return prestamo;
	}
	
	public ArrayList<Prestamos> getPrestamos() throws SQLException{
		ArrayList<Prestamos> prestamosList=new ArrayList<Prestamos>();
		String select="SELECT * FROM prestamos";
		
		
		pt=getCon().prepareStatement(select);

		ResultSet result=pt.executeQuery();
		while(result.next()) {
			Prestamos prestamo= new Prestamos();
			
			prestamo.setId_libro(result.getInt("id_libro"));
			prestamo.setId_socio(result.getInt("id_socio"));
			prestamo.setFecha(result.getDate("fecha"));
			prestamo.setDevuelto(result.getInt("devuelto")== 1 ? true:false);
			
			prestamosList.add(prestamo);
		}
		return prestamosList;
	}
}
