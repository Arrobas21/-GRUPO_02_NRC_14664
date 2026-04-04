package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class v1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtLibro;
	private JLabel lblNewLabel_1;
	private JButton btnRegistrar;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					v1 frame = new v1();
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
	public v1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Sistema de Gestión Integrado para Bibliotecas Universitarias");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(42, 11, 398, 40);
			contentPane.add(lblNewLabel);
		}
		{
			txtLibro = new JTextField();
			txtLibro.setBounds(91, 71, 86, 20);
			contentPane.add(txtLibro);
			txtLibro.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Ingresar Libro");
			lblNewLabel_1.setBounds(14, 74, 67, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			btnRegistrar = new JButton("Registrar Libro");
			btnRegistrar.setBounds(42, 98, 120, 23);
			contentPane.add(btnRegistrar);
		}
		{
			txtS = new JTextArea();
			txtS.setBounds(10, 127, 447, 166);
			contentPane.add(txtS);
		}

	}
}
