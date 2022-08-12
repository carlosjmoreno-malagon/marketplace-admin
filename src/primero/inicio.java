package primero;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import desarrollo.Hash;
import desarrollo_usuarios.SQLusuarios;
import desarrollo_usuarios.usuarios;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class inicio extends JFrame {

	private JPanel contentPane;
	public static JButton entrar;
	public static JTextField usuario;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private usuarios mod;
	public static JPasswordField contraseña;
	public static JTextField id;

	public void en(usuarios mod) {
		this.mod = mod;
		pagina1 x = new pagina1(mod);
		x.setVisible(true);
		this.dispose();
	}
	public void limpiar() {
	id.setText("");
	usuario.setText("");
	contraseña.setText("");
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio frame = new inicio();
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
	public inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(inicio.class.getResource("/primero/img/\u00E9xito chafa.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			entrar = new JButton("Entrar");
			entrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SQLusuarios modsql = new SQLusuarios();
					usuarios mod = new usuarios();
					
					Date date = new Date();
					DateFormat fechahora= new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
					
					String pas = new String(contraseña.getPassword());
					if(!usuario.getText().equals("")&&!pas.equals("")) {
						String newpas = Hash.sha1(pas);
						
						mod.setUsuario(usuario.getText());
						mod.setContraseña(newpas);
						mod.setLast_session(fechahora.format(date));
						if(modsql.login(mod)) {
							en(mod);
						}else {
							JOptionPane.showMessageDialog(null, "Datos incorrectos");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Debe ingresar datos");
					}
				}
			});
			{
				id = new JTextField();
				id.setBounds(200, 58, 22, 20);
				id.setVisible(false);
				contentPane.add(id);
				id.setColumns(10);
			}
			{
				contraseña = new JPasswordField();
				contraseña.setBounds(333, 58, 86, 20);
				contentPane.add(contraseña);
			}
			entrar.setBounds(182, 98, 89, 23);
			contentPane.add(entrar);
		}
		{
			usuario = new JTextField();
			usuario.setBounds(104, 58, 86, 20);
			contentPane.add(usuario);
			usuario.setColumns(10);
		}
		{
			lblNewLabel = new JLabel("Usuario:");
			lblNewLabel.setBackground(Color.BLACK);
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 17));
			lblNewLabel.setBounds(19, 54, 75, 30);
			contentPane.add(lblNewLabel);
		}
		{
			lblNewLabel_1 = new JLabel("Contrase\u00F1a\r\n");
			lblNewLabel_1.setBackground(Color.BLACK);
			lblNewLabel_1.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 17));
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_1.setBounds(230, 52, 93, 35);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(inicio.class.getResource("/primero/img/bienvenido registrese (1).png")));
			lblNewLabel_2.setBounds(-42, 0, 490, 281);
			contentPane.add(lblNewLabel_2);
		}
	}
}
