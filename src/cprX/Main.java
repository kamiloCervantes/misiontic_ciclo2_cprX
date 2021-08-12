package cprX;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Ingrese la lista de códigos de producto. Ej. 354 256 127");
		String[] codigos_productos = input.nextLine().split(" ");
		
		System.out.println("Ingrese la tabla de cantidades en bodega. Ej. 17 34 60;14 31 65;45 2 12;56 43 8");
		String[] cantidades_bodega = input.nextLine().split(";");
		String[][] matriz_cantidades_bodega = new String[4][codigos_productos.length];
		for(int i = 0; i< cantidades_bodega.length; i++) {
			matriz_cantidades_bodega[i] = cantidades_bodega[i].split(" ");
		}
		
		System.out.println("Ingrese la tabla de cantidades minimas requeridas. Ej. 14 44 76;10 51 15;46 23 2;89 4 18");
		String[] cantidades_minimas = input.nextLine().split(";");
		String[][] matriz_cantidades_minimas = new String[4][codigos_productos.length];
		for(int j = 0; j< cantidades_minimas.length; j++) {
			matriz_cantidades_minimas[j] = cantidades_minimas[j].split(" ");
		}
		
		//Se debe solicitar producto en ...
		for(int m = 0; m < 4; m++) {
			for(int n = 0; n < codigos_productos.length; n++) {
				String producto = codigos_productos[n];
				if(Integer.parseInt(matriz_cantidades_bodega[m][n]) < Integer.parseInt(matriz_cantidades_minimas[m][n])) {
					System.out.println("Se debe solicitar producto "+producto+" en sede "+m);
				}
			}
		}
		
		//Promedio de productos ...
		double[] promedios = new double[codigos_productos.length];
		for(int m = 0; m < 4; m++) {
			for(int n = 0; n < codigos_productos.length; n++) {
				promedios[n] = promedios[n] + Integer.parseInt(matriz_cantidades_bodega[m][n]);
			}
		}
		
		for(int d = 0; d < promedios.length; d++) {
			System.out.println("El promedio de productos del codigo "+codigos_productos[d]+" es "+promedios[d]/4);
		}
		
		/*
		 * Nota: Los promedios son diferentes a los de la lección dado que me parece
		 * que la forma correcta de sacarlos es sumando la cantidad del producto en
		 * bodega de cada sede y dividiendo entre 4. En el componente práctico no se
		 * sabe como sacaron esos promedios pero no corresponde con lo que debería ser.
		 */
		
		
		
		input.close();
	}

}
