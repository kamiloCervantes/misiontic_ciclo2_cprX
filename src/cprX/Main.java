package cprX;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Ingrese el numero de productos de tipo de prendas de vestir a manejar");
		int num_productos_vestir = Integer.parseInt(in.nextLine());
		System.out.println("Ingrese el numero de productos de tipo calzado a manejar");
		int num_productos_calzado = Integer.parseInt(in.nextLine());
		Ropa r[] = new Ropa[num_productos_vestir];
		Calzado c[] = new Calzado[num_productos_calzado];
		for(int i = 0; i< num_productos_vestir; i++) {
			System.out.println("Ingrese los datos de la prenda de vestir (Codigo, descripcion, precio_compra, precio_venta, cantidad bodega, cantidad mínima, cantidad máxima, talla, planchable(S|N))");
			String[] datos = in.nextLine().split(" ");
			int codigo = Integer.parseInt(datos[0]);
			String descripcion = datos[1];
			int precio_compra = Integer.parseInt(datos[2]);
			int precio_venta = Integer.parseInt(datos[3]);
			int cant_bodega = Integer.parseInt(datos[4]);
			int cant_minima_req = Integer.parseInt(datos[5]);
			int cant_maxima = Integer.parseInt(datos[6]);
			String talla = datos[7];
			boolean planchable = datos[8].equals("S");
			Ropa ropa = new Ropa(codigo,descripcion,precio_compra,precio_venta,cant_bodega,cant_minima_req, cant_maxima, talla, planchable);
			r[i] = ropa;
		}
		for(int i = 0; i< num_productos_calzado; i++) {
			System.out.println("Ingrese los datos de la prenda de calzado");
			String[] datos = in.nextLine().split(" ");
			int codigo = Integer.parseInt(datos[0]);
			String descripcion = datos[1];
			int precio_compra = Integer.parseInt(datos[2]);
			int precio_venta = Integer.parseInt(datos[3]);
			int cant_bodega = Integer.parseInt(datos[4]);
			int cant_minima_req = Integer.parseInt(datos[5]);
			int cant_maxima = Integer.parseInt(datos[6]);
			String talla = datos[7];
			Calzado calzado = new Calzado(codigo,descripcion,precio_compra,precio_venta,cant_bodega,cant_minima_req, cant_maxima, talla);
			c[i] = calzado;
		}
		
		//verificar productos a pedir
		System.out.println("---- Productos a pedir ----");
		for(int i = 0; i< r.length; i++) {
			if(r[i].solicitarPedido()) {
				System.out.println("El producto "+r[i].getCodigo()+" cuenta en bodega con "+r[i].getCant_bodega()+" y su cantidad minima en bodega es "+r[i].getCant_minima_req()+". Se debe solicitar un nuevo pedido al proveedor");
			}
			else {
				System.out.println("El producto "+r[i].getCodigo()+" cuenta en bodega con "+r[i].getCant_bodega()+" y su cantidad minima en bodega es "+r[i].getCant_minima_req()+". No se requiere un nuevo pedido.");

			}		
		}
		for(int i = 0; i< c.length; i++) {
			if(c[i].solicitarPedido()) {
				System.out.println("El producto "+c[i].getCodigo()+" cuenta en bodega con "+c[i].getCant_bodega()+" y su cantidad minima en bodega es "+c[i].getCant_minima_req()+". Se debe solicitar un nuevo pedido al proveedor");
			}
			else {
				System.out.println("El producto "+c[i].getCodigo()+" cuenta en bodega con "+c[i].getCant_bodega()+" y su cantidad minima en bodega es "+c[i].getCant_minima_req()+". No se requiere un nuevo pedido.");

			}		
		}
		
		//calzado con mayor cantidad de unidades
		System.out.println("---- Mayores cantidades de unidades ----");
		int cant_calzado_max = 0;
		Calzado c_max = null;
		for(int i = 0; i< c.length; i++) {
			if(c[i].getCant_bodega() > cant_calzado_max) {
				cant_calzado_max = c[i].getCant_bodega();
				c_max = c[i];
			}
		}
		System.out.println("El producto "+c_max.getCodigo()+" es el que más producto tiene en bodega. Su talla es "+c_max.getTalla());
		
		//prenda con mayor cantidad de unidades
		int cant_prendas_max = 0;
		Ropa r_max = null;
		for(int i = 0; i< r.length; i++) {
			if(r[i].getCant_bodega() > cant_prendas_max) {
				cant_prendas_max = r[i].getCant_bodega();
				r_max = r[i];
			}
		}
		System.out.println("El producto "+r_max.getCodigo()+" es el que más producto tiene en bodega. Su talla es "+r_max.getTalla());
		
		in.close();
	}

}
