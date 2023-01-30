package packLibreria;

import java.util.Scanner;

public class GestorLibros {
	static void run(Scanner sc) {
		int opcion=0;
		do {
			Menu.mostrarMenuLibros();
			opcion=Integer.parseInt(sc.nextLine());
			switch (opcion){
				case 1:
					System.out.println("Ha escogido insertar libro");
					break;
				case 2:
					System.out.println("Ha escogido eliminar libro");
					break;
				case 3:
					System.out.println("Ha escogido ver libros");
					break;
				case 0:
					break;
				default:
					System.out.println("Opcion equivocada");
					break;
			}
		}while(opcion!=0);
	}
}
