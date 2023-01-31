package packLibreria;

import java.util.Scanner;

public class FormulariosDeDatos {
	
	static Libro pedirDatos(Scanner sc) {
		Libro libro=new Libro();
		System.out.println("Insertar datos del libro:");
		System.out.println("Inserte el titulo del libro:");
		libro.setTitulo(sc.nextLine());
		System.out.println("Inserte el autor del libro:");
		libro.setAutor(sc.nextLine());
		System.out.println("Inserte el numero de paginas del libro");
		libro.setNum_pag(Integer.parseInt(sc.nextLine()));
		System.out.println("Ha insertado los datos, muchas gracias.");
		return libro;
	}
	
	static Libro modificarDatosLibro(Libro libro, Scanner sc) {
		System.out.println("Modificar datos del libro:");
		System.out.println("Inserte el nuevo titulo del libro:");
		libro.setTitulo(sc.nextLine());
		System.out.println("Inserte el nuevo autor del libro:");
		libro.setAutor(sc.nextLine());
		System.out.println("Inserte el nuevo numero de paginas del libro");
		libro.setNum_pag(Integer.parseInt(sc.nextLine()));
		System.out.println("Ha actualizado los datos, muchas gracias.");
		return libro;
	}
	
	static int pedirIdLibro(Scanner sc) {
		int id=0;
		System.out.println("Inserte la id del libro");
		id=Integer.parseInt(sc.nextLine());
		return id;
	}
}
