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
	
	static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
