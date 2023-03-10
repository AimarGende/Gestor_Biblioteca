package packLibreria;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class GestorBiblioteca {
	public static void run() throws ClassNotFoundException, SQLException, ParseException {
		Scanner sc=new Scanner(System.in);
		int opcion=0;
		do {
			Menu.mostrarMenuPrincipal();
			opcion=Integer.parseInt(sc.nextLine());
			switch (opcion) {
				case Menu.GESTIONAR_LIBROS:
					GestorLibros.run(sc);
					break;
				case Menu.GESTIONAR_SOCIOS:
					GestorSocios.run(sc);
					break;
				case Menu.GESTIONAR_PRESTAMOS:
					GestorPrestamo.run(sc);;
					break;
				default:
					break;
			}
		}while(opcion!=Menu.SALIR);
		sc.close();
		Visor.mostrarMensaje("Muchas gracias por usar nuestra app, esperemos que vuelva pronto!");
	}
}
