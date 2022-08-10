package desarrollo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import primero.cajero;
import primero.registro;

public class fun implements ActionListener {
	private busproduc mod;
	private consultas modC;
	private cajero frm;
	public fun(busproduc mod, consultas modC,  cajero frm) {
		this.mod = mod;
		this.modC = modC;
		this.frm = frm;
		this.frm.buscar.addActionListener(this);
	}
	public void iniciar() {
		frm.setTitle("productos");
		frm.setLocationRelativeTo(null);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == frm.buscar) {
			mod.setNombre(frm.producto.getText());
			if(modC.buscar(mod)) {
				frm.id.setText(String.valueOf(mod.getId()));
				frm.precio.setText(String.valueOf(mod.getPrecio()));
				frm.can.setText(String.valueOf(mod.getPeso()));
			}else {
				JOptionPane.showMessageDialog(null, "error al Encintrar el producto");
				limpiar();
			}
		}
	}
	public void limpiar() {
		frm.id.setText("");
		frm.producto.setText("");
		frm.precio.setText("");
		frm.can.setText("");
	}
}
	
