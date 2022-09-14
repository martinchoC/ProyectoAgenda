package modelos;

public class Servicio {
	
	private int tipo;
	private int precio;
	private String descripcion;
	
	public Servicio(int tipo, int precio, String descripcion) {
		this.tipo = tipo;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
