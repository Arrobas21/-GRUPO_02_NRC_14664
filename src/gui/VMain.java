package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
			bt_Pedidos.setBounds(71, 136, 97, 20);
			contentPane.add(bt_Pedidos);
		}
		{
			bt_Reportes = new JButton("Reportes");
			bt_Reportes.setBounds(244, 136, 97, 20);
			contentPane.add(bt_Reportes);
		}
		{
			bt_Salir = new JButton("Salir");
			bt_Salir.setBounds(155, 199, 97, 20);
			contentPane.add(bt_Salir);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_Productos) {
			do_bt_Productos_actionPerformed(e);
		}
	}
	protected void do_bt_Productos_actionPerformed(ActionEvent e) {
		V1 ventanaproducto = new V1();
		ventanaproducto.setVisible(true);
	}
}
