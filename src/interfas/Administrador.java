package interfas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import desarrollo.TextPrompt;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JRadioButton;
public class Administrador extends JFrame {

	private JPanel contentPane;
	public JTextField idProductoA;
	public JTextField nombreDelProductoA;
	public JTextField cantidadDeStockA;
	public JTextField precioDelProductoA;
	public JTextField editarID;
	public JTextField editarNombreDelProducto;
	public JTextField editarCantidad;
	public JTextField editarPrecio;
	public JPanel btnAgregarDB;
	private JLabel lblNewLabel_4;
	public JPanel btnBuscarAD;
	private JLabel lblNewLabel_5;
	public JPanel btnEditarDB;
	private JLabel lblNewLabel_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador frame = new Administrador();
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
	public Administrador() {
		componentes();
		TextPrompt id = new TextPrompt("Digite el ID del producto",editarID); 
		TextPrompt nom = new TextPrompt("Digite el nombre del producto",editarNombreDelProducto); 
		TextPrompt cant = new TextPrompt("Digite la cantidad en stock",editarCantidad); 
		TextPrompt precio = new TextPrompt("Digite el precio del producto",editarPrecio); 
		TextPrompt idA = new TextPrompt("Digite el ID del producto",idProductoA); 
		TextPrompt cantA = new TextPrompt("Digite la cantidad en stock",cantidadDeStockA);
		TextPrompt nomA = new TextPrompt("Digite el nombre del producto",nombreDelProductoA);
		TextPrompt precioA = new TextPrompt("Digite el precio del producto",precioDelProductoA); 
		cant.setFont(new Font("Arial", Font.PLAIN, 12));
		
	}
	public void componentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelAdmin = new JPanel();
		panelAdmin.setBackground(Color.WHITE);
		panelAdmin.setBounds(0, 0, 900, 600);
		contentPane.add(panelAdmin);
		panelAdmin.setLayout(null);
		
		JPanel panelVentas = new JPanel();
		panelVentas.setBounds(0, 0, 250, 600);
		panelVentas.setBackground(new Color(243, 255, 198));
		panelAdmin.add(panelVentas);
		panelVentas.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Admin");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setBounds(23, 21, 200, 30);
		panelVentas.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dinero recaudado:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 62, 130, 30);
		panelVentas.add(lblNewLabel_1);
		
		JLabel dinero = new JLabel("$99999999");
		dinero.setFont(new Font("Arial", Font.PLAIN, 16));
		dinero.setBounds(150, 62, 92, 30);
		panelVentas.add(dinero);
		
		JPanel btnRegistrarUsuarios = new JPanel();
		btnRegistrarUsuarios.setBackground(Color.WHITE);
		btnRegistrarUsuarios.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRegistrarUsuarios.setBounds(23, 500, 200, 40);
		panelVentas.add(btnRegistrarUsuarios);
		btnRegistrarUsuarios.setLayout(null);
		btnRegistrarUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				entrarARegistro();
			}

		});
		
		JLabel lblNewLabel_7 = new JLabel("Editar usuarios");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(40, 6, 120, 29);
		btnRegistrarUsuarios.add(lblNewLabel_7);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(250, 279, 650, 10);
		panelAdmin.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Añadir un nuevo producto o Buscar un producto");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(260, 293, 456, 30);
		panelAdmin.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID(Opcional)");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(260, 341, 92, 22);
		panelAdmin.add(lblNewLabel_3);
		
		idProductoA = new JTextField();
		idProductoA.setBackground(Color.WHITE);
		idProductoA.setForeground(Color.GRAY);
		idProductoA.setBorder(null);
		idProductoA.setFont(new Font("Arial", Font.PLAIN, 12));
		idProductoA.setBounds(270, 366, 150, 30);
		panelAdmin.add(idProductoA);
		idProductoA.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(270, 407, 150, 5);
		panelAdmin.add(separator_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nombre del producto");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(260, 443, 160, 22);
		panelAdmin.add(lblNewLabel_3_1);
		
		nombreDelProductoA = new JTextField();
		nombreDelProductoA.setForeground(Color.GRAY);
		nombreDelProductoA.setBorder(null);
		nombreDelProductoA.setFont(new Font("Arial", Font.PLAIN, 11));
		nombreDelProductoA.setColumns(10);
		nombreDelProductoA.setBackground(Color.WHITE);
		nombreDelProductoA.setBounds(270, 468, 150, 30);
		panelAdmin.add(nombreDelProductoA);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(270, 509, 150, 5);
		panelAdmin.add(separator_1_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Cantidad en Stock");
		lblNewLabel_3_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(467, 341, 140, 14);
		panelAdmin.add(lblNewLabel_3_2);
		
		cantidadDeStockA = new JTextField();
		cantidadDeStockA.setForeground(Color.GRAY);
		cantidadDeStockA.setBorder(null);
		cantidadDeStockA.setFont(new Font("Arial", Font.PLAIN, 12));
		cantidadDeStockA.setColumns(10);
		cantidadDeStockA.setBackground(Color.WHITE);
		cantidadDeStockA.setBounds(477, 366, 150, 30);
		panelAdmin.add(cantidadDeStockA);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(Color.BLACK);
		separator_1_2.setBounds(477, 407, 150, 5);
		panelAdmin.add(separator_1_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Precio del producto");
		lblNewLabel_3_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(467, 443, 140, 22);
		panelAdmin.add(lblNewLabel_3_3);
		
		precioDelProductoA = new JTextField();
		precioDelProductoA.setForeground(Color.GRAY);
		precioDelProductoA.setBorder(null);
		precioDelProductoA.setFont(new Font("Arial", Font.PLAIN, 11));
		precioDelProductoA.setColumns(10);
		precioDelProductoA.setBackground(Color.WHITE);
		precioDelProductoA.setBounds(477, 468, 150, 30);
		panelAdmin.add(precioDelProductoA);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(Color.BLACK);
		separator_1_3.setBounds(477, 509, 150, 5);
		panelAdmin.add(separator_1_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Editar un producto o Eliminar un producto");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_2_1.setBounds(260, 24, 397, 30);
		panelAdmin.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_4 = new JLabel("ID(Opcional)");
		lblNewLabel_3_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_4.setBounds(260, 72, 92, 22);
		panelAdmin.add(lblNewLabel_3_4);
		
		editarID = new JTextField();
		editarID.setForeground(Color.GRAY);
		editarID.setFont(new Font("Arial", Font.PLAIN, 12));
		editarID.setColumns(10);
		editarID.setBorder(null);
		editarID.setBackground(Color.WHITE);
		editarID.setBounds(270, 97, 150, 30);
		panelAdmin.add(editarID);
		
		JSeparator separator_1_4 = new JSeparator();
		separator_1_4.setForeground(Color.BLACK);
		separator_1_4.setBounds(270, 138, 150, 5);
		panelAdmin.add(separator_1_4);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Nombre del producto");
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_1_1.setBounds(260, 174, 160, 22);
		panelAdmin.add(lblNewLabel_3_1_1);
		
		editarNombreDelProducto = new JTextField();
		editarNombreDelProducto.setForeground(Color.GRAY);
		editarNombreDelProducto.setFont(new Font("Arial", Font.PLAIN, 11));
		editarNombreDelProducto.setColumns(10);
		editarNombreDelProducto.setBorder(null);
		editarNombreDelProducto.setBackground(Color.WHITE);
		editarNombreDelProducto.setBounds(270, 199, 150, 30);
		panelAdmin.add(editarNombreDelProducto);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(Color.BLACK);
		separator_1_1_1.setBounds(270, 240, 150, 5);
		panelAdmin.add(separator_1_1_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Cantidad en Stock");
		lblNewLabel_3_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_2_1.setBounds(467, 72, 140, 14);
		panelAdmin.add(lblNewLabel_3_2_1);
		
		editarCantidad = new JTextField();
		editarCantidad.setForeground(Color.GRAY);
		editarCantidad.setFont(new Font("Arial", Font.PLAIN, 11));
		editarCantidad.setColumns(10);
		editarCantidad.setBorder(null);
		editarCantidad.setBackground(Color.WHITE);
		editarCantidad.setBounds(477, 97, 150, 30);
		panelAdmin.add(editarCantidad);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setForeground(Color.BLACK);
		separator_1_2_1.setBounds(477, 138, 150, 5);
		panelAdmin.add(separator_1_2_1);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Precio del producto");
		lblNewLabel_3_3_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_3_1.setBounds(467, 174, 140, 22);
		panelAdmin.add(lblNewLabel_3_3_1);
		
		editarPrecio = new JTextField();
		editarPrecio.setForeground(Color.GRAY);
		editarPrecio.setFont(new Font("Arial", Font.PLAIN, 11));
		editarPrecio.setColumns(10);
		editarPrecio.setBorder(null);
		editarPrecio.setBackground(Color.WHITE);
		editarPrecio.setBounds(477, 199, 150, 30);
		panelAdmin.add(editarPrecio);
		
		JSeparator separator_1_3_1 = new JSeparator();
		separator_1_3_1.setForeground(Color.BLACK);
		separator_1_3_1.setBounds(477, 240, 150, 5);
		panelAdmin.add(separator_1_3_1);
		{
			btnAgregarDB = new JPanel();
			btnAgregarDB.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			btnAgregarDB.setLayout(null);
			btnAgregarDB.setBackground(new Color(37, 60, 120));
			btnAgregarDB.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnAgregarDB.setBounds(669, 366, 200, 50);
			panelAdmin.add(btnAgregarDB);
			{
				lblNewLabel_4 = new JLabel("Agregar nuevo producto");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setForeground(Color.WHITE);
				lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
				lblNewLabel_4.setBounds(10, 8, 180, 30);
				btnAgregarDB.add(lblNewLabel_4);
			}
		}
		{
			btnBuscarAD = new JPanel();
			btnBuscarAD.setBackground(new Color(37,60,120));
			btnBuscarAD.setBounds(669, 443, 200, 50);
			btnBuscarAD.setCursor(new Cursor(Cursor.HAND_CURSOR));
			panelAdmin.add(btnBuscarAD);
			btnBuscarAD.setLayout(null);
			{
				lblNewLabel_5 = new JLabel("Buscar producto");
				lblNewLabel_5.setBounds(20, 8, 154, 33);
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_5.setForeground(Color.WHITE);
				lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
				btnBuscarAD.add(lblNewLabel_5);
			}
		}
		{
			btnEditarDB = new JPanel();
			btnEditarDB.setBackground(new Color(37,60,120));
			btnEditarDB.setBounds(669, 93, 200, 50);
			btnEditarDB.setCursor(new Cursor(Cursor.HAND_CURSOR));
			panelAdmin.add(btnEditarDB);
			btnEditarDB.setLayout(null);
			{
				lblNewLabel_6 = new JLabel("Editar producto");
				lblNewLabel_6.setBounds(22, 11, 154, 28);
				lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_6.setForeground(Color.WHITE);
				lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
				btnEditarDB.add(lblNewLabel_6);
			}
		}
		
		JPanel btnEliminarDB = new JPanel();
		btnEliminarDB.setBackground(new Color(37, 60, 120));
		btnEliminarDB.setBounds(669, 174, 200, 50);
		btnEliminarDB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelAdmin.add(btnEliminarDB);
		btnEliminarDB.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Eliminar producto");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(42, 8, 110, 30);
		btnEliminarDB.add(lblNewLabel_8);
	}
	
	public void entrarARegistro() {
		Registro x = new Registro();
		x.setVisible(true);
		this.dispose();
	}
	
}

