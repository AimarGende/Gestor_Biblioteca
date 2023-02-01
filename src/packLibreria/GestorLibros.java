package packLibreria;

import java.sql.SQLException;
import java.util.Scanner;

public class GestorLibros {
	static void run(Scanner sc) throws ClassNotFoundException, SQLException {
		int opcion=0;
		int id=0;
		Libro libro=new Libro();
		GestorBBDD gest=new GestorBBDD();
		do {
			Menu.mostrarMenuLibros();
			opcion=Integer.parseInt(sc.nextLine());
			switch (opcion){
				case Menu.INSERTAR_LIBRO:
					System.out.println("Ha escogido insertar libro");
					
					libro=FormulariosDeDatos.pedirDatosLibro(sc);
					gest.conectar();
					gest.insertarLibro(libro);
					gest.cerrar();
					
					break;
				case Menu.ELIMINAR_LIBRO:
					System.out.println("Ha escogido eliminar libro");
					id=FormulariosDeDatos.pedirIdLibro(sc);
					gest.conectar();
					gest.eliminarLibro(id);
					gest.cerrar();
					
					break;
				case Menu.MODIFICAR_LIBRO:
					System.out.println("Ha escogido modificar libro");
					id=FormulariosDeDatos.pedirIdLibro(sc);
					gest.conectar();
					libro=gest.getLibro(id);
					libro=FormulariosDeDatos.modificarDatosLibro(libro, sc);
					gest.modificarLibro(libro, id,sc);
					gest.cerrar();
					break;
				case Menu.VER_LIBROS:
					System.out.println("Ha escogido ver libros");
					gest.conectar();
					Visor.mostrarLibros(gest.getLibros());
					gest.cerrar();
					break;
				case Menu.SALIR:
					break;
				default:
					System.out.println("Opcion equivocada, insertelo otra vez");
					break;
			}
		}while(opcion!=Menu.SALIR);
		System.out.println("Volviendo al menu principal");
	}
}
