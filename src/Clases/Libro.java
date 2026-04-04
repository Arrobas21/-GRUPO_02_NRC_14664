package Clases;

public class Libro {
	private String titulo,autor,categoria;
	private int idlibro,cantidad;
	private boolean disponible;

	public Libro(String titulo, String autor, String categoria, int idlibro, int cantidad, boolean disponible) {
		
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.idlibro = idlibro;
		this.cantidad = cantidad;
		this.disponible = disponible;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getIdlibro() {
		return idlibro;
	}

	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
}
