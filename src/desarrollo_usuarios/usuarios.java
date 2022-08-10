package desarrollo_usuarios;

public class usuarios {	
private int id;
private String usuario;
private String contraseña;
private String nombre;
private String last_session;
private int id_tipo;
private String nombre_tipo;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getContraseña() {
	return contraseña;
}
public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getLast_session() {
	return last_session;
}
public void setLast_session(String last_session) {
	this.last_session = last_session;
}
public int getId_tipo() {
	return id_tipo;
}
public void setId_tipo(int id_tipo) {
	this.id_tipo = id_tipo;
}
public String getNombre_tipo() {
	return nombre_tipo;
}
public void setNombre_tipo(String nombre_tipo) {
	this.nombre_tipo = nombre_tipo;
}

}
