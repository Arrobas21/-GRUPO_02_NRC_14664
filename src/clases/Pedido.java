package clases;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	int idPedido;
	String fecha,estado;
	Cliente cliente;
	List <DetallePedido> detalles; 
	double total;
	
	public Pedido(int idPedido, String fecha, String estado, Cliente cliente, List<DetallePedido> detalles) {
		this.idPedido = idPedido;
		this.fecha = fecha;
		this.estado = estado;
		this.cliente = cliente;
		this.detalles = ( detalles != null ) ? detalles : new ArrayList<>();
		this.total = calcularTotal();
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetallePedido> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetallePedido> detalles) {
		this.detalles = detalles;
		this.total = calcularTotal();
	}
	public double getTotal() {
		return total;
	}
	
	public void agregarDetalle(DetallePedido detalle) {
		this.detalles.add(detalle);
		this.total = calcularTotal();
		
	}

	private double calcularTotal() {
		double suma = 0;
		for (DetallePedido d : detalles ) {
			suma += d.getSubtotal();
		}
		return suma;
	}
	
	
	

}
