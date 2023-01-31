package packLibreria;

import java.util.Scanner;

public class GestorLibros {
	static void run(Scanner sc) {
		int opcion=0;
		do {
			Menu.mostrarMenuLibros();
			opcion=Integer.parseInt(sc.nextLine());
			switch (opcion){
				case Menu.INSERTAR_LIBRO:
					System.out.println("Ha escogido insertar libro");
					break;
				case Menu.ELIMINAR_LIBRO:
					System.out.println("Ha escogido eliminar libro");
					break;
				case Menu.MODIFICAR_LIBRO:
					System.out.println("Ha escogido modificar libro");
					break;
				case Menu.VER_LIBROS:
					System.out.println("Ha escogido ver libros");
					break;
				case Menu.SALIR:
					System.out.println("Saliendo del menu...");
					break;
				default:
					System.out.println("Opcion equivocada");
					break;
			}
		}while(opcion!=Menu.SALIR);
	}
}
