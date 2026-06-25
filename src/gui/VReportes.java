package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import clases.DetallePedido;
import clases.Pedido;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class VReportes extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblHasta;
	private JButton btGenerar;
	private JDateChooser dateChooserDesde;
	private JDateChooser dateChooserHasta;
	private JPanel PANEL_FILTROS;
	private JPanel PANEL_RESUMEN;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtTotalPedidos;
	private JTextField txtPedidosPendientes;
	private JTextField txtIngresosTotales;
	private JPanel PANEL_PRODUCTOS;
	private JScrollPane scrollPane;
	private JTable tabla_reporte;
	private JPanel PANEL_BOTONES;
	private JButton btActualizar;
	private JButton btSalir;
	private JFrame ventanaPrincipal;
	ArrayList<Pedido> listapedidos;
	
	public VReportes(ArrayList<Pedido>listapedidos,JFrame ventanaPrincipal) {
		this.listapedidos = listapedidos;
		this.ventanaPrincipal = ventanaPrincipal;
		setTitle("REPORTES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			PANEL_FILTROS = new JPanel();
			PANEL_FILTROS.setBounds(10, 10, 468, 43);
			contentPane.add(PANEL_FILTROS);
			PANEL_FILTROS.setLayout(null);
			{
				lblNewLabel = new JLabel("Desde: ");
				lblNewLabel.setBounds(10, 10, 54, 13);
				PANEL_FILTROS.add(lblNewLabel);
			}
			{
				dateChooserDesde = new JDateChooser();
				dateChooserDesde.setBounds(74, 10, 90, 18);
				PANEL_FILTROS.add(dateChooserDesde);
			}
			{
				lblHasta = new JLabel("Hasta: ");
				lblHasta.setBounds(193, 10, 54, 12);
				PANEL_FILTROS.add(lblHasta);
			}
			{
				dateChooserHasta = new JDateChooser();
				dateChooserHasta.setBounds(257, 10, 107, 18);
				PANEL_FILTROS.add(dateChooserHasta);
			}
			{
				btGenerar = new JButton("Generar");
				btGenerar.addActionListener(this);
				btGenerar.setBounds(374, 6, 84, 20);
				PANEL_FILTROS.add(btGenerar);
			}
		}
		{
			PANEL_RESUMEN = new JPanel();
			PANEL_RESUMEN.setBounds(10, 63, 268, 100);
			contentPane.add(PANEL_RESUMEN);
			PANEL_RESUMEN.setLayout(null);
			{
				lblNewLabel_1 = new JLabel("Total pedidos:");
				lblNewLabel_1.setBounds(10, 10, 144, 12);
				PANEL_RESUMEN.add(lblNewLabel_1);
			}
			{
				lblNewLabel_2 = new JLabel("Pedidos pendientes: ");
				lblNewLabel_2.setBounds(10, 42, 144, 12);
				PANEL_RESUMEN.add(lblNewLabel_2);
			}
			{
				lblNewLabel_3 = new JLabel("Ingresos totales: ");
				lblNewLabel_3.setBounds(10, 78, 131, 12);
				PANEL_RESUMEN.add(lblNewLabel_3);
			}
			{
				txtTotalPedidos = new JTextField();
				txtTotalPedidos.setHorizontalAlignment(SwingConstants.CENTER);
				txtTotalPedidos.setEditable(false);
				txtTotalPedidos.setBounds(162, 7, 96, 18);
				PANEL_RESUMEN.add(txtTotalPedidos);
				txtTotalPedidos.setColumns(10);
			}
			{
				txtPedidosPendientes = new JTextField();
				txtPedidosPendientes.setHorizontalAlignment(SwingConstants.CENTER);
				txtPedidosPendientes.setEditable(false);
				txtPedidosPendientes.setColumns(10);
				txtPedidosPendientes.setBounds(162, 39, 96, 18);
				PANEL_RESUMEN.add(txtPedidosPendientes);
			}
			{
				txtIngresosTotales = new JTextField();
				txtIngresosTotales.setHorizontalAlignment(SwingConstants.CENTER);
				txtIngresosTotales.setEditable(false);
				txtIngresosTotales.setColumns(10);
				txtIngresosTotales.setBounds(162, 75, 96, 18);
				PANEL_RESUMEN.add(txtIngresosTotales);
			}
		}
		{
			PANEL_PRODUCTOS = new JPanel();
			PANEL_PRODUCTOS.setBounds(10, 173, 386, 117);
			contentPane.add(PANEL_PRODUCTOS);
			PANEL_PRODUCTOS.setLayout(null);
			{
				scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 10, 353, 86);
				PANEL_PRODUCTOS.add(scrollPane);
				{
					tabla_reporte = new JTable();
					tabla_reporte.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Producto", "Cantidad Vendida", "Ingreso"
						}
					));
					tabla_reporte.getColumnModel().getColumn(1).setPreferredWidth(134);
					scrollPane.setViewportView(tabla_reporte);
				}
			}
		}
		{
			PANEL_BOTONES = new JPanel();
			PANEL_BOTONES.setBounds(10, 300, 386, 50);
			contentPane.add(PANEL_BOTONES);
			PANEL_BOTONES.setLayout(null);
			{
				btActualizar = new JButton("Actualizar");
				btActualizar.addActionListener(this);
				btActualizar.setBounds(25, 10, 108, 20);
				PANEL_BOTONES.add(btActualizar);
			}
			{
				btSalir = new JButton("Salir");
				btSalir.addActionListener(this);
				btSalir.setBounds(235, 10, 100, 20);
				PANEL_BOTONES.add(btSalir);
			}
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btSalir) {
			do_btSalir_actionPerformed(e);
		}
		if (e.getSource() == btActualizar) {
			do_btActualizar_actionPerformed(e);
		}
		if (e.getSource() == btGenerar) {
			do_btGenerar_actionPerformed(e);
		}
	}
	protected void do_btGenerar_actionPerformed(ActionEvent e) {
		generarReporte();
	}
	
	
	private void generarReporte() {
		
		if (dateChooserDesde.getDate() == null || dateChooserHasta.getDate() == null) {
	        JOptionPane.showMessageDialog(this,
	                "Seleccione ambas fechas");
	        return;
	    }

	    LocalDate desde = dateChooserDesde.getDate()
	            .toInstant()
	            .atZone(ZoneId.systemDefault())
	            .toLocalDate();

	    LocalDate hasta = dateChooserHasta.getDate()
	            .toInstant()
	            .atZone(ZoneId.systemDefault())
	            .toLocalDate();

	    if (desde.isAfter(hasta)) {
	        JOptionPane.showMessageDialog(this,
	                "La fecha 'Desde' no puede ser mayor que 'Hasta'");
	        return;
	    }

	    int totalPedidos = 0;
	    int pedidosPendientes = 0;
	    double ingresos = 0;

	    // Acumuladores para productos más vendidos
	    HashMap<String, Integer> mapaCantidad = new HashMap<>();
	    HashMap<String, Double> mapaIngreso = new HashMap<>();

	    for (Pedido p : listapedidos) {

	        LocalDate fechaPedido = p.getFecha();

	        if ((fechaPedido.isEqual(desde) || fechaPedido.isAfter(desde)) &&
	            (fechaPedido.isEqual(hasta) || fechaPedido.isBefore(hasta))) {

	            totalPedidos++;
	            ingresos += p.getTotal();

	            if (p.getEstado().equalsIgnoreCase("Pendiente")) {
	                pedidosPendientes++;
	            }

	            for (DetallePedido d : p.getDetalles()) {

	                String nombreProducto = d.getProducto().getNombre();
	                int cantidad = d.getCantidad();
	                double subtotal = d.getSubtotal();

	                mapaCantidad.put(
	                        nombreProducto,
	                        mapaCantidad.getOrDefault(nombreProducto, 0) + cantidad
	                );

	                mapaIngreso.put(
	                        nombreProducto,
	                        mapaIngreso.getOrDefault(nombreProducto, 0.0) + subtotal
	                );
	            }
	        }
	    }

	    // Mostrar resumen
	    txtTotalPedidos.setText(String.valueOf(totalPedidos));
	    txtPedidosPendientes.setText(String.valueOf(pedidosPendientes));
	    txtIngresosTotales.setText(String.format("S/ %.2f", ingresos));

	    // Llenar tabla de productos más vendidos
	    DefaultTableModel modelo = (DefaultTableModel) tabla_reporte.getModel();
	    modelo.setRowCount(0);

	    for (String producto : mapaCantidad.keySet()) {
	        modelo.addRow(new Object[] {
	                producto,
	                mapaCantidad.get(producto),
	                String.format("S/ %.2f", mapaIngreso.get(producto))
	        });
	    }

	    if (totalPedidos == 0) {
	        JOptionPane.showMessageDialog(this,
	                "No hay pedidos en ese rango de fechas");
	    }
	}
	protected void do_btActualizar_actionPerformed(ActionEvent e) {
		txtTotalPedidos.setText("");
	    txtPedidosPendientes.setText("");
	    txtIngresosTotales.setText("");

	    DefaultTableModel modelo = (DefaultTableModel) tabla_reporte.getModel();
	    modelo.setRowCount(0);

	    dateChooserDesde.setDate(null);
	    dateChooserHasta.setDate(null);

	    JOptionPane.showMessageDialog(this,
	            "Reporte limpiado");
	}
	
	
	protected void do_btSalir_actionPerformed(ActionEvent e) {
		ventanaPrincipal.setEnabled(true);
		dispose();
	}
}
