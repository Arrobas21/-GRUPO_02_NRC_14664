package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
import clases.Pedido;
import clases.Producto;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VMain extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton bt_Clientes;
	private JButton bt_Productos;
	private JButton bt_Pedidos;
	private JButton bt_Reportes;
	private JButton bt_Salir;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Producto> listaProductos;
	private ArrayList<Pedido> listaPedidos;
	private JButton btHistorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VMain frame = new VMain();
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
	public VMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("SISTEMAS DE PEDIDOS");
			lblNewLabel.setBounds(136, 10, 141, 12);
			contentPane.add(lblNewLabel);
		}
		{
			bt_Clientes = new JButton("Clientes");
			bt_Clientes.addActionListener(this);
			bt_Clientes.setBounds(71, 61, 97, 20);
			contentPane.add(bt_Clientes);
		}
		{
			bt_Productos = new JButton("Productos");
			bt_Productos.addActionListener(this);
			bt_Productos.setBounds(244, 61, 97, 20);
			contentPane.add(bt_Productos);
		}
		{
			bt_Pedidos = new JButton("Pedidos");
			bt_Pedidos.addActionListener(this);
			bt_Pedidos.setBounds(71, 136, 97, 20);
			contentPane.add(bt_Pedidos);
		}
		{
			bt_Reportes = new JButton("Reportes");
			bt_Reportes.addActionListener(this);
			bt_Reportes.setBounds(71, 199, 97, 20);
			contentPane.add(bt_Reportes);
		}
		{
			bt_Salir = new JButton("Salir");
			bt_Salir.setBounds(244, 199, 97, 20);
			contentPane.add(bt_Salir);
		}
		{
			btHistorial = new JButton("Historial");
			btHistorial.addActionListener(this);
			btHistorial.setBounds(244, 136, 97, 20);
			contentPane.add(btHistorial);
		}
		listaClientes = new ArrayList<>();
		listaProductos = new ArrayList<>();
		listaPedidos = new ArrayList<>();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_Reportes) {
			do_bt_Reportes_actionPerformed(e);
		}
		if (e.getSource() == btHistorial) {
			do_btHistorial_actionPerformed(e);
		}
		if (e.getSource() == bt_Clientes) {
			do_bt_Clientes_actionPerformed(e);
		}
		if (e.getSource() == bt_Pedidos) {
			do_bt_Pedidos_actionPerformed(e);
		}
		if (e.getSource() == bt_Productos) {
			do_bt_Productos_actionPerformed(e);
		}
		
	}
	protected void do_bt_Productos_actionPerformed(ActionEvent e) {
		V1 ventanaproducto = new V1(listaProductos,this);
		setEnabled(false);
		ventanaproducto.setVisible(true);
	}
	protected void do_bt_Pedidos_actionPerformed(ActionEvent e) {
		
		VPedidos ventanapedidos = new VPedidos(listaClientes,listaProductos,listaPedidos,this);
		setEnabled(false);
		ventanapedidos.setVisible(true);
		
	}
	protected void do_bt_Clientes_actionPerformed(ActionEvent e) {
		v2 ventanacliente = new v2(listaClientes, this);
		setEnabled(false);
		ventanacliente.setVisible(true);
	}
	protected void do_btHistorial_actionPerformed(ActionEvent e) {
		VHistorial vhistorial = new VHistorial(listaPedidos,this);
		setEnabled(false);
		vhistorial.setVisible(true);
	}
	protected void do_bt_Reportes_actionPerformed(ActionEvent e) {
		VReportes vreportes = new VReportes(listaPedidos,this);
		setEnabled(false);
		vreportes.setVisible(true);
	}
}
