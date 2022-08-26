package desarrollo_usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import desarrollo.coneccion;

public class SQLusuarios extends coneccion {

	public boolean registrar(usuarios usr) {

	PreparedStatement ps = null;
	Connection con = getConnection();
	
	String sql = "INSERT INTO usuarios (usuario, contrase�a, nombre, id_tipo) VALUES(?,?,?,?)";

	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, usr.getUsuario());
		ps.setString(2, usr.getContraseña());
		ps.setString(3, usr.getNombre());
		ps.setInt(4, usr.getId_tipo());
		ps.execute();
		return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	
	}
	public int existeusuario(String usuario) {

	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = getConnection();
	
	String sql = "SELECT count(id) FROM usuarios WHERE usuario = ?";

	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, usuario);

		rs=ps.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 1;
		}
	
	}
	
	public boolean login(usuarios usr) {

	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = getConnection();
	
	String sql = "SELECT u.id,u.usuario,u.contrase�a,u.nombre,u.id_tipo, t.nombre FROM usuarios AS u INNER JOIN tipo_usuario AS t ON u.id_tipo=t.id WHERE usuario =?";

	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, usr.getUsuario());

		rs=ps.executeQuery();
		if(rs.next()) {
			if(usr.getContraseña().equals(rs.getString(3))) {
				String sqlupdate = "UPDATE usuarios SET last_session=? WHERE id = ?";
				ps= con.prepareStatement(sqlupdate);
				ps.setString(1, usr.getLast_session());
				ps.setInt(2, rs.getInt(1));
				ps.execute();
				usr.setId(rs.getInt(1));
				usr.setNombre(rs.getString(4));
				usr.setId_tipo(rs.getInt(5));
				usr.setNombre_tipo(rs.getString(6));
				return true;
			}
			else {
				return false;
			}
		}
		return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	
	}
	
	
}
