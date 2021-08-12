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
		
		Producto menor = null;
		int cant_menor = 1000000000;
		for(int j = 0; j < productos.length; j++) {
			if(productos[j].getCant_bodega() < cant_menor) {
				cant_menor = productos[j].getCant_bodega();
				menor = productos[j];
			}
		}
		System.out.println("El producto menor es: "+menor.getCodigo());
		
			
		
		input.close();
	}

}
