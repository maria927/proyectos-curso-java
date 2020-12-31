package co.com.udem.dto;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;

public class Empresa {
	
	private int nit = 1923837;
	private String nombre = "Contar";
	private String direccion = "Calle 19";
	private int telefono= 2222121;
	
	@Autowired
	private Empleado empleado;

	
	public int getNit() {
		return nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	

}
