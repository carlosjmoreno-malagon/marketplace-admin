package primero;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;

public class pago extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pago frame = new pago();
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
	public pago() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(pago.class.getResource("/primero/img/\u00E9xito chafa.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnNewButton_1 = new JButton("New button");
			btnNewButton_1.setBounds(375, 274, 89, 23);
			contentPane.add(btnNewButton_1);
		}
		{
			btnNewButton = new JButton("");
			btnNewButton.setBackground(Color.CYAN);
			btnNewButton.setIcon(new ImageIcon(pago.class.getResource("/primero/img/Icono-guardar (2).png")));
			btnNewButton.setBounds(34, 268, 53, 29);
			contentPane.add(btnNewButton);
		}
		{
			textField = new JTextField();
			textField.setBounds(34, 117, 169, 20);
			contentPane.add(textField);
			textField.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("cantidad a pagar");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(34, 92, 169, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel = new JLabel("\r\n");
			lblNewLabel.setIcon(new ImageIcon(pago.class.getResource("/primero/img/exito chafa (2).png")));
			lblNewLabel.setBounds(0, 0, 554, 306);
			contentPane.add(lblNewLabel);
		}
	}
}
