package primero;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import desarrollo.busproduc;
import desarrollo.consultas;
import desarrollo.controlador;
import desarrollo.fun;
import desarrollo_usuarios.usuarios;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import java.awt.Button;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class pagina1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu productos;
	private JMenu usu;
	private JMenu mnNewMenu_2;
	private JMenuItem agragaus;
	private JMenuItem catalogous;
	private JMenuItem agrega;
	usuarios mod; 
	private JLabel nombre;
	private JLabel rol;
	private JMenuItem caja;
	private JMenuItem reacaudado;
	private JLabel lblNewLabel;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pagina1 frame = new pagina1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void agragar() {
		busproduc mod = new busproduc();
		consultas modc = new consultas();
		registro x = new registro();
		controlador ctr = new controlador(mod,modc,x);
		ctr.iniciar();
		x.setVisible(true);
		this.dispose();
	}
	private void usuarios() {
		registro_usua x = new registro_usua();
		x.setVisible(true);
		this.dispose();
	}
	private void cajero() {
		busproduc mod = new busproduc();
		consultas modc = new consultas();
		 cajero x = new cajero();
		fun ctr = new fun(mod,modc,x);
		ctr.iniciar();
		x.setVisible(true);
		this.dispose();
	}
	private void login() {
		cajero x = new cajero();
		x.setVisible(true);
		this.dispose();
	}
	public pagina1() {
		componets();
	}
	private void componets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 313);
		{
			menuBar = new JMenuBar();
			menuBar.setBackground(Color.WHITE);
			setJMenuBar(menuBar);
			{
				productos = new JMenu("sistema");
				menuBar.add(productos);
				{
					agrega = new JMenuItem("Modificar productos");
					agrega.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							agragar();
						}
					});
					productos.add(agrega);
				}
			}
			{
				usu = new JMenu("Registro de usuarios");
				menuBar.add(usu);
				{
					agragaus = new JMenuItem("Agregar usuario");
					agragaus.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							usuarios();
						}
					});
					agragaus.setHorizontalAlignment(SwingConstants.CENTER);
					usu.add(agragaus);
				}
				{
					catalogous = new JMenuItem("Modificar usuario");
					usu.add(catalogous);
				}
			}
			{
				mnNewMenu_2 = new JMenu("tienda");
				menuBar.add(mnNewMenu_2);
				{
					caja = new JMenuItem("Caja registradora ");
					caja.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cajero();
						}
					});
					mnNewMenu_2.add(caja);
				}
				{
					reacaudado = new JMenuItem("recaudado en el dia");
					mnNewMenu_2.add(reacaudado);
				}
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			nombre = new JLabel("");
			nombre.setBounds(10, 74, 324, 62);
			contentPane.add(nombre);
		}
		{
			rol = new JLabel("");
			rol.setBounds(10, 153, 324, 62);
			contentPane.add(rol);
		}
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(pagina1.class.getResource("/primero/img/exito chafa (1).png")));
			lblNewLabel.setBounds(0, 0, 512, 256);
			contentPane.add(lblNewLabel);
		}
		
	}
	public pagina1(usuarios mod) { 
		componets();
		this.mod = mod;
		nombre.setText("Bienvenido señor: "+ mod.getNombre());
		rol.setText(mod.getNombre_tipo());
		if(mod.getId_tipo()==1) {
		
		}else if(mod.getId_tipo()==2) {
			productos.setVisible(false);
			usu.setVisible(false);
		}
	}
}