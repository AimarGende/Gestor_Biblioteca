package packLibreria;

import java.sql.SQLException;
import java.util.Scanner;

public class GestorSocios {
	static void run(Scanner sc) throws ClassNotFoundException, SQLException {
		
		int opcion=0;
		int id=0;
		Socios socio=new Socios();
		GestorBBDD gest=new GestorBBDD();
		do {
			Menu.mostrarMenuSocios();
			opcion=Integer.parseInt(sc.nextLine());
			switch (opcion){
				case Menu.INSERTAR_SOCIO:
					System.out.println("Ha escogido insertar socio");
					
					socio=FormulariosDeDatos.pedirDatosSocio(sc);
					gest.conectar();
					gest.insertarSocio(socio);
					gest.cerrar();
					
					break;
				case Menu.ELIMINAR_SOCIO:
					System.out.println("Ha escogido eliminar socio");
					id=FormulariosDeDatos.pedirIdSocio(sc);
					gest.conectar();
					gest.eliminarSocio(id);
					gest.cerrar();
					
					break;
				case Menu.MODIFICAR_LIBRO:
					System.out.println("Ha escogido modificar socio");
					id=FormulariosDeDatos.pedirIdSocio(sc);
					gest.conectar();
					socio=gest.getSocio(id);
					socio=FormulariosDeDatos.modificarDatosSocio(socio, sc);
					gest.modificarSocio(socio, id, sc);
					gest.cerrar();
					break;
				case Menu.VER_LIBROS:
					System.out.println("Ha escogido ver socios");
					gest.conectar();
					Visor.mostrarSocios(gest.getSocios());
					gest.cerrar();
					break;
				case Menu.SALIR:
					System.out.println("Saliendo del menu...");
					break;
				default:
					System.out.println("Opcion equivocada, insertelo otra vez");
					break;
			}
		}while(opcion!=Menu.SALIR);
			
	}
}
