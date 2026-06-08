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
import clases.Pedido;
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
	private JTextField txtNom;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;
	private JTextField txtBuscar_pedido_producto;
	private JButton bt_buscar_pProducto;
	private JLabel lblNewLabel_2;
	private JTextField txt_cant_Pedido;
	private JButton bt_AgregarProducto;
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
	private ArrayList<Pedido> listaPedidos;
	private ArrayList<DetallePedido> listaDetallesPedido;
	private JLabel lblDni;
	private JTextField txtDNI;
	private JComboBox cbCliente;

	/**
	 * Create the frame.
	 */
	public VPedidos(ArrayList<Cliente> listaClientes,
	        ArrayList<Producto> listaProductos,ArrayList<Pedido> listaPedidos) {
		setTitle("PEDIDOS");
		this.listaClientes = listaClientes;
	    this.listaProductos = listaProductos;
	    this.listaPedidos = listaPedidos;
	    listarProductos();
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
				txtNom = new JTextField();
				txtNom.setEditable(false);
				txtNom.setBounds(76, 58, 244, 18);
				Panel_Cliente.add(txtNom);
				txtNom.setColumns(10);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setEditable(false);
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(76, 99, 171, 18);
				Panel_Cliente.add(txtTelefono);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setEditable(false);
				txtDireccion.setColumns(10);
				txtDireccion.setBounds(76, 121, 284, 18);
				Panel_Cliente.add(txtDireccion);
			}
			{
				lblDni = new JLabel("DNI:");
				lblDni.setBounds(10, 83, 59, 12);
				Panel_Cliente.add(lblDni);
			}
			{
				txtDNI = new JTextField();
				txtDNI.setEditable(false);
				txtDNI.setColumns(10);
				txtDNI.setBounds(76, 80, 121, 18);
				Panel_Cliente.add(txtDNI);
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
				bt_buscar_pProducto.addActionListener(this);
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
				bt_AgregarProducto = new JButton("Agregar");
				bt_AgregarProducto.addActionListener(this);
				bt_AgregarProducto.setBounds(130, 245, 84, 20);
				Panel_Producto.add(bt_AgregarProducto);
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
		if (e.getSource() == bt_buscar_pProducto) {
			do_bt_buscar_pProducto_actionPerformed(e);
		}
		if (e.getSource() == bt_AgregarProducto) {
			do_bt_AgregarProducto_actionPerformed(e);
		}
		if (e.getSource() == bt_buscar_pedido) {
			do_bt_buscar_pedido_actionPerformed(e);
		}
		if (e.getSource() == bt_GenerarPedido) {
			do_bt_total_2_actionPerformed(e);
		}
	}
	
	public void listarProductos() {

	    DefaultTableModel modelo =
	        (DefaultTableModel) table.getModel();

	    modelo.setRowCount(0);

	    for(Producto p : listaProductos) {

	        modelo.addRow(new Object[] {
	            p.getIdProducto(),
	            p.getNombre(),
	            p.getPrecio(),
	            p.getStock()
	        });
	    }
	}
	
	
	protected void do_bt_total_2_actionPerformed(ActionEvent e) {
		
	}
	protected void do_bt_buscar_pedido_actionPerformed(ActionEvent e) {
		
		String tipoBusqueda = cbCliente.getSelectedItem().toString();
	    String valor = txtDni_pedido.getText().trim();

	    // Validar campo vacío
	    if (valor.isEmpty()) {

	        JOptionPane.showMessageDialog(this,
	                "Ingrese un dato para buscar");

	        return;
	    }

	    // Limpiar campos antes de buscar
	    txtNom.setText("");
	    txtTelefono.setText("");
	    txtDireccion.setText("");

	    Cliente clienteEncontrado = null;

	    if (tipoBusqueda.equals("DNI")) {

	        for (Cliente c : listaClientes) {

	            if (c.getDni().equals(valor)) {

	                clienteEncontrado = c;
	                break;
	            }
	        }

	    } else if (tipoBusqueda.equals("Nombre")) {

	        for (Cliente c : listaClientes) {

	            if (c.getNombre().equalsIgnoreCase(valor)) {

	                clienteEncontrado = c;
	                break;
	            }
	        }
	    }

	    if (clienteEncontrado != null) {

	        txtNom.setText(clienteEncontrado.getNombre());
	        txtTelefono.setText(clienteEncontrado.getTelefono());
	        txtDireccion.setText(clienteEncontrado.getDireccion());

	    } else {

	        JOptionPane.showMessageDialog(this,
	                "Cliente no encontrado");
	    }

	}
	protected void do_bt_AgregarProducto_actionPerformed(ActionEvent e) {
		
		int fila = table.getSelectedRow();
		
		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un producto");
			return;
		}
		
		String textoCantidad = txt_cant_Pedido.getText().trim();
		
		if (textoCantidad.isEmpty()) {

	        JOptionPane.showMessageDialog(this,
	                "Ingrese una cantidad");

	        return;
	    }
		
		int cantidad;

	    try {

	        cantidad = Integer.parseInt(textoCantidad);

	    } catch (NumberFormatException ex) {

	        JOptionPane.showMessageDialog(this,
	                "La cantidad debe ser numérica");

	        return;
	    }
	    
	    if (cantidad <= 0) {

	        JOptionPane.showMessageDialog(this,
	                "La cantidad debe ser mayor a cero");

	        return;
	    }

	    int idProducto = (Integer) table.getValueAt(fila, 0);
	    
	    Producto productoseleccionado = null;
	    
	    for (Producto p : listaProductos) {

	        if (p.getIdProducto() == idProducto) {

	            productoseleccionado = p;
	            break;
	        }
	    }
	    
	    if (productoseleccionado == null) {

	        JOptionPane.showMessageDialog(this,
	                "Producto no encontrado");

	        return;
	    }

	    if (cantidad > productoseleccionado.getStock()) {

	        JOptionPane.showMessageDialog(this,
	                "Stock insuficiente");

	        return;
	    }
	    
	    DetallePedido detalle =
	            new DetallePedido(productoseleccionado, cantidad);

	    listaDetallesPedido.add(detalle);

	    DefaultTableModel modelo =
	            (DefaultTableModel) table_1.getModel();

	    modelo.addRow(new Object[] {
	            productoseleccionado.getNombre(),
	            cantidad,
	            productoseleccionado.getPrecio(),
	            detalle.getSubtotal()
	    });

	    double total = 0;

	    for (DetallePedido d : listaDetallesPedido) {

	        total += d.getSubtotal();
	    }

	    txt_total_pedido.setText(String.format("%.2f", total));

	    txt_cant_Pedido.setText("");
	    txt_cant_Pedido.requestFocus();
		
	}
	protected void do_bt_buscar_pProducto_actionPerformed(ActionEvent e) {
		String nombre = txtBuscar_pedido_producto.getText().trim();

	    DefaultTableModel modelo =
	            (DefaultTableModel) table.getModel();

	    modelo.setRowCount(0);

	    // Si no escribe nada, muestra todos
	    if(nombre.isEmpty()) {

	        for(Producto p : listaProductos) {

	            modelo.addRow(new Object[] {
	                    p.getIdProducto(),
	                    p.getNombre(),
	                    p.getPrecio(),
	                    p.getStock()
	            });
	        }

	        return;
	    }

	    boolean encontrado = false;

	    for(Producto p : listaProductos) {

	        if(p.getNombre().toLowerCase()
	                .contains(nombre.toLowerCase())) {

	            modelo.addRow(new Object[] {
	                    p.getIdProducto(),
	                    p.getNombre(),
	                    p.getPrecio(),
	                    p.getStock()
	            });

	            encontrado = true;
	        }
	    }

	    if(!encontrado) {

	        JOptionPane.showMessageDialog(this,
	                "Producto no encontrado");
	    }
	}
}
