package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
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
	private ArrayList<Cliente> listaClientes;
	private JTextField txtDni;
	private JLabel lblDni;
	private JButton bt_Salir;
	private JFrame ventanaPrincipal;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelo;

	/**
	 * Create the frame.
	 */
	public v2(ArrayList<Cliente> listaClientes,JFrame ventanaPrincipal) {
		this.listaClientes = listaClientes;
		this.ventanaPrincipal = ventanaPrincipal;
		
		setTitle("CLIENTES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		{
			lblSistemaDeClientes = new JLabel("SISTEMA DE CLIENTES");
			lblSistemaDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSistemaDeClientes.setBounds(180, 10, 170, 12);
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
			txtNombre.setBounds(70, 51, 100, 18);
			contentPane.add(txtNombre);
		}
		{
			lblDni = new JLabel("DNI:");
			lblDni.setBounds(180, 54, 40, 12);
			contentPane.add(lblDni);
		}
		{
			txtDni = new JTextField();
			txtDni.setColumns(10);
			txtDni.setBounds(210, 51, 90, 18);
			contentPane.add(txtDni);
		}
		{
			lblNewLabel_1 = new JLabel("Teléfono:");
			lblNewLabel_1.setBounds(310, 54, 60, 12);
			contentPane.add(lblNewLabel_1);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(375, 51, 120, 18);
			contentPane.add(txtTelefono);
		}
		{
			lblNewLabel_2 = new JLabel("Dirección:");
			lblNewLabel_2.setBounds(10, 95, 63, 12);
			contentPane.add(lblNewLabel_2);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(80, 92, 415, 18);
			contentPane.add(txtDireccion);
		}
		{
			btnReportar = new JButton("Reportar");
			btnReportar.addActionListener(this);
			btnReportar.setBounds(10, 127, 84, 20);
			contentPane.add(btnReportar);
		}
		{
			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.addActionListener(this);
			btnAdicionar.setBounds(106, 127, 90, 20);
			contentPane.add(btnAdicionar);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(208, 127, 84, 20);
			contentPane.add(btnBuscar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(this);
			btnModificar.setBounds(304, 127, 96, 20);
			contentPane.add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(412, 127, 84, 20);
			contentPane.add(btnEliminar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 165, 515, 135);
			contentPane.add(scrollPane);

			table = new JTable();
			table.setAutoCreateRowSorter(true);
			table.setDefaultEditor(Object.class, null);

			modelo = new DefaultTableModel(
					new Object[][] {},
					new String[] {"ID", "Nombre", "DNI", "Teléfono", "Dirección"}) {
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			table.setModel(modelo);
			scrollPane.setViewportView(table);
		}
		{
			bt_Salir = new JButton("Salir");
			bt_Salir.addActionListener(this);
			bt_Salir.setBounds(220, 315, 84, 20);
			contentPane.add(bt_Salir);
		}

		// Mostrar clientes al abrir
		listarClientesEnTabla();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_Salir) {
			do_bt_Salir_actionPerformed(e);
		}
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

	// =========================
	// MÉTODOS DE TABLA / APOYO
	// =========================

	private void listarClientesEnTabla() {
		modelo.setRowCount(0);

		for (Cliente c : listaClientes) {
			modelo.addRow(new Object[] {
				c.getIdCliente(),
				c.getNombre(),
				c.getDni(),
				c.getTelefono(),
				c.getDireccion()
			});
		}
	}

	private void mostrarClienteEnCampos(Cliente c) {
		txtNombre.setText(c.getNombre());
		txtDni.setText(c.getDni());
		txtTelefono.setText(c.getTelefono());
		txtDireccion.setText(c.getDireccion());
	}

	private void limpiarCampos() {
		txtNombre.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		txtNombre.requestFocus();
	}

	public void guardarClientes() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("clientes.txt"));

			for (Cliente c : listaClientes) {
				pw.println(
					c.getIdCliente() + ";" +
					c.getNombre() + ";" +
					c.getDni() + ";" +
					c.getTelefono() + ";" +
					c.getDireccion()
				);
			}

			pw.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error al guardar archivo");
		}
	}

	private Cliente buscarCliente(String busqueda) {
		for (Cliente c : listaClientes) {
			if (c.getNombre().equalsIgnoreCase(busqueda) ||
				String.valueOf(c.getIdCliente()).equals(busqueda) ||
				c.getTelefono().equals(busqueda) ||
				c.getDni().equals(busqueda)) {
				return c;
			}
		}
		return null;
	}

	// =========================
	// BOTONES
	// =========================

	protected void do_btnReportar_actionPerformed(ActionEvent e) {
		if (listaClientes.isEmpty()) {
			modelo.setRowCount(0);
			JOptionPane.showMessageDialog(this, "No hay clientes registrados");
			return;
		}

		listarClientesEnTabla();
	}

	protected void do_btnAdicionar_actionPerformed(ActionEvent e) {
		String dni = txtDni.getText().trim();
		String nombre = txtNombre.getText().trim();
		String telefono = txtTelefono.getText().trim();
		String direccion = txtDireccion.getText().trim();

		if (dni.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Complete todos los campos");
			return;
		}

		// Validar DNI
		if (!dni.matches("\\d{8}")) {
			JOptionPane.showMessageDialog(this, "El DNI debe tener 8 dígitos numéricos");
			return;
		}

		// Validar nombre
		if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
			JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras");
			return;
		}

		// Validar teléfono
		if (!telefono.matches("\\d{9}")) {
			JOptionPane.showMessageDialog(this, "El teléfono debe tener 9 dígitos numéricos");
			return;
		}

		// DNI duplicado
		for (Cliente c : listaClientes) {
			if (c.getDni().equals(dni)) {
				JOptionPane.showMessageDialog(this, "El DNI ya está registrado");
				return;
			}
		}

		// Teléfono duplicado
		for (Cliente c : listaClientes) {
			if (c.getTelefono().equals(telefono)) {
				JOptionPane.showMessageDialog(this, "El teléfono ya está registrado");
				return;
			}
		}

		int idCliente = listaClientes.size() + 1;

		Cliente nuevo = new Cliente(idCliente, nombre, dni, telefono, direccion);
		listaClientes.add(nuevo);

		guardarClientes();
		listarClientesEnTabla();

		JOptionPane.showMessageDialog(this, "Cliente registrado correctamente");
		limpiarCampos();
	}

	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		String busqueda = txtNombre.getText().trim();

		// si txtNombre está vacío, intentar con DNI
		if (busqueda.isEmpty()) {
			busqueda = txtDni.getText().trim();
		}

		// si también está vacío, intentar con teléfono
		if (busqueda.isEmpty()) {
			busqueda = txtTelefono.getText().trim();
		}

		if (busqueda.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese nombre, DNI, ID o teléfono para buscar.");
			return;
		}

		Cliente c = buscarCliente(busqueda);

		if (c == null) {
			JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
			return;
		}

		mostrarClienteEnCampos(c);

		// mostrar solo el cliente encontrado en la tabla
		modelo.setRowCount(0);
		modelo.addRow(new Object[] {
			c.getIdCliente(),
			c.getNombre(),
			c.getDni(),
			c.getTelefono(),
			c.getDireccion()
		});
	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		String busqueda = txtNombre.getText().trim();

		if (busqueda.isEmpty()) {
			busqueda = txtDni.getText().trim();
		}
		if (busqueda.isEmpty()) {
			busqueda = txtTelefono.getText().trim();
		}

		if (busqueda.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese nombre, DNI o teléfono para modificar.");
			return;
		}

		Cliente c = buscarCliente(busqueda);

		if (c == null) {
			JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
			return;
		}

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

		// validar teléfono duplicado si cambió
		for (Cliente cli : listaClientes) {
			if (cli != c && cli.getTelefono().equals(nuevoTelefono.trim())) {
				JOptionPane.showMessageDialog(this, "El teléfono ya está registrado en otro cliente.");
				return;
			}
		}

		c.setNombre(nuevoNombre.trim());
		c.setTelefono(nuevoTelefono.trim());
		c.setDireccion(nuevaDireccion.trim());

		guardarClientes();
		listarClientesEnTabla();
		mostrarClienteEnCampos(c);

		JOptionPane.showMessageDialog(this, "Cliente modificado correctamente.");
	}

	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		String busqueda = txtNombre.getText().trim();

		if (busqueda.isEmpty()) {
			busqueda = txtDni.getText().trim();
		}
		if (busqueda.isEmpty()) {
			busqueda = txtTelefono.getText().trim();
		}

		if (busqueda.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Ingrese nombre, DNI, ID o teléfono para eliminar.");
			return;
		}

		Cliente c = buscarCliente(busqueda);

		if (c == null) {
			JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
			return;
		}

		int opcion = JOptionPane.showConfirmDialog(
			this,
			"¿Está seguro de eliminar este cliente?",
			"Confirmar eliminación",
			JOptionPane.YES_NO_OPTION
		);

		if (opcion != JOptionPane.YES_OPTION) {
			return;
		}

		listaClientes.remove(c);

		guardarClientes();
		listarClientesEnTabla();
		limpiarCampos();

		JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente.");
	}

	protected void do_bt_Salir_actionPerformed(ActionEvent e) {
		ventanaPrincipal.setEnabled(true);
	    ventanaPrincipal.toFront();
	    dispose();
	}
}
