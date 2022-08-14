package primero;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class registro extends JFrame {
	private JPanel contentPane;
	private JLabel lblNewLabel;
	public  JButton guardar;
	public  JTextField nombre;
	public  JTextField precio;
	public  JTextField id;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	public  JButton borrar;
	public  JButton modificar;
	public  JTextField size;
	private JLabel lblNewLabel_3;
	public  JButton buscar;
	public  JButton btnNewButton_1;
	private JComboBox comboBox;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro frame = new registro();
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
	public void regresar() {
		pagina1 x = new pagina1();
		x.setVisible(true);
		this.dispose();
	}
	public registro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(registro.class.getResource("/primero/img/\u00E9xito chafa.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			{
				id = new JTextField();
				id.setVisible(false);
				{
					borrar = new JButton("borrar");
					borrar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
						}
					});
					{
						buscar = new JButton("buscar");
						buscar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
							}
						});
						{
							btnNewButton_1 = new JButton("");
							btnNewButton_1.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									regresar();
								}
							});
							{
								comboBox = new JComboBox();
								comboBox.setModel(new DefaultComboBoxModel(new String[] {"producto supermercado", "producto tienda"}));
								comboBox.setBounds(306, 149, 151, 22);
								contentPane.add(comboBox);
							}
							btnNewButton_1.setIcon(new ImageIcon(registro.class.getResource("/primero/img/regresar (2).png")));
							btnNewButton_1.setForeground(Color.WHITE);
							btnNewButton_1.setBackground(Color.RED);
							btnNewButton_1.setBounds(10, 11, 52, 28);
							contentPane.add(btnNewButton_1);
						}
						buscar.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 15));
						buscar.setBackground(Color.RED);
						buscar.setForeground(Color.WHITE);
						buscar.setBounds(156, 219, 89, 23);
						contentPane.add(buscar);
					}
					{
						lblNewLabel_3 = new JLabel("tama\u00F1o");
						lblNewLabel_3.setBounds(219, 129, 66, 14);
						contentPane.add(lblNewLabel_3);
					}
					{
						size = new JTextField();
						size.setBounds(199, 150, 86, 20);
						contentPane.add(size);
						size.setColumns(10);
					}
					{
						modificar = new JButton("modificar");
						modificar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
							}
						});
						modificar.setForeground(Color.WHITE);
						modificar.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 15));
						modificar.setBackground(Color.RED);
						modificar.setBounds(276, 220, 116, 23);
						contentPane.add(modificar);
					}
					borrar.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 15));
					borrar.setForeground(Color.WHITE);
					borrar.setBackground(Color.RED);
					borrar.setBounds(402, 220, 89, 23);
					contentPane.add(borrar);
				}
				{
					lblNewLabel_2 = new JLabel("precio");
					lblNewLabel_2.setBounds(280, 82, 71, 14);
					contentPane.add(lblNewLabel_2);
				}
				{
					lblNewLabel_1 = new JLabel("producto");
					lblNewLabel_1.setBounds(137, 82, 71, 14);
					contentPane.add(lblNewLabel_1);
				}
				id.setBounds(94, 98, 30, 20);
				contentPane.add(id);
				id.setColumns(10);
			}
			{
				precio = new JTextField();
				precio.setBounds(280, 98, 86, 20);
				contentPane.add(precio);
				precio.setColumns(10);
			}
			{
				nombre = new JTextField();
				nombre.setBounds(134, 98, 86, 20);
				contentPane.add(nombre);
				nombre.setColumns(10);
			}
			{
				guardar = new JButton("guardar");
				guardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
					}
				});
				guardar.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 15));
				guardar.setBackground(Color.RED);
				guardar.setForeground(Color.WHITE);
				guardar.setBounds(21, 221, 89, 23);
				contentPane.add(guardar);
			}
		}
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(registro.class.getResource("/primero/img/exito chafa (1).png")));
			lblNewLabel.setBounds(0, 0, 501, 256);
			contentPane.add(lblNewLabel);
		}
	}
}
