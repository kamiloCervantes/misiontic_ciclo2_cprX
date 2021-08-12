package cprX;

public class Producto {
	
	private int codigo;
	private int precio_compra;
	private int cant_bodega;
	private int cant_minima_req;
	private int cant_maxima;
	private float descuento;
	
	public Producto(int codigo, int precio_compra, int cant_bodega, int cant_minima_req) {
		super();
		this.codigo = codigo;
		this.precio_compra = precio_compra;
		this.cant_bodega = cant_bodega;
		this.cant_minima_req = cant_minima_req;
		this.cant_maxima = 0;
		this.descuento = 1.0f;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(int precio_compra) {
		this.precio_compra = precio_compra;
	}

	public int getCant_bodega() {
		return cant_bodega;
	}

	public void setCant_bodega(int cant_bodega) {
		this.cant_bodega = cant_bodega;
	}

	public int getCant_minima_req() {
		return cant_minima_req;
	}

	public void setCant_minima_req(int cant_minima_req) {
		if(cant_minima_req >= 0) {
			this.cant_minima_req = cant_minima_req;
		}
		else {
			this.cant_minima_req = 0;
		}
		
	}
	
	public int getCant_maxima() {
		return cant_maxima;
	}

	public void setCant_maxima(int cant_maxima) {
		this.cant_maxima = cant_maxima;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public boolean solicitarPedido() {
		return this.cant_bodega < this.cant_minima_req;
	}
	
	public float totalizarPago(int unidades) {
		return (unidades*this.precio_compra)*((100-this.descuento)/100);
	}
	
	
	
	
	

}
