package interfas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import desarrollo.Hash;
import desarrollo_usuarios.SQLusuarios;
import desarrollo_usuarios.usuarios;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.List;
import java.awt.Scrollbar;
import javax.swing.JPasswordField;
import desarrollo.TextPrompt;
import desarrollo.busproduc;
import desarrollo.consultas;
import desarrollo.controlador;

import java.awt.Toolkit;
public class Login1 extends JFrame {

	private JPanel contentPane;
	private JTextField usuarioR;
	private JTextField nombreR;
	private JTextField usuario;
	private usuarios mod;
	private JLabel lblNewLabel_7;
	private JSeparator separator_4;
	private JComboBox estatusR;
	private JPasswordField password;
	private JPasswordField passwordR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 frame = new Login1();
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
	public Login1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login1.class.getResource("/primero/img/MarketPlace-Admin.jpg")));
		complement();
		TextPrompt usu = new TextPrompt("Digite su usuario",usuario) ;
		TextPrompt con = new TextPrompt("Digite su contraseña", password);
		con.setFont(new Font("Arial", Font.PLAIN, 14));
		TextPrompt usuR = new TextPrompt("Digite su usuario", usuarioR);
		TextPrompt conR = new TextPrompt("Digite su contraseña", passwordR);
		conR.setFont(new Font("Arial", Font.PLAIN, 14));
		TextPrompt nom = new TextPrompt("Digite su nombre", nombreR);
	}
	public void complement() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelRegistro = new JPanel();
		panelRegistro.setBackground(new Color(28,82,83));
		panelRegistro.setBounds(0, 0, 450, 600);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrarse");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel.setBounds(140, 35, 170, 36);
		panelRegistro.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de usuario:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(45, 100, 146, 14);
		panelRegistro.add(lblNewLabel_1);
		
		usuarioR = new JTextField();
		usuarioR.setBackground(new Color(28,82,83));
		usuarioR.setFont(new Font("Arial", Font.PLAIN, 14));
		usuarioR.setBorder(null);
		usuarioR.setCaretColor(new Color(255,255,255));
		usuarioR.setForeground(Color.LIGHT_GRAY);
		usuarioR.setBounds(55, 125, 250, 20);
		panelRegistro.add(usuarioR);
		usuarioR.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(45, 156, 250, 10);
		panelRegistro.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(45, 200, 170, 14);
		panelRegistro.add(lblNewLabel_2);
		
		nombreR = new JTextField();
		nombreR.setForeground(Color.LIGHT_GRAY);
		nombreR.setBackground(new Color(28,82,83));
		nombreR.setCaretColor(new Color(255,255,255));
		nombreR.setBorder(null);
		nombreR.setFont(new Font("Arial", Font.PLAIN, 14));
		nombreR.setBounds(55, 225, 250, 25);
		panelRegistro.add(nombreR);
		nombreR.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(45, 262, 250, 10);
		panelRegistro.add(separator_1);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(45, 297, 170, 14);
		panelRegistro.add(lblNewLabel_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(45, 364, 250, 5);
		panelRegistro.add(separator_2);
		
		JPanel btnRegistro = new JPanel();
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SQLusuarios modsql = new SQLusuarios();
				usuarios mod =new usuarios();
				String pas = new String(passwordR.getPassword());
				if(usuarioR.getText().equals("") || pas.equals("")||nombreR.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "hey campos vacios, debe llenar todos los campos");
				}else {
				
				
					if(modsql.existeusuario(usuarioR.getText())==0) {
						
						System.out.println(pas);
					String newpas = Hash.sha1(pas);
					mod.setUsuario(usuarioR.getText());
					mod.setContraseña(newpas);
					mod.setNombre(nombreR.getText());
					String a;
					int es = 0;
					a = estatusR.getSelectedItem().toString();
					if(a.equals("Admin")) {
						es=1;
					}else if(a.equals("Usuario")) {
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
					
					
			
				
				}
			}

			private void limpiar() {
				usuarioR.setText("");
				passwordR.setText("");
				nombreR.setText("");
			}
		});
		btnRegistro.setBackground(new Color(243, 255, 198));
		btnRegistro.setBounds(120, 470, 200, 50);
		panelRegistro.add(btnRegistro);
		btnRegistro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRegistro.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("REGISTRAR");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(54, 19, 100, 14);
		btnRegistro.add(lblNewLabel_5);
		{
			lblNewLabel_7 = new JLabel("Estatus en la empresa ");
			lblNewLabel_7.setForeground(Color.WHITE);
			lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 16));
			lblNewLabel_7.setBounds(45, 393, 170, 14);
			panelRegistro.add(lblNewLabel_7);
		}
		{
			separator_4 = new JSeparator();
			separator_4.setBounds(45, 454, 250, 5);
			panelRegistro.add(separator_4);
		}
		{
			estatusR = new JComboBox();
			estatusR.setForeground(new Color(255, 255, 255));
			estatusR.setBackground(new Color(28, 82, 83));
			estatusR.setBorder(null);
			estatusR.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Usuario"}));
			estatusR.setBounds(55, 421, 90, 22);
			panelRegistro.add(estatusR);
		}
		
		passwordR = new JPasswordField();
		passwordR.setForeground(Color.LIGHT_GRAY);
		passwordR.setBackground(new Color(28,82,83));
		passwordR.setBorder(null);
		passwordR.setBounds(55, 333, 250, 20);
		panelRegistro.add(passwordR);
		
		JPanel panelSesion = new JPanel();
		panelSesion.setBackground(new Color(243, 255, 198));
		panelSesion.setBounds(450, 0, 450, 600);
		contentPane.add(panelSesion);
		panelSesion.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Iniciar Sesion");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(140, 35, 200, 36);
		panelSesion.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre de usuario:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(45, 100, 146, 14);
		panelSesion.add(lblNewLabel_1_1);
		
		usuario = new JTextField();
		usuario.setForeground(Color.LIGHT_GRAY);
		usuario.setFont(new Font("Arial", Font.PLAIN, 14));
		usuario.setColumns(10);
		usuario.setCaretColor(Color.GRAY);
		usuario.setBorder(null);
		usuario.setBackground(new Color(243, 255, 198));
		usuario.setBounds(55, 125, 250, 20);
		panelSesion.add(usuario);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(45, 156, 250, 10);
		panelSesion.add(separator_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_3_1.setForeground(Color.BLACK);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(45, 200, 170, 14);
		panelSesion.add(lblNewLabel_3_1);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(Color.BLACK);
		separator_2_1.setBounds(45, 261, 250, 5);
		panelSesion.add(separator_2_1);
		
		JPanel btnSesion = new JPanel();
		btnSesion.addMouseListener(new MouseAdapter() {
			private usuarios mod;

			@Override
			public void mouseClicked(MouseEvent e) {
				
				SQLusuarios modsql = new SQLusuarios();
				usuarios mod = new usuarios();
				
				Date date = new Date();
				DateFormat fechahora= new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
				
				String pas = new String(password.getPassword());
				if(!usuario.getText().equals("")&&!pas.equals("")) {
					String newpas = Hash.sha1(pas);
					
					mod.setUsuario(usuario.getText());
					mod.setContraseña(newpas);
					mod.setLast_session(fechahora.format(date));
					
					if(modsql.login(mod)) {
						this.mod = mod;
						if(mod.getId_tipo()==1) {
							ent();
						}else if(mod.getId_tipo()==2) {
							en();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Datos incorrectos");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Debe ingresar datos");
				}
				
			}
		});
		btnSesion.setBackground(new Color(28,82,83));
		btnSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSesion.setBounds(140, 466, 200, 50);
		panelSesion.add(btnSesion);
		btnSesion.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("INICIAR SESION");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(45, 19, 120, 14);
		btnSesion.add(lblNewLabel_6);
		{
			password = new JPasswordField();
			password.setForeground(Color.LIGHT_GRAY);
			password.setBackground(new Color(243,255,198));
			password.setBorder(null);
			password.setBounds(55, 230, 250, 20);
			panelSesion.add(password);
		}
	}
	

	protected void en() {
	CajaRegistradora x = new CajaRegistradora();
	x.setVisible(true);
	this.dispose();
	}
	public void ent() {
		busproduc mod1 = new busproduc();
		consultas modc = new consultas();
		Administrador x = new Administrador();
		controlador ctr = new controlador(mod1,modc,x);
		ctr.iniciar();
		x.setVisible(true);
		this.dispose();
	}
}
