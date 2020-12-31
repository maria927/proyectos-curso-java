package co.com.udem.clubfutbol.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DirectorTecnico {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String nombres;
	private String apellidos;
	private int edad;
	
	@OneToOne(mappedBy = "directorTecnico")
	private ClubFutbol clubFutbol;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	

	public DirectorTecnico(Long id, String nombres, String apellidos, int edad, ClubFutbol clubFutbol) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.clubFutbol = clubFutbol;
	}
	public DirectorTecnico() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
