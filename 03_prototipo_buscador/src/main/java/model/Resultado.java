package model;

public class Resultado {
	
	private String url;
	private String categoria;
	private String descripcion;
	
	public Resultado(String url, String categoria, String descripcion) {
		super();
		this.url = url;
		this.categoria = categoria;
		this.descripcion = descripcion;
	}

	public Resultado() {
		super();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
