package packLibreria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorBBDD extends Conector{
	PreparedStatement pt;
	public GestorBBDD() {
	}

	public void insertarLibro(Libro libro) throws ClassNotFoundException, SQLException {
		
		pt = getCon().prepareStatement("INSERT INTO libros (titulo, autor, num_pag) VALUES (?,?,?)");
		pt.setString(1, libro.getTitulo());
		pt.setString(2,libro.getAutor());
		pt.setInt(3, libro.getNum_pag());
		pt.execute();
	
	}
	
	public void eliminarLibro(int id) throws ClassNotFoundException, SQLException {
		pt = getCon().prepareStatement("DELETE FROM libros WHERE id=?");
		pt.setInt(1, id);
		pt.execute();
	
	}
	
	public void modificarLibro(Libro libro,int id, Scanner sc) throws SQLException {
		pt=getCon().prepareStatement("UPDATE libros SET titulo=?, autor=?, num_pag=? WHERE id=?");
		pt.setString(1,libro.getTitulo());
		pt.setString(2, libro.getAutor());
		pt.setInt(3, libro.getNum_pag());
		pt.setInt(4, id);
		pt.executeUpdate();
	}
	
	public Libro getLibro(int id) throws SQLException {
		String select="SELECT * FROM libros WHERE id=?";
		Libro libro=new Libro();
		
		pt=getCon().prepareStatement(select);
		pt.setInt(1, id);
		ResultSet result=pt.executeQuery();
		
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
}
