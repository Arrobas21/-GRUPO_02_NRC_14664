package gui;

import java.awt.EventQueue;
import clases.Producto;
import clases.DetallePedido;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class V1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
			lblNewLabel.setBounds(170, 10, 120, 12);
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
			btnAdicionar.setBounds(171, 83, 84, 20);
			contentPane.add(btnAdicionar);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(290, 83, 84, 20);
			contentPane.add(btnBuscar);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			do_btnAdicionar_actionPerformed(e);
		}
		if (e.getSource() == btnReportar) {
			do_btnReportar_actionPerformed(e);
		}
	}
	protected void do_btnReportar_actionPerformed(ActionEvent e) {
		
	}
	protected void do_btnAdicionar_actionPerformed(ActionEvent e) {
		
		String nombre = txtProducto.getText();
		double precio = Double.parseDouble(txtPrecio.getText());
		int cantidad = Integer.parseInt(txtCant.getText());

		Producto p = new Producto(1, nombre, precio);
		DetallePedido d = new DetallePedido(p, cantidad);

		   textArea.append("Producto: " + nombre + 
                   " | Precio: " + precio + 
                   " | Cantidad: " + cantidad + "\n");
	}
}
