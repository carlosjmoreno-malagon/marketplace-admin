package interfas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import desarrollo.TextPrompt;
import desarrollo.busproduc;
import desarrollo.consultas;
import desarrollo.controlador;
import desarrollo_usuarios.usuarios;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import desarrollo.productos;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
public class CajaRegistradora extends JFrame {

	private JPanel contentPane;
	private JTextField nombreDelProducto;
	private JTextField cantidadDeProducto;
	private usuarios mod;
	private JPanel btnAgregar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CajaRegistradora frame = new CajaRegistradora();
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

	public CajaRegistradora() {
		component();
		TextPrompt nom = new TextPrompt("Digite el nombre del producto",nombreDelProducto); 
		TextPrompt cant = new TextPrompt("Digite la cantidad de productos",cantidadDeProducto); 
	}
	public void component() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCaja = new JPanel();
		panelCaja.setBounds(0, 0, 900, 600);
		panelCaja.setBackground(new Color(28, 82, 83));
		contentPane.add(panelCaja);
		panelCaja.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre del producto:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(60, 90, 170, 14);
		panelCaja.add(lblNewLabel);
		
		nombreDelProducto = new JTextField();
		nombreDelProducto.setForeground(Color.GRAY);
		nombreDelProducto.setFont(new Font("Arial", Font.PLAIN, 14));
		nombreDelProducto.setBackground(new Color(28, 82, 83));
		nombreDelProducto.setBorder(null);
		nombreDelProducto.setBounds(70, 115, 200, 20);
		nombreDelProducto.setCaretColor(Color.WHITE);
		panelCaja.add(nombreDelProducto);
		nombreDelProducto.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(70, 146, 200, 2);
		panelCaja.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(60, 210, 100, 14);
		panelCaja.add(lblNewLabel_1);
		
		cantidadDeProducto = new JTextField();
		cantidadDeProducto.setForeground(Color.GRAY);
		cantidadDeProducto.setFont(new Font("Arial", Font.PLAIN, 14));
		cantidadDeProducto.setBackground(new Color(28, 82, 83));
		cantidadDeProducto.setBorder(null);
		cantidadDeProducto.setBounds(70, 235, 210, 20);
		cantidadDeProducto.setCaretColor(Color.WHITE);
		panelCaja.add(cantidadDeProducto);
		cantidadDeProducto.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(70, 266, 210, 2);
		panelCaja.add(separator_1);
		
		JPanel btnPagar = new JPanel();
		btnPagar.setBounds(60, 415, 250, 40);
		btnPagar.setBackground(new Color(37, 60, 120));
		btnPagar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelCaja.add(btnPagar);
		btnPagar.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("            PAGAR");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setIcon(new ImageIcon(CajaRegistradora.class.getResource("/primero/img/tarjeta-de-credito.png")));
		lblNewLabel_3.setBounds(10, 5, 230, 30);
		btnPagar.add(lblNewLabel_3);
		
		JPanel btnRecibo = new JPanel();
		btnRecibo.setBounds(60, 480, 250, 40);
		btnRecibo.setBackground(new Color(37, 60, 120));
		btnRecibo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelCaja.add(btnRecibo);
		btnRecibo.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("    RECIBO DE PAGO");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_4.setIcon(new ImageIcon(CajaRegistradora.class.getResource("/primero/img/factura.png")));
		lblNewLabel_4.setBounds(10, 4, 230, 35);
		btnRecibo.add(lblNewLabel_4);
		
		JPanel panelDeProductos = new JPanel();
		panelDeProductos.setBackground(Color.WHITE);
		panelDeProductos.setBounds(445, 39, 400, 500);
		panelCaja.add(panelDeProductos);
		panelDeProductos.setLayout(null);
		
		//tabla
		String[] nombreColumnas = {"Nombre","Cantidad","Precio"};
		Object[][] data = {{"Arroz 500g", 3, 6000},{"3D Multiusos",2, 5000}};
		table = new JTable();
		table.setModel(new DefaultTableModel(data, nombreColumnas));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBounds(0, 0, 400, 500);
		panelDeProductos.add(table);
		
		btnAgregar = new JPanel();
		btnAgregar.setBackground(new Color(37,60,120));
		btnAgregar.setBounds(60, 350, 250, 40);
		btnAgregar.setLayout(null);
		btnAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelCaja.add(btnAgregar);
			
		JLabel lblNewLabel_2 = new JLabel("AGREGAR PRODUCTO");
		lblNewLabel_2.setBounds(20, 5, 209, 33);
		btnAgregar.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(CajaRegistradora.class.getResource("/primero/img/carrito-de-compras.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		

		
		}
}
