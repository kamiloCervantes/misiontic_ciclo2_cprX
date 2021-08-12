package cprX;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ingrese el número de productos a manejar");
		int num_productos = Integer.parseInt(input.nextLine());
		Producto[] productos = new Producto[num_productos];
		
		for(int i = 0; i < num_productos; i++) {
			System.out.println("Ingrese los datos del producto (Código, precio, cantidad bodega, cantidad mínima)");
			String[] data_producto = input.nextLine().split(" ");			
			Producto p = new Producto(Integer.parseInt(data_producto[0]), Integer.parseInt(data_producto[1]), Integer.parseInt(data_producto[2]), Integer.parseInt(data_producto[3]));
			productos[i] = p;
		}
		
		for(int j = 0; j < productos.length; j++) {
			if(productos[j].solicitarPedido()) {
				System.out.println("Alerta! Se debe solicitar pedido al producto "+ productos[j].getCodigo());
			}
		}
		
		Producto mayor = null;
		int cant_mayor = 0;
		for(int j = 0; j < productos.length; j++) {
			if(productos[j].getCant_bodega() > cant_mayor) {
				cant_mayor = productos[j].getCant_bodega();
				mayor = productos[j];
			}
		}
		System.out.println("El producto mayor es: "+mayor.getCodigo());
		
		System.out.println("Ingrese los datos de la compra (Código producto, cantidad)");
		String[] data_compra = input.nextLine().split(" ");
		for(int j = 0; j < productos.length; j++) {
			if(productos[j].getCodigo() == Integer.parseInt(data_compra[0])) {
				System.out.println("El total de la compra es: "+productos[j].totalizarPago(Integer.parseInt(data_compra[1])));
			}
		}
			
		
		input.close();
	}

}
