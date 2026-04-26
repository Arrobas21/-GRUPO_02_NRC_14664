package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cliente;
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
	private JTextField txtNombre;
	private JLabel lblNewLabel_1;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_2;
	private JTextField txtDireccion;
	private JButton btnReportar;
	private JButton btnAdicionar;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JTextArea txtS;

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
		setBounds(100, 100, 530, 331);
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
			lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(10, 54, 63, 12);
			contentPane.add(lblNewLabel);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(56, 51, 84, 18);
			contentPane.add(txtNombre);
		}
		{
			lblNewLabel_1 = new JLabel("Telefono:");
			lblNewLabel_1.setBounds(150, 54, 56, 12);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(210, 51, 96, 18);
			contentPane.add(txtTelefono);
		}
		{
			lblNewLabel_2 = new JLabel("Dirección:");
			lblNewLabel_2.setBounds(328, 54, 63, 12);
			contentPane.add(lblNewLabel_2);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(377, 51, 129, 18);
			contentPane.add(txtDireccion);
		}
		{
			btnReportar = new JButton("Reportar");
			btnReportar.addActionListener(this);
			btnReportar.setBounds(10, 108, 84, 20);
			contentPane.add(btnReportar);
		}
		{
			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.addActionListener(this);
			btnAdicionar.setBounds(104, 108, 90, 20);
			contentPane.add(btnAdicionar);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(210, 108, 84, 20);
			contentPane.add(btnBuscar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(410, 108, 84, 20);
			contentPane.add(btnEliminar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setBounds(304, 108, 96, 20);
			contentPane.add(btnModificar);
		}
		{
			txtS = new JTextArea();
			txtS.setBounds(10, 157, 484, 124);
			contentPane.add(txtS);
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
			do_btnReportar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
	}
	private ArrayList<Cliente> listaClientes = new ArrayList<>();	
	
	public void listarClientes() {
	    txtS.setText(""); // limpiar antes de mostrar

	    for (Cliente c : listaClientes) {
	        txtS.append(
	            "ID: " + c.getIdCliente() + "\n" +
	            "Nombre: " + c.getNombre() + "\n" +
	            "Teléfono: " + c.getTelefono() + "\n" +
	            "Dirección: " + c.getDireccion() + "\n" +
	            "--------------------------\n"
	        );
	    }
	}
	
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		
		String busqueda = txtNombre.getText().trim();

		if (busqueda.isEmpty()) {
		    JOptionPane.showMessageDialog(this, "Ingrese nombre, ID o teléfono para eliminar.");
		    return;
		}

		boolean encontrado = false;

		for (int i = 0; i < listaClientes.size(); i++) {
		    Cliente c = listaClientes.get(i);

		    if (c.getNombre().equalsIgnoreCase(busqueda) ||
		        String.valueOf(c.getIdCliente()).equals(busqueda) ||
		        c.getTelefono().equals(busqueda)) {

		        int opcion = JOptionPane.showConfirmDialog(
		            this,
		            "¿Está seguro de eliminar este cliente?",
		            "Confirmar eliminación",
		            JOptionPane.YES_NO_OPTION
		        );

		        if (opcion != JOptionPane.YES_OPTION) {
		            return;
		        }

		        listaClientes.remove(i);

		        JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente.");

		        txtNombre.setText("");
		        txtTelefono.setText("");
		        txtDireccion.setText("");
		        txtS.setText("");

		        listarClientes();

		        encontrado = true;
		        break;
		    }
		}

		if (!encontrado) {
		    JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
		}
	
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		String busqueda = txtNombre.getText().trim();

		if (busqueda.isEmpty()) {
		    JOptionPane.showMessageDialog(this, "Ingrese nombre, ID o teléfono para modificar.");
		    return;
		}

		boolean encontrado = false;

		for (Cliente c : listaClientes) {
		    if (c.getNombre().equalsIgnoreCase(busqueda) ||
		        String.valueOf(c.getIdCliente()).equals(busqueda) ||
		        c.getTelefono().equals(busqueda)) {

		        String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo nombre:", c.getNombre());
		        if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) return;

		        if (!nuevoNombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
		            JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras.");
		            return;
		        }

		        String nuevoTelefono = JOptionPane.showInputDialog(this, "Nuevo teléfono:", c.getTelefono());
		        if (nuevoTelefono == null || nuevoTelefono.trim().isEmpty()) return;

		        if (!nuevoTelefono.matches("\\d{9}")) {
		            JOptionPane.showMessageDialog(this, "El teléfono debe tener 9 dígitos.");
		            return;
		        }

		        String nuevaDireccion = JOptionPane.showInputDialog(this, "Nueva dirección:", c.getDireccion());
		        if (nuevaDireccion == null || nuevaDireccion.trim().isEmpty()) return;

		        c.setNombre(nuevoNombre.trim());
		        c.setTelefono(nuevoTelefono.trim());
		        c.setDireccion(nuevaDireccion.trim());

		        JOptionPane.showMessageDialog(this, "Cliente modificado correctamente.");

		        listarClientes();

		        encontrado = true;
		        break;
		    }
		}

		if (!encontrado) {
		    JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
		}
	   
	}
	protected void do_btnReportar_actionPerformed(ActionEvent e) {
		
		String reporte = "";
		
		if (listaClientes.isEmpty()) {
			txtS.setText("");
			JOptionPane.showMessageDialog(this, "No hay productos agregados");
			return;
		}
		for (Cliente c : listaClientes) 
		{
			reporte += "Cliente: " + c.getNombre() +
	                   " | Telefóno: " + c.getTelefono() +
	                   " | Dirección: " + c.getDireccion() + "\n";
		}
		txtS.setText(reporte);
		
	}
	
	protected void do_btnAdicionar_actionPerformed(ActionEvent e) {
		
		String nombre = txtNombre.getText().trim();
		String telefóno = txtTelefono.getText().trim();
		String direccion = txtDireccion.getText().trim();
		

	    if (nombre.isEmpty() || telefóno.isEmpty() || direccion.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Complete todos los campos");
	        return;
	    }

	    if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
	        JOptionPane.showMessageDialog(this, "El nombre del cliente solo debe contener letras");
	        return;
	    }
	    
	    if (!telefóno	.matches("\\d{9}")) {
	        JOptionPane.showMessageDialog(this, "El teléfono debe tener 9 dígitos numéricos");
	        return;
	    }

	    // Evitar duplicados (por teléfono)
	    for (Cliente c : listaClientes) {
	        if (c.getTelefono().equals(telefóno)) {
	            JOptionPane.showMessageDialog(this, "El cliente ya está registrado");
	            return;
	        }
	    }

	    // Generar ID automático
	    int idCliente = listaClientes.size() + 1;

	    // Crear cliente
	    Cliente nuevo = new Cliente(idCliente, nombre, telefóno, direccion);

	    // Agregar a la lista
	    listaClientes.add(nuevo);

	    // Mensaje
	    JOptionPane.showMessageDialog(this, "Cliente registrado correctamente");

	    // Limpiar campos
	    txtNombre.setText("");
	    txtTelefono.setText("");
	    txtDireccion.setText("");
	    txtNombre.requestFocus();
	    
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		String busqueda = txtNombre.getText().trim();

		if (busqueda.isEmpty()) {
		    JOptionPane.showMessageDialog(this, "Ingrese nombre, ID o teléfono para buscar.");
		    return;
		}

		boolean encontrado = false;

		for (Cliente c : listaClientes) {
		    if (c.getNombre().equalsIgnoreCase(busqueda) ||
		        String.valueOf(c.getIdCliente()).equals(busqueda) ||
		        c.getTelefono().equals(busqueda)) {

		        txtNombre.setText(c.getNombre());
		        txtTelefono.setText(c.getTelefono());
		        txtDireccion.setText(c.getDireccion());

		        txtS.setText(
		            "ID: " + c.getIdCliente() + "\n" +
		            "Nombre: " + c.getNombre() + "\n" +
		            "Teléfono: " + c.getTelefono() + "\n" +
		            "Dirección: " + c.getDireccion()
		        );

		        encontrado = true;
		        break;
		    }
		}

		if (!encontrado) {
		    JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
		}
	}
}

