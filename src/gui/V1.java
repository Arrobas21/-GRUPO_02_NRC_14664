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
			lblNewLabel = new JLabel("SISTEMA DE PEDIDOS");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(170, 10, 147, 12);
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
			btnReportar.setBounds(41, 83, 84, 20);
			contentPane.add(btnReportar);
		}
		{
			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.addActionListener(this);
			btnAdicionar.setBounds(181, 83, 84, 20);
			contentPane.add(btnAdicionar);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(326, 82, 84, 20);
			contentPane.add(btnBuscar);
		}

	}
	public void actionPerformed(ActionEvent e) {

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
	
	protected void do_btnReportar_actionPerformed(ActionEvent e) {
		
		
		String reporte = "";

	    for (DetallePedido d : listaDetalles) {
	        reporte += "Producto: " + d.getProducto().getNombre() +
	                   " | Precio: " + d.getProducto().getPrecio() +
	                   " | Cantidad: " + d.getCantidad() + "\n";
	    }

	    textArea.setText(reporte);
		
	}
	protected void do_btnAdicionar_actionPerformed(ActionEvent e) {
		String nombre = txtProducto.getText();
		double precio = Double.parseDouble(txtPrecio.getText());
		int cantidad = Integer.parseInt(txtCant.getText());

		Producto p = new Producto(1, nombre, precio);
		DetallePedido d = new DetallePedido(p, cantidad);
			listaDetalles.add(d);
		   JOptionPane.showMessageDialog(this,"Producto agregado");
		   	
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
	                "\nPrecio: " + p.getPrecio() +
	                "\nCantidad: " + d.getCantidad()
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

}

