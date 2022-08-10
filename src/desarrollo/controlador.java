package desarrollo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import primero.registro;

public class controlador implements ActionListener {

	private busproduc mod;
	private consultas modC;
	private registro frm;
	public controlador(busproduc mod, consultas modC, registro frm) {
		this.mod = mod;
		this.modC = modC;
		this.frm = frm;
		this.frm.guardar.addActionListener(this);
		this.frm.modificar.addActionListener(this);
		this.frm.borrar.addActionListener(this);
		this.frm.buscar.addActionListener(this);
		
	}

	public void iniciar() {
		frm.setTitle("productos");
		frm.setLocationRelativeTo(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == frm.guardar) {
			mod.setNombre(frm.nombre.getText());
			mod.setPrecio(Double.parseDouble(frm.precio.getText()));
			mod.setPeso(Integer.parseInt(frm.tamaño.getText()));
			if(modC.registrar(mod)) {
				JOptionPane.showMessageDialog(null, "registro guardado");
				limpiar();
			}else {
				JOptionPane.showMessageDialog(null, "error al guardado");
				limpiar();
			}
		}
		if(e.getSource() == frm.modificar) {
			mod.setId(Integer.parseInt(frm.id.getText()));
			mod.setNombre(frm.nombre.getText());
			mod.setPrecio(Double.parseDouble(frm.precio.getText()));
			mod.setPeso(Integer.parseInt(frm.tamaño.getText()));
			if(modC.modificar(mod)) {
				JOptionPane.showMessageDialog(null, "registro modificado");
				limpiar();
			}else {
				JOptionPane.showMessageDialog(null, "error al modificar");
				limpiar();
			}
		}
		if(e.getSource() == frm.borrar) {
			mod.setId(Integer.parseInt(frm.id.getText()));
			if(modC.eliminar(mod)) {
				JOptionPane.showMessageDialog(null, "registro eliminado");
				limpiar();
			}else {
				JOptionPane.showMessageDialog(null, "error al eliminar");
				limpiar();
			}
		}
		if(e.getSource() == frm.buscar) {
			mod.setNombre(frm.nombre.getText());
			if(modC.buscar(mod)) {
				frm.id.setText(String.valueOf(mod.getId()));
				frm.precio.setText(String.valueOf(mod.getPrecio()));
				frm.tamaño.setText(String.valueOf(mod.getPeso()));
			}else {
				JOptionPane.showMessageDialog(null, "error al Encintrar el producto");
				limpiar();
			}
		}
	}
	public void limpiar() {
		frm.id.setText("");
		frm.nombre.setText("");
		frm.precio.setText("");
		frm.tamaño.setText("");
	}
	
	
}
