package primero;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import desarrollo.busproduc;

public class cajero extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	public static JTextField producto;
	public static JTextField precio;
	public static JTextField can;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	public JButton guardar;
	private JButton recibo1;
	public static JButton buscar;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	public static JTextField id;
	private JButton regresar;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton borrar;
	private int click;
	public busproduc bp;
	
	
	private void login() {
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cajero frame = new cajero();
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
	public void llet() {
		DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");

       this.table.setModel(modelo);
       String arreglo[]= new String[3];
       for(int i=0;i<click;i++) {
    	   arreglo[0] = String.valueOf(i);
    	   arreglo[1] = producto.getText();
    	   arreglo[2] = can.getText();
    	   arreglo[3] = precio.getText();
    	   modelo.addRow(arreglo);
       }
	   /*arreglo[0] = "12222222";
	   arreglo[1] = "pepito peres";
	   arreglo[2] = "rodrigez";
	   arreglo[3] = "fluido";
	   arreglo[4] = "pepitofluido";
	   arreglo[5] = "0";
	   arreglo[6]  ="10";
	   modelo.addRow(arreglo);
	   arreglo[0] = "23";
	   arreglo[1] = "pepito peres 2";
	   arreglo[2] = "rodrigez 1";
	   arreglo[3] = "tanque de combate";
	   arreglo[4] = "pepi2";
	   arreglo[5] = "12";
	   arreglo[6]  ="13";
	   modelo.addRow(arreglo);*/
	}
	public void regresar() {
		pagina1 x = new pagina1();
		x.setVisible(true);
		this.dispose();
	}
	public cajero() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(cajero.class.getResource("/primero/img/\u00E9xito chafa.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			buscar = new JButton("buscar");
			buscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			{
				id = new JTextField();
				id.setBounds(190, 65, 30, 20);
				id.setVisible(false);
				{
					regresar = new JButton("");
					regresar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							regresar();
						}
					});
					{
						borrar = new JButton("borrar");
						borrar.setBackground(Color.CYAN);
						borrar.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 15));
						borrar.setBounds(333, 157, 89, 23);
						contentPane.add(borrar);
					}
					{
						scrollPane = new JScrollPane();
						scrollPane.setBounds(323, 29, 179, 117);
						contentPane.add(scrollPane);
						{
							table = new JTable();
							scrollPane.setViewportView(table);
							llet();
						}
					}
					regresar.setIcon(new ImageIcon(cajero.class.getResource("/primero/img/regresar (2).png")));
					regresar.setForeground(Color.WHITE);
					regresar.setBackground(Color.RED);
					regresar.setBounds(10, 11, 52, 28);
					contentPane.add(regresar);
				}
				contentPane.add(id);
				id.setColumns(10);
			}
			buscar.setForeground(new Color(0, 0, 0));
			buscar.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 15));
			buscar.setBackground(new Color(0, 255, 255));
			buscar.setBounds(213, 224, 89, 23);
			contentPane.add(buscar);
		}
		{
			guardar = new JButton("");
			guardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					login();
				}
			});
			guardar.setBackground(new Color(0, 255, 255));
			guardar.setIcon(new ImageIcon(cajero.class.getResource("/primero/img/Icono-guardar (2).png")));
			guardar.setBounds(80, 218, 53, 29);
			contentPane.add(guardar);
		}
		{
			recibo1 = new JButton("recibo");
			recibo1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pago x = new pago();
					x.setVisible(true);
				}
			});
			recibo1.setForeground(new Color(0, 0, 0));
			recibo1.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 15));
			recibo1.setBackground(new Color(0, 255, 255));
			recibo1.setBounds(379, 224, 89, 23);
			contentPane.add(recibo1);
		}
		{
			lblNewLabel_3 = new JLabel("cantidad de productos");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 17));
			lblNewLabel_3.setBounds(20, 96, 179, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			lblNewLabel_2 = new JLabel("precio del producto");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 17));
			lblNewLabel_2.setBounds(20, 142, 148, 14);
			contentPane.add(lblNewLabel_2);
		}
		{
			lblNewLabel_1 = new JLabel("producto");
			lblNewLabel_1.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 17));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(24, 50, 77, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			producto = new JTextField();
			producto.setBounds(24, 65, 142, 20);
			contentPane.add(producto);
			producto.setColumns(10);
			producto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					click+=1;
				}
			});
		}
		{
			precio = new JTextField();
			precio.setBounds(20, 158, 148, 20);
			contentPane.add(precio);
			precio.setColumns(10);
		}
		{
			can = new JTextField();
			can.setBounds(24, 111, 94, 20);
			contentPane.add(can);
			can.setColumns(10);
		}
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(cajero.class.getResource("/primero/img/Happy chinese new year (1).png")));
			lblNewLabel.setBounds(0, 0, 512, 256);
			contentPane.add(lblNewLabel);
		}
	}
}
