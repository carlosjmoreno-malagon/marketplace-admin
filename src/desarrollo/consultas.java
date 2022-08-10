package desarrollo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class consultas extends coneccion {

	public boolean registrar(busproduc pro) {
		PreparedStatement ps;
		Connection con = getConnection();
		
		String sql = "INSERT INTO producto (productos, precio,peso,id) VALUES(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNombre());
			ps.setDouble(2, pro.getPrecio());
			ps.setInt(3, pro.getPeso());
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
	
	
	
	public boolean modificar(busproduc pro) {
		PreparedStatement ps;
		Connection con = getConnection();
		
		String sql = "UPDATE  producto SET productos=?, precio=?,peso=? WHERE id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNombre());
			ps.setDouble(2, pro.getPrecio());
			ps.setInt(3, pro.getPeso());
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
	
	
	public boolean eliminar(busproduc pro) {
		PreparedStatement ps = null;
		Connection con = getConnection();
		
		String sql = "DELETE FROM  producto WHERE id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pro.getId());
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
	public boolean buscar(busproduc pro) {
		PreparedStatement ps=null;
		ResultSet res=null;
		Connection con = getConnection();
		
		String sql = "SELECT * FROM producto WHERE productos=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNombre());
			res=ps.executeQuery();
			if(res.next()) {
				pro.setId(Integer.parseInt(res.getString("id")));
				pro.setNombre(res.getString("productos"));
				pro.setPrecio(Double.parseDouble(res.getString("precio")));
				pro.setPeso(Integer.parseInt(res.getString("peso")));
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
