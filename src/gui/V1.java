package gui;

import java.awt.EventQueue;
import clases.Producto;
import clases.DetallePedido;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.DetallePedido;
import clases.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Font;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<clases.Producto> listaProductos = new ArrayList<>();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtProducto;
	private JLabel lblNewLabel_2;
	private JTextField txtPrecio;
	private JTextArea textArea;
	private JLabel lblNewLabel_3;
	private JTextField txtCant;
	private JButton btnReportar;
	private JButton btnAdicionar;
	private JButton btnBuscar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1 frame = new V1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public V1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("SISTEMA DE PEDIDOS - PEDIDOS");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(130, 10, 228, 12);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Producto");
			lblNewLabel_1.setBounds(10, 43, 63, 12);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtProducto = new JTextField();
			txtProducto.setBounds(65, 40, 96, 18);
			contentPane.add(txtProducto);
			txtProducto.setColumns(10);
		}
		{
			lblNewLabel_2 = new JLabel("Precio");
			lblNewLabel_2.setBounds(170, 43, 56, 12);
			contentPane.add(lblNewLabel_2);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setBounds(221, 40, 96, 18);
			contentPane.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			textArea = new JTextArea();
			textArea.setBounds(10, 113, 472, 151);
			contentPane.add(textArea);
		}
		{
			lblNewLabel_3 = new JLabel("Cantidad");
			lblNewLabel_3.setBounds(327, 43, 71, 12);
			contentPane.add(lblNewLabel_3);
		}
		{
			txtCant = new JTextField();
			txtCant.setBounds(386, 40, 96, 18);
			contentPane.add(txtCant);
			txtCant.setColumns(10);
		}
		{
			btnReportar = new JButton("Reportar");
			btnReportar.addActionListener(this);
			btnReportar.setBounds(10, 83, 84, 20);
			contentPane.add(btnReportar);
		}
		{
			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.addActionListener(this);
			btnAdicionar.setBounds(106, 83, 90, 20);
			contentPane.add(btnAdicionar);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(200, 83, 84, 20);
			contentPane.add(btnBuscar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(292, 83, 84, 20);
			contentPane.add(btnEliminar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setBounds(386, 83, 96, 20);
			contentPane.add(btnModificar);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}

		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}

		if (e.getSource() == btnAdicionar) {
			do_btnAdicionar_actionPerformed(e);
		}

		if (e.getSource() == btnReportar) {
			do_btnReportar_actionPerformed(e);}
		}
		private ArrayList<DetallePedido> listaDetalles = new ArrayList<>();	
		private JButton btnEliminar;
		private JButton btnModificar;
		
	protected void do_btnReportar_actionPerformed(ActionEvent e) {
		
		
		String reporte = "";
		
		if (listaDetalles.isEmpty()) {
			textArea.setText("");
			JOptionPane.showMessageDialog(this, "No hay productos agregados");
			return;
		}
	    for (DetallePedido d : listaDetalles) { 
	        reporte += "Producto: " + d.getProducto().getNombre() +
	                   " | Precio: " + d.getProducto().getPrecio() +
	                   " | Cantidad: " + d.getCantidad() + "\n";
	    }

	    textArea.setText(reporte);
		
	}
	protected void do_btnAdicionar_actionPerformed(ActionEvent e) {
		String nombre = txtProducto.getText().trim();
	    String precioTxt = txtPrecio.getText().trim();
	    String cantidadTxt = txtCant.getText().trim();

	    if (nombre.isEmpty() || precioTxt.isEmpty() || cantidadTxt.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Complete todos los campos");
	        return;
	    }

	    if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
	        JOptionPane.showMessageDialog(this, "El nombre del producto solo debe contener letras");
	        return;
	    }

	    double precio;
	    int cantidad;

	    try {
	        precio = Double.parseDouble(precioTxt);
	        if (precio <= 0) {
	            JOptionPane.showMessageDialog(this, "El precio debe ser mayor a 0");
	            return;
	        }
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Ingrese un precio válido");
	        return;
	    }

	    try {
	        cantidad = Integer.parseInt(cantidadTxt);
	        if (cantidad <= 0) {
	            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0");
	            return;
	        }
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida");
	        return;
	    }

	    for (DetallePedido det : listaDetalles) {
	        if (det.getProducto().getNombre().equalsIgnoreCase(nombre)) {
	            JOptionPane.showMessageDialog(this, "El producto ya está agregado");
	            return;
	        }
	    }

	    Producto p = new Producto(1, nombre, precio);
	    DetallePedido d = new DetallePedido(p, cantidad);
	    listaDetalles.add(d);

	    JOptionPane.showMessageDialog(this, "Producto agregado correctamente");
		   	
	}
	
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
	    String busqueda = txtProducto.getText().trim();
	    
	    if (busqueda.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Ingrese el nombre o ID para buscar.");
	        return;
	    }

	    boolean encontrado = false;

	    for (DetallePedido d : listaDetalles) {
	        Producto p = d.getProducto();
	        if (p.getNombre().equalsIgnoreCase(busqueda) ||
	            String.valueOf(p.getIdProducto()).equals(busqueda)) {

	            txtProducto.setText(p.getNombre());
	            txtPrecio.setText(String.valueOf(p.getPrecio()));

	            textArea.setText(
	                "Producto: " + p.getNombre() +
	                " | Precio: " + p.getPrecio() +
	                " | Cantidad: " + d.getCantidad()
	            );
	            encontrado = true;
	            break;
	        }
	    }
	    if (!encontrado) {
	        JOptionPane.showMessageDialog(this, "El producto no se encuentra en la lista de adicionados.");
	        txtPrecio.setText("");
	    }
	
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		
		String busqueda = txtProducto.getText().trim();
		
		if (busqueda.isEmpty()) 
		{
			JOptionPane.showMessageDialog(this, "Ingrese el nombre o ID para eliminar.");
	        return;
		}
		
		boolean encontrado = false;
		
		for ( int i = 0; i < listaDetalles.size(); i++) {
			DetallePedido d = listaDetalles.get(i);
			Producto p = d.getProducto();
			
			if (p.getNombre().equalsIgnoreCase(busqueda) ||
			        String.valueOf(p.getIdProducto()).equals(busqueda)) {
				listaDetalles.remove(i);
				JOptionPane.showMessageDialog(this, "Producto eliminado");

		        encontrado = true;
		        break;
			}
		}
		if (!encontrado) {
		    JOptionPane.showMessageDialog(this, "El producto no se encuentra en la lista de adicionados.");
		    txtPrecio.setText("");
		}
	
		
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		// Obtener lo que el usuario escribió en el campo de texto
		String busqueda = txtProducto.getText().trim();

		// Verificar si el campo está vacío
		if (busqueda.isEmpty()) {
		    JOptionPane.showMessageDialog(this, "Ingrese el nombre o ID del producto a modificar.");
		    return; // detener ejecución si no hay dato
		}

		// Variable para saber si se encontró el producto
		boolean encontrado = false;

		// Recorrer la lista de detalles del pedido
		for (DetallePedido d : listaDetalles) {

		    // Obtener el producto dentro del detalle
		    Producto p = d.getProducto();

		    // Comparar si coincide el nombre o el ID con lo buscado
		    if (p.getNombre().equalsIgnoreCase(busqueda) ||
		        String.valueOf(p.getIdProducto()).equals(busqueda)) {

		        // Pedir al usuario la nueva cantidad
		        String nuevaCantStr = JOptionPane.showInputDialog(this, "Ingrese la nueva cantidad:");

		        // Si el usuario cancela o deja vacío
		        if (nuevaCantStr == null || nuevaCantStr.trim().isEmpty()) {
		            JOptionPane.showMessageDialog(this, "Operación cancelada.");
		            return;
		        }

		        try {
		            // Convertir el valor ingresado a número entero
		            int nuevaCantidad = Integer.parseInt(nuevaCantStr);

		            // Validar que la cantidad sea mayor a 0
		            if (nuevaCantidad <= 0) {
		                JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.");
		                return;
		            }

		            // Modificar la cantidad del detalle
		            // Esto actualiza automáticamente el subtotal (según tu clase)
		            d.setCantidad(nuevaCantidad);

		            // Mostrar mensaje de éxito
		            JOptionPane.showMessageDialog(this, "Cantidad modificada correctamente");

		            // Marcar que sí se encontró el producto
		            encontrado = true;

		            // Salir del ciclo porque ya se encontró
		            break;

		        } catch (NumberFormatException e) {
		            // Si el usuario escribe algo que no es número
		            JOptionPane.showMessageDialog(this, "Debe ingresar un número válido.");
		            return;
		        }
		    }
		}

		// Si no se encontró el producto en la lista
		if (!encontrado) {
		    JOptionPane.showMessageDialog(this, "Producto no encontrado.");
		}

		}
	}

