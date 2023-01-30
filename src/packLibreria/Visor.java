package packLibreria;

import java.util.ArrayList;

public class Visor {
	static void mostrarLibros(ArrayList<Libro> libros) {
		for (Libro libro : libros) {
			libro.toString();
		}
	}
	
	static void mostrarLibro(Libro libro) {
		libro.toString();
	}
	
	static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
