package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import clases.Cliente;
import clases.DetallePedido;
import clases.Producto;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VPedidos extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel Panel_Cliente;
	private JPanel Panel_Producto;
	private JPanel Panel_DetallePedido;
	private JTextField txtDni_pedido;
	private JButton bt_buscar_pedido;
	private JLabel lblNombre;
	private JLabel lblTelefno;
	private JLabel lblDireccin;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JTextField txtBuscar_pedido_producto;
	private JButton bt_buscar_pProducto;
	private JLabel lblNewLabel_2;
	private JTextField txt_cant_Pedido;
	private JButton btnNewButton;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JLabel lblNewLabel_3;
	private JTextField txt_total_pedido;
	private JButton bt_EliminarItem;
	private JButton bt_Limpiar;
	private JButton bt_GenerarPedido;
	private JButton bt_Cancelar_pedido;
	private JButton bt_Salir_pedido;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Producto> listaProductos;
	private JLabel lblDni;
	private JTextField textField_3;
	private JComboBox cbCliente;

	/**
	 * Create the frame.
	 */
	public VPedidos(ArrayList<Cliente> listaClientes,
	        ArrayList<Producto> listaProductos) {
		this.listaClientes = listaClientes;
	    this.listaProductos = listaProductos;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			Panel_Cliente = new JPanel();
			Panel_Cliente.setBounds(10, 10, 384, 146);
			Panel_Cliente.setBorder(new TitledBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null), "", TitledBorder.LEADING, TitledBorder.TOP, null, null), "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPane.add(Panel_Cliente);
			Panel_Cliente.setLayout(null);
			{
				txtDni_pedido = new JTextField();
				txtDni_pedido.setBounds(80, 25, 96, 18);
				Panel_Cliente.add(txtDni_pedido);
				txtDni_pedido.setColumns(10);
			}
			{
				bt_buscar_pedido = new JButton("BUSCAR");
				bt_buscar_pedido.addActionListener(this);
				bt_buscar_pedido.setBounds(186, 24, 84, 20);
				Panel_Cliente.add(bt_buscar_pedido);
			}
			{
				lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(10, 61, 59, 12);
				Panel_Cliente.add(lblNombre);
			}
			{
				lblTelefno = new JLabel("Teléfono:");
				lblTelefno.setBounds(10, 102, 59, 12);
				Panel_Cliente.add(lblTelefno);
			}
			{
				lblDireccin = new JLabel("Dirección:");
				lblDireccin.setBounds(10, 124, 59, 12);
				Panel_Cliente.add(lblDireccin);
			}
			{
				textField = new JTextField();
				textField.setEditable(false);
				textField.setBounds(76, 58, 244, 18);
				Panel_Cliente.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setColumns(10);
				textField_1.setBounds(76, 99, 171, 18);
				Panel_Cliente.add(textField_1);
			}
			{
				textField_2 = new JTextField();
				textField_2.setEditable(false);
				textField_2.setColumns(10);
				textField_2.setBounds(76, 121, 284, 18);
				Panel_Cliente.add(textField_2);
			}
			{
				lblDni = new JLabel("DNI:");
				lblDni.setBounds(10, 83, 59, 12);
				Panel_Cliente.add(lblDni);
			}
			{
				textField_3 = new JTextField();
				textField_3.setEditable(false);
				textField_3.setColumns(10);
				textField_3.setBounds(76, 80, 121, 18);
				Panel_Cliente.add(textField_3);
			}
			{
				cbCliente = new JComboBox();
				cbCliente.setModel(new DefaultComboBoxModel(new String[] {"DNI", "Nombre"}));
				cbCliente.setBounds(10, 24, 60, 20);
				Panel_Cliente.add(cbCliente);
			}
		}
		{
			Panel_Producto = new JPanel();
			Panel_Producto.setBounds(10, 159, 384, 278);
			Panel_Producto.setBorder(new TitledBorder(null, "Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPane.add(Panel_Producto);
			Panel_Producto.setLayout(null);
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 58, 347, 177);
				Panel_Producto.add(scrollPane);
				{
					table = new JTable();
					table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ID", "Producto", "Precio", "Stock"
						}
					));
					scrollPane.setViewportView(table);
				}
			}
			{
				lblNewLabel_1 = new JLabel("Buscar: ");
				lblNewLabel_1.setBounds(10, 33, 44, 12);
				Panel_Producto.add(lblNewLabel_1);
			}
			{
				txtBuscar_pedido_producto = new JTextField();
				txtBuscar_pedido_producto.setBounds(64, 30, 96, 18);
				Panel_Producto.add(txtBuscar_pedido_producto);
				txtBuscar_pedido_producto.setColumns(10);
			}
			{
				bt_buscar_pProducto = new JButton("BUSCAR");
				bt_buscar_pProducto.setBounds(173, 29, 84, 20);
				Panel_Producto.add(bt_buscar_pProducto);
			}
			{
				lblNewLabel_2 = new JLabel("Cantidad:");
				lblNewLabel_2.setBounds(10, 249, 61, 12);
				Panel_Producto.add(lblNewLabel_2);
			}
			{
				txt_cant_Pedido = new JTextField();
				txt_cant_Pedido.setBounds(71, 246, 49, 18);
				Panel_Producto.add(txt_cant_Pedido);
				txt_cant_Pedido.setColumns(10);
			}
			{
				btnNewButton = new JButton("Agregar");
				btnNewButton.setBounds(130, 245, 84, 20);
				Panel_Producto.add(btnNewButton);
			}
		}
		{
			Panel_DetallePedido = new JPanel();
			Panel_DetallePedido.setBounds(404, 10, 350, 325);
			Panel_DetallePedido.setBorder(new TitledBorder(null, "Detalle Pedido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPane.add(Panel_DetallePedido);
			Panel_DetallePedido.setLayout(null);
			{
				scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(10, 29, 330, 149);
				Panel_DetallePedido.add(scrollPane_1);
				{
					table_1 = new JTable();
					table_1.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Producto", "Cantidad", "Precio", "Subtotal"
						}
					));
					scrollPane_1.setViewportView(table_1);
				}
			}
			{
				lblNewLabel_3 = new JLabel("Total:");
				lblNewLabel_3.setBounds(10, 217, 44, 12);
				Panel_DetallePedido.add(lblNewLabel_3);
			}
			{
				txt_total_pedido = new JTextField();
				txt_total_pedido.setEditable(false);
				txt_total_pedido.setBounds(47, 214, 88, 18);
				Panel_DetallePedido.add(txt_total_pedido);
				txt_total_pedido.setColumns(10);
			}
			{
				bt_EliminarItem = new JButton("Eliminar Item");
				bt_EliminarItem.setBounds(240, 214, 100, 18);
				Panel_DetallePedido.add(bt_EliminarItem);
			}
			{
				bt_Limpiar = new JButton("Limpiar");
				bt_Limpiar.setBounds(142, 213, 88, 21);
				Panel_DetallePedido.add(bt_Limpiar);
			}
			{
				bt_GenerarPedido = new JButton("GENERAR PEDIDO");
				bt_GenerarPedido.addActionListener(this);
				bt_GenerarPedido.setBounds(99, 271, 150, 32);
				Panel_DetallePedido.add(bt_GenerarPedido);
			}
		}
		{
			bt_Cancelar_pedido = new JButton("Cancelar");
			bt_Cancelar_pedido.setBounds(438, 366, 84, 20);
			contentPane.add(bt_Cancelar_pedido);
		}
		{
			bt_Salir_pedido = new JButton("Salir");
			bt_Salir_pedido.setBounds(628, 366, 84, 20);
			contentPane.add(bt_Salir_pedido);
		}
		

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_buscar_pedido) {
			do_bt_buscar_pedido_actionPerformed(e);
		}
		if (e.getSource() == bt_GenerarPedido) {
			do_bt_total_2_actionPerformed(e);
		}
	}
	protected void do_bt_total_2_actionPerformed(ActionEvent e) {
	}
	protected void do_bt_buscar_pedido_actionPerformed(ActionEvent e) {
		
		String tipoBusqueda = cbCliente.getSelectedItem().toString();
		String valor = txtDni_pedido.getText().trim();
		boolean encontrado = false;
		if(tipoBusqueda.equals("DNI")) {

		    for(Cliente c : listaClientes) {

		        if(c.getDni().equals(valor)) {

		        	textField.setText(c.getNombre());
	                textField_1.setText(c.getTelefono());
	                textField_2.setText(c.getDireccion());

	                encontrado = true;
	                break;
		        }
		    }

		} else if(tipoBusqueda.equals("Nombre")) {

		    for(Cliente c : listaClientes) {

		        if(c.getNombre().equalsIgnoreCase(valor)) {

		        	textField.setText(c.getNombre());
	                textField_1.setText(c.getTelefono());
	                textField_2.setText(c.getDireccion());

	                encontrado = true;
	                break;
		        }
		    }
		}
		
		if(!encontrado) {

	        JOptionPane.showMessageDialog(this,
	                "Cliente no encontrado");

	        textField.setText("");
	        textField_1.setText("");
	        textField_2.setText("");
	    }

	}
}
