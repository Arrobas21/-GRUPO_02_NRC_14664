package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import clases.DetallePedido;
import clases.Pedido;

public class VHistorial extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtBuscarPed;
	private JLabel lblNewLabel_1;
	private JTable table;
	private JComboBox<String> cbFecha;
	private JButton btDetalle;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JButton btnVolver;
	private JScrollPane scrollPane;
	private JFrame ventanaPrincipal;

	private ArrayList<Pedido> listaPedidos;
	private DefaultTableModel modelo;

	/**
	 * Create the frame.
	 */
	public VHistorial(ArrayList<Pedido> listaPedidos, JFrame ventanaPrincipal) {
		this.listaPedidos = listaPedidos;
		this.ventanaPrincipal = ventanaPrincipal;

		setTitle("HISTORIAL DE PEDIDOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Buscar:");
		lblNewLabel.setBounds(10, 10, 69, 12);
		contentPane.add(lblNewLabel);

		txtBuscarPed = new JTextField();
		txtBuscarPed.setBounds(54, 7, 127, 18);
		contentPane.add(txtBuscarPed);
		txtBuscarPed.setColumns(10);

		lblNewLabel_1 = new JLabel("Filtrar por día:");
		lblNewLabel_1.setBounds(10, 35, 85, 12);
		contentPane.add(lblNewLabel_1);

		cbFecha = new JComboBox<>();
		cbFecha.setBounds(87, 32, 120, 20);
		contentPane.add(cbFecha);

		btDetalle = new JButton("Ver Detalle");
		btDetalle.setBounds(10, 272, 100, 20);
		contentPane.add(btDetalle);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(125, 272, 94, 20);
		contentPane.add(btnModificar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(239, 272, 99, 20);
		contentPane.add(btnCancelar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(348, 272, 94, 20);
		contentPane.add(btnVolver);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 432, 164);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setDefaultEditor(Object.class, null);

		modelo = new DefaultTableModel(
				new Object[][] {},
				new String[] { "Id", "Cliente", "Fecha", "Total", "Estado" }) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table.setModel(modelo); // IMPORTANTE
		scrollPane.setViewportView(table);

		// Eventos
		btDetalle.addActionListener(this);
		btnModificar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnVolver.addActionListener(this);

		// Carga inicial
		listarPedidos(listaPedidos);
		cargarFechasEnCombo();
	}

	private void listarPedidos(ArrayList<Pedido> lista) {
		modelo.setRowCount(0);

		for (Pedido p : lista) {
			modelo.addRow(new Object[] {
					p.getIdPedido(),
					p.getCliente().getNombre(),
					p.getFecha(),
					String.format("S/ %.2f", p.getTotal()),
					p.getEstado()
			});
		}
	}

	private Pedido obtenerPedidoSeleccionado() {
		int fila = table.getSelectedRow();

		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un pedido de la tabla");
			return null;
		}

		int filaModelo = table.convertRowIndexToModel(fila);
		int idPedido = Integer.parseInt(modelo.getValueAt(filaModelo, 0).toString());

		for (Pedido p : listaPedidos) {
			if (p.getIdPedido() == idPedido) {
				return p;
			}
		}

		return null;
	}

	private void cargarFechasEnCombo() {
		cbFecha.removeAllItems();
		cbFecha.addItem("Todos");

		ArrayList<String> fechasAgregadas = new ArrayList<>();

		for (Pedido p : listaPedidos) {
			String fecha = p.getFecha().toString();

			if (!fechasAgregadas.contains(fecha)) {
				fechasAgregadas.add(fecha);
				cbFecha.addItem(fecha);
			}
		}
	}

	protected void do_btDetalle_actionPerformed(ActionEvent e) {
		Pedido pedido = obtenerPedidoSeleccionado();
		if (pedido == null)
			return;

		StringBuilder sb = new StringBuilder();

		sb.append("Pedido N°: ").append(pedido.getIdPedido()).append("\n");
		sb.append("Cliente: ").append(pedido.getCliente().getNombre()).append("\n");
		sb.append("Fecha: ").append(pedido.getFecha()).append("\n");
		sb.append("Estado: ").append(pedido.getEstado()).append("\n");
		sb.append("Total: S/ ").append(String.format("%.2f", pedido.getTotal())).append("\n\n");

		sb.append("DETALLE:\n");

		for (DetallePedido d : pedido.getDetalles()) {
			sb.append("- ")
			  .append(d.getProducto().getNombre())
			  .append(" | Cant: ").append(d.getCantidad())
			  .append(" | Subtotal: S/ ")
			  .append(String.format("%.2f", d.getSubtotal()))
			  .append("\n");
		}

		JOptionPane.showMessageDialog(
				this,
				sb.toString(),
				"Detalle del Pedido",
				JOptionPane.INFORMATION_MESSAGE);
	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		Pedido pedido = obtenerPedidoSeleccionado();
		if (pedido == null)
			return;

		String[] opciones = { "Pendiente", "Entregado", "Cancelado" };

		String nuevoEstado = (String) JOptionPane.showInputDialog(
				this,
				"Seleccione el nuevo estado del pedido:",
				"Modificar Estado",
				JOptionPane.QUESTION_MESSAGE,
				null,
				opciones,
				pedido.getEstado());

		if (nuevoEstado == null)
			return;

		pedido.setEstado(nuevoEstado);

		listarPedidos(listaPedidos);

		JOptionPane.showMessageDialog(this, "Estado del pedido actualizado");
	}

	protected void do_btnCancelar_actionPerformed(ActionEvent e) {
		Pedido pedido = obtenerPedidoSeleccionado();
		if (pedido == null)
			return;

		if (pedido.getEstado().equalsIgnoreCase("Cancelado")) {
			JOptionPane.showMessageDialog(this, "El pedido ya se encuentra cancelado");
			return;
		}

		int op = JOptionPane.showConfirmDialog(
				this,
				"¿Desea cancelar este pedido?",
				"Confirmar cancelación",
				JOptionPane.YES_NO_OPTION);

		if (op != JOptionPane.YES_OPTION)
			return;

		pedido.setEstado("Cancelado");

		listarPedidos(listaPedidos);

		JOptionPane.showMessageDialog(this, "Pedido cancelado correctamente");
	}

	protected void do_btnVolver_actionPerformed(ActionEvent e) {
		
		ventanaPrincipal.setEnabled(true);
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btDetalle) {
			do_btDetalle_actionPerformed(e);
		}

		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}

		if (e.getSource() == btnCancelar) {
			do_btnCancelar_actionPerformed(e);
		}

		if (e.getSource() == btnVolver) {
			do_btnVolver_actionPerformed(e);
		}
	}
}