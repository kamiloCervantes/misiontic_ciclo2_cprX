package cprX;

public class Calzado extends Producto{

	private String talla;
	
	public Calzado(int codigo, String descripcion, int precio_compra, int precio_venta, int cant_bodega,
			int cant_minima_req, int cant_maxima, String talla) {
		super(codigo, descripcion, precio_compra, precio_venta, cant_bodega, cant_minima_req, cant_maxima);
		this.talla = talla;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}
}
