package packLibreria;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FormulariosDeDatos {
//Seccion para libros
	static Libro pedirDatosLibro(Scanner sc) {
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
	
//Seccion para socios
	
	static Socios pedirDatosSocio(Scanner sc) {
		Socios socio=new Socios();
		System.out.println("Insertar datos del socio:");
		System.out.println("Inserte el nombre del socio:");
		socio.setNombre(sc.nextLine());
		System.out.println("Inserte el apellido del socio");
		socio.setApellido(sc.nextLine());
		System.out.println("Inserte la direccion del socio");
		socio.setDireccion(sc.nextLine());
		System.out.println("Inserte la poblacion donde vive del socio");
		socio.setPoblacion(sc.nextLine());
		System.out.println("Inserte la provincia donde vive el socio");
		socio.setProvincia(sc.nextLine());
		System.out.println("Inserte el dni del socio");
		socio.setDni(sc.nextLine());
		return socio;
	}
	
	static Socios modificarDatosSocio(Socios socio, Scanner sc) {
		System.out.println("Modificar datos del socio:");
		System.out.println("Insertar datos del socio:");
		System.out.println("Inserte el nuevo nombre del socio:");
		socio.setNombre(sc.nextLine());
		System.out.println("Inserte el nuevo apellido del socio");
		socio.setApellido(sc.nextLine());
		System.out.println("Inserte la nuevo direccion del socio");
		socio.setDireccion(sc.nextLine());
		System.out.println("Inserte la nuevo poblacion donde vive del socio");
		socio.setPoblacion(sc.nextLine());
		System.out.println("Inserte la nuevo provincia donde vive el socio");
		socio.setProvincia(sc.nextLine());
		System.out.println("Inserte el nuevo dni del socio");
		socio.setDni(sc.nextLine());
		return socio;
	}
	
	static int pedirIdSocio(Scanner sc) {
		int id=0;
		System.out.println("Inserte la id del socio");
		id=Integer.parseInt(sc.nextLine());
		return id;
	}
	
//Seccion para prestmos
	
	static Prestamos pedirDatosPrestamo(Scanner sc) throws ParseException {
		Prestamos prestamo= new Prestamos();
		SimpleDateFormat fecha= new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Insertar datos del prestamos:");
		prestamo.setId_libro(pedirIdLibro(sc));
		prestamo.setId_socio(pedirIdSocio(sc));
		System.out.println("Inserta la fecha del prestamo, el formato es dia(dd)/mes(MM)/año(yyyy)");
		prestamo.setFecha(fecha.parse(sc.nextLine()));
		prestamo.setDevuelto(false);
		return prestamo;
	}
	
	static Prestamos modificarPrestamo(Prestamos prestamo,Scanner sc) throws ParseException {
		SimpleDateFormat fecha= new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Insertar datos del prestamos:");
		prestamo.setId_libro(pedirIdLibro(sc));
		prestamo.setId_socio(pedirIdSocio(sc));
		System.out.println("Inserta la fecha del prestamo, el formato es dia(dd)/mes(MM)/año(yyyy)");
		prestamo.setFecha(fecha.parse(sc.nextLine()));
		System.out.println("Inserta si se ha devuelto el prestamo, pon 1 si se ha devuelto y 0 si no:");
		prestamo.setDevuelto(sc.nextLine()== "1" ? true:false);
		return prestamo;
	}
}
