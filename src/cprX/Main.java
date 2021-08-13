package cprX;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ingrese el número de productos a manejar");
		int num_productos = Integer.parseInt(input.nextLine());
		Producto[] productos = new Producto[num_productos];
		
		for(int i = 0; i < num_productos; i++) {
			System.out.println("Ingrese los datos del producto (Código, precio compra, precio venta, cantidad bodega, cantidad mínima, cantidad máxima)");
			String[] data_producto = input.nextLine().split(" ");			
			Producto p = new Producto(Integer.parseInt(data_producto[0]), Integer.parseInt(data_producto[1]), Integer.parseInt(data_producto[2]), Integer.parseInt(data_producto[3]), Integer.parseInt(data_producto[4]), Integer.parseInt(data_producto[5]));
			productos[i] = p;
		}	
		
		
		menu : while(true) {
			System.out.println("Seleccione una opción del menú:");
			System.out.println("1- Verificar productos a pedir");
			System.out.println("2- Producto con mayor cantidad de unidades");
			System.out.println("3- Total a pagar por pedido a realizar");
			System.out.println("4- Modificar cantidad minima requerida en bodega");
			System.out.println("5- Vender producto");
			System.out.println("--- Para salir del programa presione 0 ---");
			int opcion = Integer.parseInt(input.nextLine());
			switch(opcion) {
				case 0:
					input.close();
					break menu;
				case 1:
					//verificar productos a pedir
					for(int j = 0; j < productos.length; j++) {
						if(productos[j].solicitarPedido()) {
							System.out.println("Alerta! Se debe solicitar pedido al producto "+ productos[j].getCodigo());
						}
					}	
					break;
				case 2:
					//producto con mayor cantidad en bodega
					Producto mayor = null;
					int cant_mayor = 0;
					for(int j = 0; j < productos.length; j++) {
						if(productos[j].getCant_bodega() > cant_mayor) {
							cant_mayor = productos[j].getCant_bodega();
							mayor = productos[j];
						}
					}
					System.out.println("El producto mayor es: "+mayor.getCodigo());
					break;
				case 3:
					//total a pagar
					System.out.println("Ingrese los datos de la compra (Código producto, cantidad)");
					String[] data_compra = input.nextLine().split(" ");
					int cod_producto_compra = Integer.parseInt(data_compra[0]);
					for(int j = 0; j < productos.length; j++) {
						if(productos[j].getCodigo() == cod_producto_compra) {
							System.out.println("El total de la compra es: "+productos[j].totalizarPago(Integer.parseInt(data_compra[1])));
						}
					}
					break;
				case 4:
					//Cambiar cantidad minima requerida
					System.out.println("(1/2) Ingrese el código del producto a actualizar");
					int cod_producto = Integer.parseInt(input.nextLine());	
					System.out.println("(2/2) Ingrese la nueva cantidad mínima del producto");
					int nueva_cant_minima = Integer.parseInt(input.nextLine());
					for(int k = 0; k < productos.length; k++) {
						if(productos[k].getCodigo() == cod_producto) {
							productos[k].setCant_minima_req(nueva_cant_minima);
							System.out.println("La nueva cantidad mínima del producto es: "+productos[k].getCant_minima_req());
						}
					}
					break;
				case 5:
					//vender producto
					System.out.println("Ingrese los datos de la venta (Código producto, cantidad)");
					String[] data_venta = input.nextLine().split(" ");
					int cod_producto_venta = Integer.parseInt(data_venta[0]);
					int cantidad_venta = Integer.parseInt(data_venta[1]);
					for(int h = 0; h < productos.length; h++) {
						if(productos[h].getCodigo() == cod_producto_venta) {
							if(productos[h].getCant_bodega() >= cantidad_venta) {
								double valor_factura_con_descuento = productos[h].totalizarPago(cantidad_venta);
								double valor_factura_sin_descuento = productos[h].totalizarPagoSinDescuento(cantidad_venta);
								productos[h].setCant_bodega(productos[h].getCant_bodega() - cantidad_venta);
								System.out.println("El valor de la venta con descuento es: "+valor_factura_con_descuento);
								System.out.println("El valor de la venta sin descuento es: "+valor_factura_sin_descuento);
								System.out.println("El nuevo valor de cantidad de productos en bodega es: "+productos[h].getCant_bodega());
							}
							else {
								System.out.println("No hay suficiente producto en bodega");
							}				
						}
					}
					break;
				default:
					System.out.println("Opción incorrecta! Intente nuevamente.");
					break;
			
			}
		}
		
	}

}
