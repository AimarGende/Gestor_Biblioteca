package packLibreria;

public class Menu {
	final static int GESTIONAR_LIBROS=1;
	final static int GESTIONAR_SOCIOS=2;
	final static int GESTIONAR_PRESTAMOS=3;
	
	final static int INSERTAR_LIBRO=1;
	final static int ELIMINAR_LIBRO=2;
	final static int MODIFICAR_LIBRO=3;
	final static int VER_LIBROS=4;

	
	final static int VER_SOCIOS=1;
	
	final static int REALIZAR_PRESTAMO=1;
	
	final static int SALIR=0;
	static void mostrarMenuPrincipal() {
		System.out.println("--MENU PRINCIPAL--");
		System.out.println(GESTIONAR_LIBROS+". Gestionar Libros");
		System.out.println( GESTIONAR_SOCIOS+". Gestionar Socios");
		System.out.println(GESTIONAR_PRESTAMOS+". Gestionar Prestamos");
		System.out.println(SALIR+". Salir");
		System.out.println("Escoja una opcion:");
	}

	static void mostrarMenuLibros() {
		System.out.println("--MENU LIBROS--");
		System.out.println(INSERTAR_LIBRO+". Insertar Libro");
		System.out.println(ELIMINAR_LIBRO+". Eliminar Libro");
		System.out.println(MODIFICAR_LIBRO+". Modificar libro");
		System.out.println(VER_LIBROS+". Ver libros");
		System.out.println(SALIR+". Salir");
		System.out.println("Escoja una opcion:");
	}

	static void mostrarMenuSocios() {
		System.out.println("--MENU SOCIOS--");
		System.out.println(VER_SOCIOS+". Ver Socios");

	}

	static void mostrarMenuPrestamos() {
		System.out.println("--MENU PRESTAMOS--");
		System.out.println( REALIZAR_PRESTAMO+". Realizar préstamo");

	}
}
