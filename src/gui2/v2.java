package gui2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.DetallePedido;
import clases.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class v2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblSistemaDeClientes;
	private JLabel lblNewLabel;
	private JTextField txtProducto;
	private JLabel lblNewLabel_1;
	private JTextField txtPrecio;
	private JLabel lblNewLabel_2;
	private JTextField txtCantidad;
	private JButton btnReportar;
	private JButton btnAdicionar;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					v2 frame = new v2();
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
	public v2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblSistemaDeClientes = new JLabel("SISTEMA DE CLIENTES");
			lblSistemaDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSistemaDeClientes.setBounds(127, 11, 228, 12);
			contentPane.add(lblSistemaDeClientes);
		}
		{
			lblNewLabel = new JLabel("Producto");
			lblNewLabel.setBounds(0, 54, 63, 12);
			contentPane.add(lblNewLabel);
		}
		{
			txtProducto = new JTextField();
			txtProducto.setColumns(10);
			txtProducto.setBounds(44, 51, 96, 18);
			contentPane.add(txtProducto);
		}
		{
			lblNewLabel_1 = new JLabel("Precio");
			lblNewLabel_1.setBounds(146, 54, 56, 12);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setColumns(10);
			txtPrecio.setBounds(175, 51, 96, 18);
			contentPane.add(txtPrecio);
		}
		{
			lblNewLabel_2 = new JLabel("Cantidad");
			lblNewLabel_2.setBounds(281, 54, 71, 12);
			contentPane.add(lblNewLabel_2);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setColumns(10);
			txtCantidad.setBounds(328, 50, 96, 18);
			contentPane.add(txtCantidad);
		}
		{
			btnReportar = new JButton("Reportar");
			btnReportar.setBounds(0, 98, 84, 20);
			contentPane.add(btnReportar);
		}
		{
			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.setBounds(82, 98, 90, 20);
			contentPane.add(btnAdicionar);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(175, 98, 84, 20);
			contentPane.add(btnBuscar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(256, 98, 84, 20);
			contentPane.add(btnEliminar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setBounds(338, 97, 96, 20);
			contentPane.add(btnModificar);
		}
		{
			textArea = new JTextArea();
			textArea.setBounds(-14, 121, 472, 151);
			contentPane.add(textArea);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
	}
	private ArrayList<DetallePedido> listaDetalles = new ArrayList<>();	
	
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
	    String buscar = txtProducto.getText().trim();
	    
	    if (buscar.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Ingrese el nombre/ID del producto a modificar.");
	        return;
	    }

	    boolean modificado = false;

	    for (clases.Producto p : listaProductos) {
	        if (String.valueOf(p.getIdProducto()).equals(buscar) || 
	            p.getNombre().equalsIgnoreCase(buscar)) {
	            
	            try {

	                double nuevoPrecio = Double.parseDouble(txtPrecio.getText());
	                
	                p.setNombre(txtProducto.getText());
	                p.setPrecio(nuevoPrecio);
	                
	                textArea.append("Producto actualizado: " + p.getNombre() + "\n");
	                JOptionPane.showMessageDialog(this, "Datos actualizados correctamente.");
	                
	                modificado = true;
	                break;
	            } catch (NumberFormatException ex) {
	                JOptionPane.showMessageDialog(this, "Error: El precio debe ser un número.");
	                return;
	            }
	        }
	    }

	    if (!modificado) {
	        JOptionPane.showMessageDialog(this, "No se encontró el producto para modificar.");
	    }
	}
}

