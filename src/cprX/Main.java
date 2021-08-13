package cprX;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ingrese el número de productos a manejar");
		int num_productos = Integer.parseInt(input.nextLine());
		Producto[] productos = new Producto[num_productos];
		
		for(int i = 0; i < num_productos; i++) {
			System.out.println("Ingrese los datos del producto (Código, precio, cantidad bodega, cantidad mínima, cantidad máxima)");
			String[] data_producto = input.nextLine().split(" ");			
			Producto p = new Producto(Integer.parseInt(data_producto[0]), Integer.parseInt(data_producto[1]), Integer.parseInt(data_producto[2]), Integer.parseInt(data_producto[3]), Integer.parseInt(data_producto[4]), Integer.parseInt(data_producto[5]));
			productos[i] = p;
		}
		
		//alerta solicitudes de pedidos
		for(int j = 0; j < productos.length; j++) {
			if(productos[j].solicitarPedido()) {
				System.out.println("Alerta! Se debe solicitar pedido al producto "+ productos[j].getCodigo());
			}
		}
		
		//producto mayor
		Producto mayor = null;
		int cant_mayor = 0;
		for(int j = 0; j < productos.length; j++) {
			if(productos[j].getCant_bodega() > cant_mayor) {
				cant_mayor = productos[j].getCant_bodega();
				mayor = productos[j];
			}
		}
		System.out.println("El producto mayor es: "+mayor.getCodigo());
		
		//realizar compra
		System.out.println("Ingrese los datos de la compra (Código producto, cantidad)");
		String[] data_compra = input.nextLine().split(" ");
		for(int j = 0; j < productos.length; j++) {
			if(productos[j].getCodigo() == Integer.parseInt(data_compra[0])) {
				System.out.println("El total de la compra es: "+productos[j].totalizarPago(Integer.parseInt(data_compra[1])));
			}
		}
		
		//Cambiar cantidad minima requerida
		System.out.println("Ingrese el código del producto a actualizar");
		int cod_producto = Integer.parseInt(input.nextLine());	
		System.out.println("Ingrese la nueva cantidad mínima del producto");
		int nueva_cant_minima = Integer.parseInt(input.nextLine());
		for(int k = 0; k < productos.length; k++) {
			if(productos[k].getCodigo() == cod_producto) {
				productos[k].setCant_minima_req(nueva_cant_minima);
				System.out.println("La nueva cantidad mínima del producto es: "+productos[k].getCant_minima_req());
			}
		}
		
		input.close();
	}

}
