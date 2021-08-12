package cprX;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int[] codigos = new int[7];
		int[] cant_bodega = new int[7];
		int[] cant_minima = new int[7];
		
		Scanner input = new Scanner(System.in);
		
		int max_cant = 0;
		int min_cant = 1000000000;
		int max_pos = 0;
		int min_pos = 0;
		
		for(int i = 0; i<7; i++) {
			System.out.println("Ingrese el valor del codigo");
			codigos[i] = input.nextInt();
		}
		
		for(int i = 0; i<7; i++) {
			System.out.println("Ingrese el valor de la cantidad de la bodega");
			cant_bodega[i] = input.nextInt();
		}
		
		for(int i = 0; i<7; i++) {
			System.out.println("Ingrese el valor de la cantidad minima");
			cant_minima[i] = input.nextInt();
		}
		
		System.out.println("Códigos de productos que son necesario pedir");
		for(int i = 0; i<7; i++) {			
			if(cant_bodega[i] < cant_minima[i]) {
				System.out.println(codigos[i]); 
			}
			
			if(cant_bodega[i] > max_cant) {
				max_cant = cant_bodega[i];
				max_pos = i;
			}
			
			if(cant_bodega[i] < min_cant) {
				min_cant = cant_bodega[i];
				min_pos = i;
			}
		}
		
		System.out.println("Código con mayor número unidades:" + codigos[max_pos]);
		System.out.println("Código con menor número unidades:" + codigos[min_pos]);
		
		input.close();
	}

}
