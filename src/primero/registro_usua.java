package primero;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import desarrollo.Hash;
import desarrollo_usuarios.SQLusuarios;
import desarrollo_usuarios.usuarios;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class registro_usua extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;
	public static JTextField usuario;
	public static JButton registro;
	private JLabel lblContrasea;
	private JLabel lblNewLabel_1;
	public static JPasswordField confirmar;
	private JLabel lblNewLabel_2;
	public static JPasswordField password;
	private JTextField nombre;
	private JComboBox estatus;
	private JLabel lblNewLabel_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro_usua frame = new registro_usua();
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
	private void limpiar() {

		usuario.setText("");
		password.setText("");
		confirmar.setText("");
		nombre.setText("");
		
		
		}
	public registro_usua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel_4 = new JLabel("Estatus");
			lblNewLabel_4.setBounds(84, 169, 57, 14);
			contentPane.add(lblNewLabel_4);
		}
		{
			estatus = new JComboBox();
			estatus.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Empleado"}));
			estatus.setBounds(84, 194, 90, 22);
			contentPane.add(estatus);
		}
		{
			{
				nombre = new JTextField();
				nombre.setBounds(84, 138, 86, 20);
				contentPane.add(nombre);
				nombre.setColumns(10);
			}
			{
				password = new JPasswordField();
				password.setBounds(283, 79, 86, 20);
				contentPane.add(password);
			}
			{
				lblNewLabel_2 = new JLabel("confirmar ");
				lblNewLabel_2.setBounds(283, 110, 68, 20);
				contentPane.add(lblNewLabel_2);
			}
			{
				confirmar = new JPasswordField();
				confirmar.setBounds(283, 138, 86, 20);
				contentPane.add(confirmar);
			}
		}
		{
			lblContrasea = new JLabel("contrase\u00F1a");
			lblContrasea.setBounds(283, 62, 74, 14);
			contentPane.add(lblContrasea);
		}
		{
			lblNewLabel = new JLabel("usuario");
			lblNewLabel.setBounds(84, 62, 46, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_3 = new JLabel("Nombre");
			lblNewLabel_3.setBounds(84, 116, 46, 14);
			contentPane.add(lblNewLabel_3);
		}
		{
			usuario = new JTextField();
			usuario.setBounds(84, 79, 86, 20);
			contentPane.add(usuario);
			usuario.setColumns(10);
		}
		{
			registro = new JButton("registrarme");
			registro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SQLusuarios modsql = new SQLusuarios();
					usuarios mod =new usuarios();
					String pas = new String(password.getPassword());
					String conf = new String(confirmar.getPassword());
					if(usuario.getText().equals("") || pas.equals("")||conf.equals("")||nombre.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "hey campos vacios, debe llenar todos los campos");
					}else {
					
					if(pas.equals(conf)) {
						if(modsql.existeusuario(usuario.getText())==0) {
							
						
						String newpas = Hash.sha1(pas);
						mod.setUsuario(usuario.getText());
						mod.setPassword(newpas);
						mod.setNombre(nombre.getText());
						String a;
						int es = 0;
						a = estatus.getSelectedItem().toString();
						if(a.equals("administrador")) {
							es=1;
						}else if(a.equals("Empleado")) {
							es=2;
						}
						mod.setId_tipo(es);
						if(modsql.registrar(mod)) {
							JOptionPane.showMessageDialog(null, "el registro guardodo");
							limpiar();
						}
						else {
							JOptionPane.showMessageDialog(null, "error al guardar");
							limpiar();
						}
					}else {
						JOptionPane.showMessageDialog(null, "El usuario ya existe");
					}
						
						
				
				}else {
					JOptionPane.showMessageDialog(null, "no coincide la contrase�a");
					limpiar();
				}
					}
				}
			});
			registro.setBounds(172, 227, 105, 23);
			contentPane.add(registro);
		}
		{
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(registro_usua.class.getResource("/primero/img/registro 2.png")));
			lblNewLabel_1.setBounds(0, 0, 500, 281);
			contentPane.add(lblNewLabel_1);
		}
	}
}
