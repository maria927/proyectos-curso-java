package co.com.udem.crud.dto;

public class LibroDTO {
	
	private Long id;	
	private String nombre;
	private String editorial;
	private int año;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	
	public LibroDTO() {
		super();
	}
	public LibroDTO(Long id, String nombre, String editorial, int año) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.editorial = editorial;
		this.año = año;
	}
	
	

}
