package cprX;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		//Ejemplo 1
		System.out.println("Ejemplo 1. Ingrese la cantidad en bodega y la cantidad minima requerida");
		String[] e1_data = input.nextLine().split(" ");
		int e1_cant_bodega = Integer.parseInt(e1_data[0]);
		int e1_cant_minima_req = Integer.parseInt(e1_data[1]);
		
		if(e1_cant_bodega < e1_cant_minima_req) {
			System.out.println("Es necesario realizar un nuevo pedido");
		}
		if(e1_cant_bodega > e1_cant_minima_req) {
			System.out.println("No es necesario realizar un nuevo pedido");
		}
		
		//Ejemplo 2
		System.out.println("Ejemplo 2. Ingrese la cantidad en bodega y la cantidad minima requerida");
		String[] e2_data = input.nextLine().split(" ");
		int e2_cant_bodega = Integer.parseInt(e2_data[0]);
		int e2_cant_minima_req = Integer.parseInt(e2_data[1]);
		
		if(e2_cant_bodega < e2_cant_minima_req) {
			System.out.println("Es necesario realizar un nuevo pedido");
		}
		else {
			System.out.println("No es necesario realizar un nuevo pedido");
		}
		
		//Ejemplo 3
		System.out.println("Ejemplo 3. Ingrese la cantidad en bodega y la cantidad minima requerida");
		String[] e3_data = input.nextLine().split(" ");
		int e3_cant_bodega = Integer.parseInt(e3_data[0]);
		int e3_cant_minima_req = Integer.parseInt(e3_data[1]);
		int e3_diferencia = e3_cant_bodega - e3_cant_minima_req;
		if(e3_cant_bodega < e3_cant_minima_req) {
			System.out.println("Es necesario realizar un nuevo pedido");
		}
		else if(e3_diferencia < 10) {
			System.out.println("No es necesario realizar un nuevo pedido");
			System.out.println("Unidades que hacen falta vender: " + e3_diferencia +". Alerta generada");
		} 
		else {
			System.out.println("No es necesario realizar un nuevo pedido");
			System.out.println("Unidades que hacen falta vender: " + e3_diferencia);
		}			
		
		
		//Ejemplo 4
		System.out.println("Ejemplo 4. Ingrese la cantidad en bodega y la cantidad minima requerida");
		String[] e4_data = input.nextLine().split(" ");
		int e4_cant_bodega = Integer.parseInt(e4_data[0]);
		int e4_cant_minima_req = Integer.parseInt(e4_data[1]);
		int e4_diferencia = e4_cant_bodega - e4_cant_minima_req;
		if(e4_cant_bodega < e4_cant_minima_req) {
			System.out.println("Es necesario realizar un nuevo pedido");
			System.out.println("Ingrese las unidades de compra, el valor de compra del producto y el dinero en caja");
			String[] e4_data_compra = input.nextLine().split(" ");
			int e4_cantidad_compra = Integer.parseInt(e4_data_compra[0]);
			int e4_valor_compra = Integer.parseInt(e4_data_compra[1]);
			int e4_saldo_caja = Integer.parseInt(e4_data_compra[2]);
			int e4_total_compra = e4_cantidad_compra * e4_valor_compra;
			if(e4_saldo_caja >= e4_total_compra) {
				System.out.println("Si es posible realizar el pedido");
			}
			else {
				System.out.println("No es posible realizar el pedido");
			}
			
		}
		else {
			System.out.println("No es necesario realizar un nuevo pedido");
			if(e4_diferencia < 10) {
				System.out.println("Unidades que hacen falta vender: " + e4_diferencia +". Alerta generada");
			}
			else {
				System.out.println("Unidades que hacen falta vender: " + e4_diferencia);
			}
		}
		
		//Ejemplo 5
		System.out.println("Ejemplo 5. Ingrese el día de la semana en el que se realice la compra y el total a pagar");
		String[] e5_data =  input.nextLine().split(" ");
		int e5_dia_semana = Integer.parseInt(e5_data[0]);
		double e5_total_a_pagar = Integer.parseInt(e5_data[1]);
		switch(e5_dia_semana) {
			case 1:
				e5_total_a_pagar = e5_total_a_pagar * (1 - 0.05);
				break;
			case 2:
				e5_total_a_pagar = e5_total_a_pagar * (1 - 0.03);
				break;
			case 3:
				e5_total_a_pagar = e5_total_a_pagar * (1 - 0.1);
				break;
			case 4:
				e5_total_a_pagar = e5_total_a_pagar * (1 - 0.04);
				break;
			case 5:
				e5_total_a_pagar = e5_total_a_pagar * (1 - 0.06);
				break;
			case 6:
				e5_total_a_pagar = e5_total_a_pagar * (1 - 0.02);
				break;
			case 7:
				e5_total_a_pagar = e5_total_a_pagar * (1 - 0.01);
				break;
			default:
				System.out.println("No es un día válido! No se le aplica descuento");
				break;
		}
		System.out.println("El valor a pagar es: $"+(int) e5_total_a_pagar);
		
		//Ejemplo 6
		System.out.println("Ejemplo 6: Ingrese el número de productos");
		int e6_num_productos = Integer.parseInt(input.nextLine());
		int e6_total = 0;
		for(int i = 0; i < e6_num_productos; i++) {
			System.out.println("Ingrese la cantidad y el valor del producto "+(i+1));
			String[] e6_data_producto = input.nextLine().split(" ");
			int e6_cantidad = Integer.parseInt(e6_data_producto[0]);
			int e6_valor = Integer.parseInt(e6_data_producto[1]);
			e6_total = e6_total + (e6_cantidad * e6_valor);
		}
		System.out.println("Total de la factura: "+e6_total);
		
		//Ejemplo 7
		boolean continuar = true;
		int c = 0;
		while(continuar) {
			c++;
			System.out.println("--------- Cliente "+c+" -----------");
			System.out.println("Ingrese el número de productos");
			int e7_num_productos = Integer.parseInt(input.nextLine());
			int e7_total = 0;
			for(int i = 0; i < e7_num_productos; i++) {
				System.out.println("Ingrese la cantidad y el valor del producto "+(i+1));
				String[] e7_data_producto = input.nextLine().split(" ");
				int e7_cantidad = Integer.parseInt(e7_data_producto[0]);
				int e7_valor = Integer.parseInt(e7_data_producto[1]);
				e7_total = e7_total + (e7_cantidad * e7_valor);
			}
			System.out.println("Total de la factura: "+e7_total);
			System.out.println("¿Desea continuar con otro cliente? (S)");
			String e7_respuesta = input.nextLine();
			if(e7_respuesta.equalsIgnoreCase("n")) {
				continuar = false;
			}
		}
		
		
		input.close();
	}

}
