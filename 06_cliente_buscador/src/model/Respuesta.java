package model;

public class Respuesta {
	
	private String url;
	private String categoria;
	private String descripcion;
	
	public Respuesta(String url, String tematica, String descripcion) {
		super();
		this.url = url;
		this.categoria = categoria;
		this.descripcion = descripcion;
	}
	
	public Respuesta() {
		super();
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getcategoria() {
		return categoria;
	}
	public void setcategoria(String tematica) {
		this.categoria = tematica;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
