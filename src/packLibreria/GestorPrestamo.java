package packLibreria;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class GestorPrestamo {
	static void run(Scanner sc) throws ClassNotFoundException, SQLException, ParseException {
		int opcion=0;
		int id_libro=0, id_socio=0;
		Prestamos prestamo=new Prestamos();
		GestorBBDD gest=new GestorBBDD();
		do {
			boolean disponible=false;
			Menu.mostrarMenuPrestamos();
			opcion=Integer.parseInt(sc.nextLine());
			switch (opcion){
				case Menu.REALIZAR_PRESTAMO:
					System.out.println("Ha escogido realizar prestamo");
					
					prestamo=FormulariosDeDatos.pedirDatosPrestamo(sc);
					gest.conectar();
					gest.insertarPrestamo(prestamo);
					gest.cerrar();
					
					break;
				case Menu.DEVOLVER_LIBRO:
					System.out.println("Ha escogido devolver libro");
					id_libro=FormulariosDeDatos.pedirIdLibro(sc);
					gest.conectar();
					gest.devolverLibro(id_libro);
					gest.cerrar();
					
					break;
				case Menu.CONSULTAR_PRESTAMOS_SOCIO:
					System.out.println("Ha escogido consultar prestamo de un socio");
					id_socio=FormulariosDeDatos.pedirIdSocio(sc);
					gest.conectar();
					Visor.mostrarPrestamos(gest.consultarPrestamoSocio(id_socio));
					gest.consultarPrestamoSocio(id_socio);
					gest.cerrar();
					break;
				case Menu.CONSULTAR_DISPONIBILIDAD_LIBRO:
					System.out.println("Ha escogido consultar disponibilidad de libro");
					id_libro=FormulariosDeDatos.pedirIdLibro(sc);
					gest.conectar();
					disponible=gest.consultarDisponibilidadDeLibro(id_libro);
					if(disponible) {
						System.out.println("El libro esta disponible");
					}
					else {
						System.out.println("El libro no esta disponible");
					}
					gest.cerrar();
					break;
				case Menu.CONSULTAR_LIBROS_NO_DEVUELTOS:
					System.out.println("Ha escogido consultar libros no devueltos");
					gest.conectar();
					Visor.mostrarPrestamos(gest.consultarLibrosNoDevueltos());
					gest.cerrar();
					break;
				default:
					System.out.println("Opcion equivocada, insertelo otra vez");
					break;
			}
		}while(opcion!=Menu.SALIR);
		System.out.println("Volviendo al menu principal");
	}
}
