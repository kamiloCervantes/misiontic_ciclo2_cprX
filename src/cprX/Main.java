package cprX;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ingrese los datos del producto (Código, precio, cantidad bodega, cantidad mínima");
		String[] data_producto = input.nextLine().split(" ");
		
		Producto p = new Producto(Integer.parseInt(data_producto[0]), Integer.parseInt(data_producto[1]), Integer.parseInt(data_producto[2]), Integer.parseInt(data_producto[3]));
		if(p.solicitarPedido()) {
			System.out.println("Alerta! Solicitar pedido!");
		}		
		
		input.close();
	}

}
