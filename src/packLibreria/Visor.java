package packLibreria;

import java.util.ArrayList;

public class Visor {
	static void mostrarLibros(ArrayList<Libro> libros) {
		for (Libro libro : libros) {
			System.out.println(libro.toString());
		}
	}
	
	static void mostrarLibro(Libro libro) {
		System.out.println(libro.toString());
	}
	
	static void mostrarSocios(ArrayList<Socios> socioList) {
		for (Socios socio: socioList) {
			System.out.println(socio.toString());
		}
	}
	
	static void mostrarSocio(Socios socio) {
		System.out.println(socio.toString());
	}
	
	static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	
}
