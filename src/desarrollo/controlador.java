package desarrollo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import interfas.Administrador;
import interfas.CajaRegistradora;


public class controlador implements MouseListener {

	private busproduc mod;
	private consultas modC;
	private Administrador frm;
	public controlador(busproduc mod, consultas modC, Administrador frm) {
		this.mod = mod;
		this.modC = modC;
		this.frm = frm;
		this.frm.btnEditarDB.addMouseListener((MouseListener) this);
		this.frm.btnAgregarDB.addMouseListener((MouseListener) this);
		this.frm.btnBuscarAD.addMouseListener((MouseListener) this);
		
	}

	public void iniciar() {
		frm.setTitle("productos");
		frm.setLocationRelativeTo(null);
		
	}

	public void limpiar() {
		frm.editarID.setText("");
		frm.editarNombreDelProducto.setText("");
		frm.editarPrecio.setText("");
		frm.editarCantidad.setText("");
	}
	public void limpiar2() {
		frm.idProductoA.setText("");
		frm.nombreDelProductoA.setText("");
		frm.precioDelProductoA.setText("");
		frm.cantidadDeStockA.setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == frm.btnAgregarDB) {
			mod.setNombre(frm.nombreDelProductoA.getText());
			mod.setPrecio(Double.parseDouble(frm.precioDelProductoA.getText()));
			mod.setPeso(Integer.parseInt(frm.cantidadDeStockA.getText()));
			if(modC.registrar(mod)) {
				JOptionPane.showMessageDialog(null, "registro guardado");
				limpiar2();
			}else {
				JOptionPane.showMessageDialog(null, "error al guardado");
				limpiar2();
			}
		}
		if(e.getSource() == frm.btnEditarDB) {
			mod.setId(Integer.parseInt(frm.editarPrecio.getText()));
			mod.setNombre(frm.editarNombreDelProducto.getText());
			mod.setPrecio(Double.parseDouble(frm.editarPrecio.getText()));
			mod.setPeso(Integer.parseInt(frm.editarCantidad.getText()));
			if(modC.modificar(mod)) {
				JOptionPane.showMessageDialog(null, "registro modificado");
				limpiar();
			}else {
				JOptionPane.showMessageDialog(null, "error al modificar");
				limpiar();
			}
		}
		/*if(e.getSource() == frm.borrar) {
			mod.setId(Integer.parseInt(frm.id.getText()));
			if(modC.eliminar(mod)) {
				JOptionPane.showMessageDialog(null, "registro eliminado");
				limpiar();
			}else {
				JOptionPane.showMessageDialog(null, "error al eliminar");
				limpiar();
			}
		}*/
		if(e.getSource() == frm.btnBuscarAD) {
			mod.setNombre(frm.editarNombreDelProducto.getText());
			if(modC.buscar(mod)) {
				frm.editarID.setText(String.valueOf(mod.getId()));
				frm.editarPrecio.setText(String.valueOf(mod.getPrecio()));
				frm.editarCantidad.setText(String.valueOf(mod.getPeso()));
			}else {
				JOptionPane.showMessageDialog(null, "error al Encintrar el producto");
				limpiar();
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	
	
}
