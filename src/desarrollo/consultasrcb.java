package desarrollo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class consultasrcb extends coneccion{
	public boolean registrar(rcb pro) {
		PreparedStatement ps;
		Connection con = getConnection();
		String sql = "INSERT INTO recibo (nombre, precio,tamaño,id) VALUES(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNombre());
			ps.setDouble(2, pro.getPrecio());
			ps.setDouble(3, pro.getTamaño());
			ps.setInt(4, pro.getId());
			ps.execute();
			return true;
		}catch(SQLException e) {
			System.out.println("error");
			return false;
		}finally {
			try {
				con.close();
			}catch(SQLException e1) {
				System.err.println(e1);
			}
		}
		
		
	}
	
	
	
	public boolean modificar(rcb pro) {
		PreparedStatement ps;
		Connection con = getConnection();
		
		String sql = "UPDATE  recibo SET nombre=?, precio=?,tamaño=? WHERE id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNombre());
			ps.setDouble(2, pro.getPrecio());
			ps.setDouble(3, pro.getTamaño());
			ps.setInt(4, pro.getId());
			ps.execute();
			return true;
		}catch(SQLException e) {
			System.out.println("error");
			return false;
		}finally {
			try {
				con.close();
			}catch(SQLException e1) {
				System.err.println(e1);
			}
		}
		
		
	}
	
	
	public boolean eliminar(rcb pro) {
		PreparedStatement ps = null;
		Connection con = getConnection();
		
		String sql = "DELETE FROM  recibo";
		try {
			ps = con.prepareStatement(sql);
			ps.execute();
			return true;
		}catch(SQLException e) {
			System.out.println("error");
			return false;
		}finally {
			try {
				con.close();
			}catch(SQLException e1) {
				System.err.println(e1);
			}
		}
		
		
	}
	public boolean buscar(rcb pro) {
		PreparedStatement ps=null;
		ResultSet res=null;
		Connection con = getConnection();
		
		String sql = "SELECT * FROM productos WHERE productos=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNombre());
			res=ps.executeQuery();
			if(res.next()) {
				pro.setId(Integer.parseInt(res.getString("id")));
				pro.setNombre(res.getString("productos"));
				pro.setPrecio(Double.parseDouble(res.getString("precio")));
				return true;
			} 
			return false;
		}catch(SQLException e) {
			System.out.println("error");
			return false;
		}finally {
			try {
				con.close();
			}catch(SQLException e1) {
				System.err.println(e1);
			}
		}
		
		
	}
}
