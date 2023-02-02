package packLibreria;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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
	
	public void modificarLibro(Libro libro,int id) throws SQLException {
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
	
	public void modificarSocio(Socios socio,int id) throws SQLException {
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
		pt.setDate(3, new Date(prestamo.getFecha().getTime()));
		pt.setInt(4, (prestamo.isDevuelto()== true ? 1:0));
		pt.execute();
		System.out.println("Se ha insertado el prestamo");
	}
	

	
	public void devolverLibro(int id_libro) throws SQLException {
		pt=getCon().prepareStatement("UPDATE prestamos SET devuelto=? WHERE id_libro=? ");
		pt.setInt(1, 1);
		pt.setInt(2, id_libro); 
	
		pt.executeUpdate();
		System.out.println("Se ha devuelto el libro");
	}
	
	public ArrayList<Prestamos> consultarLibrosNoDevueltos() throws SQLException {
		ArrayList<Prestamos> prestamos= new ArrayList<Prestamos>();
		String sentencia="SELECT * FROM prestamos WHERE devuelto = ?";
		pt=getCon().prepareStatement(sentencia);
		pt.setInt(1, 0);
		ResultSet result=pt.executeQuery();
		
		while(result.next()) {
			Prestamos prestamo=new Prestamos();
			
			prestamo.setId_libro(result.getInt("id_libro"));
			prestamo.setId_socio(result.getInt("id_socio"));
			prestamo.setFecha(result.getDate("fecha"));
			prestamo.setDevuelto(result.getInt("devuelto")== 1 ? true:false);
			
			prestamos.add(prestamo);
		}
		return prestamos;
	}
	public ArrayList<Prestamos> consultarPrestamoSocio(int id_socio) throws SQLException {
		ArrayList<Prestamos> prestamos= new ArrayList<Prestamos>();
		String sentencia="SELECT * FROM prestamos WHERE id_socio=?";
		pt=getCon().prepareStatement(sentencia);
		pt.setInt(1, id_socio);
		
		ResultSet result=pt.executeQuery();
		
		while(result.next()) {
			Prestamos prestamo=new Prestamos();
			
			prestamo.setId_libro(result.getInt("id_libro"));
			prestamo.setId_socio(result.getInt("id_socio"));
			prestamo.setFecha(result.getDate("fecha"));
			prestamo.setDevuelto(result.getInt("devuelto")== 1 ? true:false);
			
			prestamos.add(prestamo);
		}
		return prestamos;
	}
	
	public boolean consultarDisponibilidadDeLibro(int id_libro) throws SQLException {
		String sentencia="SELECT * FROM prestamos WHERE id_libro=?";
		boolean encontrado=false;
		boolean disponible=false;
		
		pt=getCon().prepareStatement(sentencia);
		pt.setInt(1, id_libro);
		
		ResultSet result=pt.executeQuery();
		
		while(result.next() && !encontrado) {
			if(result.getInt("id_libro")==id_libro) {
				encontrado=true;
				if(result.getInt("devuelto")==1){
					disponible=true;
				}
			}
		}
		return disponible;
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
