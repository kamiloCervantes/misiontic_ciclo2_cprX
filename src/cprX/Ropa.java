package cprX;

public class Ropa extends Producto{
	
	private String talla;
	
	private boolean planchable;
	
	public Ropa(int codigo, String descripcion, int precio_compra, int precio_venta, int cant_bodega,
			int cant_minima_req, int cant_maxima, String talla, boolean planchable) {
		super(codigo, descripcion, precio_compra, precio_venta, cant_bodega, cant_minima_req, cant_maxima);
		this.talla = talla;
		this.planchable = planchable;
	}
	
	
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public boolean isPlanchable() {
		return planchable;
	}
	public void setPlanchable(boolean planchable) {
		this.planchable = planchable;
	}
}
