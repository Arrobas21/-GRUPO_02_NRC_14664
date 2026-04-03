package Clases;

public class Estudiante {
	private String nombre,apellidos,carrera,CodigoUniversitario;
	private int idUsuario;
	public Estudiante(String nombre, String apellidos, String carrera, String codigoUniversitario, int idUsuario) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.carrera = carrera;
		CodigoUniversitario = codigoUniversitario;
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getCodigoUniversitario() {
		return CodigoUniversitario;
	}
	public void setCodigoUniversitario(String codigoUniversitario) {
		CodigoUniversitario = codigoUniversitario;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
	
	

}
