package clases;

public class Producto {
	int idProducto;
	String nombre;
	double precio;
	public Producto(int idProducto, String nombre, double precio) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
