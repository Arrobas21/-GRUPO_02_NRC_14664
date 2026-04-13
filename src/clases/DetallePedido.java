package clases;

public class DetallePedido {
	Producto producto;
	int cantidad;
	double subtotal;
	public DetallePedido(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.calcularSubtotal();
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
		calcularSubtotal();
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
		calcularSubtotal();
	}
	
	public double getSubtotal() {
		return subtotal;
	}
	private void calcularSubtotal() {
		if (producto != null) {
			this.subtotal = producto.getPrecio() * cantidad;
		}
		else {
			this.subtotal = 0;
		}
	}
	

}
