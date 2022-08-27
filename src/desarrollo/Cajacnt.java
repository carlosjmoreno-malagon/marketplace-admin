package desarrollo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import interfas.Administrador;
import interfas.CajaRegistradora;

public class Cajacnt implements MouseListener {
	private busproduc mod;
	private consultas modC;
	private CajaRegistradora frm;
	double x ;
	public Cajacnt(busproduc mod, consultas modC, CajaRegistradora frm) {
		this.mod = mod;
		this.modC = modC;
		this.frm = frm;
		this.frm.btnAgregar.addMouseListener((MouseListener) this);
		this.frm.btnRecibo.addMouseListener((MouseListener)this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void llet() {
		DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
   
        modelo.addColumn("Nombre");
        modelo.addColumn("precio");
        this.frm.table.setModel(modelo);
       
      variables.Total.add(mod);
      for(int i=0;i<variables.Total.size();i++) {
    	  String arreglo[]= new String[2];
    	  busproduc tmp;
    	  tmp = (busproduc) variables.Total.get(i);
       arreglo[0] = tmp.getNombre();
	   arreglo[1] = String.valueOf(tmp.getPrecio());
       modelo.addRow(arreglo);
      }
    	   
       
     
	 /*  arreglo[0] = "12222222";
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

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == frm.btnAgregar) {
			mod.setNombre(frm.nombreDelProducto.getText());
			if(modC.buscar(mod)) {
				JOptionPane.showMessageDialog(null, "se a guradado correctamente");
				String can = frm.cantidadDeProducto.getText();
			variables.x=mod.getPrecio()+Double.parseDouble(can);
		       variables.total+=variables.x;
				 frm.total.setText(String.valueOf(variables.total)); 
				
			}else {
				JOptionPane.showMessageDialog(null, "error al Encontrar el producto");
				//limpiar();
			}
			
		}
		if(e.getSource() == frm.btnRecibo) {
		if(modC.buscar(mod)) {
			llet();
		}
		}
		
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
	public void iniciar() {
		frm.setTitle("productos");
		frm.setLocationRelativeTo(null);
		
	}

	
	
	
}
