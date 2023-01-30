package packLibreria;

public class Libro {
	public int id;
	public String titulo;
	public String autor;
	public int num_pag;
	
	public Libro(int id, String titulo, String autor, int num_pag) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.num_pag = num_pag;
	}
	
	public Libro() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNum_pag() {
		return num_pag;
	}

	public void setNum_pag(int num_pag) {
		this.num_pag = num_pag;
	}

	@Override
	public String toString() {
		return "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", num_pag=" + num_pag + "]";
	}
	
	
}
