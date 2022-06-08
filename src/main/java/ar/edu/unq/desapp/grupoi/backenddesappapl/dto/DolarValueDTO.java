package ar.edu.unq.desapp.grupoi.backenddesappapl.dto;

public class DolarValueDTO {
	
	private String compra;
	private String venta;
	private String nombre;
	
	public DolarValueDTO() {}
	
	public DolarValueDTO(String compra, String venta, String nombre) {
		this.compra = compra;
		this.venta = venta;
		this.nombre = nombre;
	}

	public Float getCompra() {
		String compra = this.compra.replace(",", ".");
		return Float.valueOf(compra);
	}

	public void setCompra(String compra) {
		this.compra = compra;
	}

	public Float getVenta() {
		String venta = this.venta.replace(",", ".");
		return Float.valueOf(venta);
	}

	public void setVenta(String venta) {
		this.venta = venta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	
	
	
}

