package com.matrices.Servicio_Matrices.service.model;

public class MatrizMultiplicar {

	public double [][] multiplicarMatriz(String matrices) {

		ProcesarMatrices procesar = new ProcesarMatrices();

		String[] matriz = procesar.procesarMatriz(matrices);
		String[] matriz1 = procesar.generarMatriz(matriz[0]);
		String[] matriz2 = procesar.generarMatriz(matriz[1]);

		double [][] matrizA = procesar.convertirMatriz(matriz1);
		double [][] matrizB = procesar.convertirMatriz(matriz2);

		int filaA = matrizA.length;
		int colB = matrizB[0].length;
		int colA = matrizA[0].length;
		double tempMultiplicacion;
		double resultado[][] = new double[filaA][colB];

		for (int f = 0; f < filaA; f++) {
			for (int c = 0; c < colB; c++) {
				tempMultiplicacion = 0;
				for (int i = 0; i < colA; i++) {
					tempMultiplicacion = tempMultiplicacion + matrizA[f][i] * matrizB[i][c];
				}
				resultado[f][c] = tempMultiplicacion;
			}

		}

		return resultado;
	}

//	public static void main(String[] args) {
//
//		// int[][] matrizA = null;
//		// int[][] matrizB = null;
//
//		int[][] matrizA = { { 1, 0, 0 }, { 0, -1, 0 }, { 0, 0, 3 } };
//		int[][] matrizB = { { 0, 0, 2 }, { 0, -1, 0 }, { 1, 0, 0 } };
//
//		int filaA = matrizA.length;
//		int colB = matrizB[0].length;
//		// int filaB = matrizB.length;
//
//		int colA = matrizA[0].length;
//		int tempMultiplicacion;
//		int resultado[][] = new int[filaA][colB];
//		String pruebita = "";
//
//		for (int f = 0; f < filaA; f++) {
//
//			for (int c = 0; c < colB; c++) {
//				tempMultiplicacion = 0;
//
//				for (int i = 0; i < colA; i++) {
//
//					tempMultiplicacion = tempMultiplicacion + matrizA[f][i] * matrizB[i][c];
//					pruebita += matrizA[f][i] + "." + matrizB[i][c] + " + ";
//
//				}
//
//				resultado[f][c] = tempMultiplicacion;
//				pruebita += "\n";
//			}
//
//		}
//
//		System.out.println(pruebita);
//
//		for (int x = 0; x < resultado.length; x++) {
//			System.out.print("|");
//			for (int y = 0; y < resultado[0].length; y++) {
//
//				System.out.print(resultado[x][y] + "\t");
//
//			}
//			System.out.println("|");
//		}
//
//		System.out.println("melo papi");
//	}

}
