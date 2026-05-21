package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import clases.Pedido;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

public class VHistorial extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtBuscarPed;
	private JLabel lblNewLabel_1;
	private JTable table;
	private JComboBox cbFecha;
	private JButton btDetalle;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JButton btnVolver;
	private JScrollPane scrollPane;
	ArrayList<Pedido>listaPedidos;
	


	/**
	 * Create the frame.
	 */
	public VHistorial(ArrayList<Pedido>listaPedidos) {
		this.listaPedidos = listaPedidos;
		setTitle("HISTORIAL DE PEDIDOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Buscar:");
			lblNewLabel.setBounds(10, 10, 69, 12);
			contentPane.add(lblNewLabel);
		}
		{
			txtBuscarPed = new JTextField();
			txtBuscarPed.setBounds(54, 7, 127, 18);
			contentPane.add(txtBuscarPed);
			txtBuscarPed.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Filtrar por día: ");
			lblNewLabel_1.setBounds(10, 32, 85, 12);
			contentPane.add(lblNewLabel_1);
		}
		{
			cbFecha = new JComboBox();
			cbFecha.setBounds(87, 35, 94, 20);
			contentPane.add(cbFecha);
		}
		{
			btDetalle = new JButton("Ver Detalle");
			btDetalle.setBounds(10, 272, 94, 20);
			contentPane.add(btDetalle);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.setBounds(125, 272, 94, 20);
			contentPane.add(btnModificar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(239, 272, 99, 20);
			contentPane.add(btnCancelar);
		}
		{
			btnVolver = new JButton("Volver");
			btnVolver.setBounds(348, 272, 94, 20);
			contentPane.add(btnVolver);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(this);
			scrollPane.setBounds(10, 79, 432, 164);
			contentPane.add(scrollPane);
			{
				table = new JTable();
				table.addMouseListener(this);
				table.setAutoCreateRowSorter(true);
				table.setDefaultEditor(Object.class, null);
				scrollPane.setViewportView(table);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Id", "Cliente", "Fecha", "Total", "Estado"
					}
				));
			}
		}

	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			do_table_mouseClicked(e);
		}
		if (e.getSource() == scrollPane) {
			do_scrollPane_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_scrollPane_mouseClicked(MouseEvent e) {
	}
	protected void do_table_mouseClicked(MouseEvent e) {
		
		
		
		int fila = table.getSelectedRow();
		
		String cliente = table.getValueAt(fila, 1).toString();
		
	}
}
