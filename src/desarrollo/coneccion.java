package desarrollo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class coneccion {
	public static final String base = "exito_chafa";
	public static final String USERNAME = "exito_admin@exito-server";
	public static final String PASSWORD = "Exipasipassword1";
	public static final String URL = "jdbc:mysql://exito-server.mysql.database.azure.com/"+ base;
	private Connection con=null; 
	public Connection getConnection() {
		 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection(this.URL,this.USERNAME,this.PASSWORD);
		 }catch(SQLException e2) {
			 
		 } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		 }
	 }

