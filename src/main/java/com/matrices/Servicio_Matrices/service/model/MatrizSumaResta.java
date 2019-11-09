package com.matrices.Servicio_Matrices.service.model;


public class MatrizSumaResta {
	
	public double[][] sumarYRestarMatriz(String matrices, int tipo) {
		ProcesarMatrices procesar = new ProcesarMatrices();
		double [][] resultado;
		int fila=0, col=0;
		
		String [] matriz = procesar.procesarMatriz(matrices);
		
		String [] matriz1 = procesar.generarMatriz(matriz[0]);
		String [] matriz2 = procesar.generarMatriz(matriz[1]);
		
		double [][] matrizA = procesar.convertirMatriz(matriz1);
		double [][] matrizB = procesar.convertirMatriz(matriz2);
		
		fila = matrizA.length;
		col = matrizA[0].length;
		resultado = new double [fila][col];
		
		for (int i=0; i < fila; i++) {
			for (int j = 0; j < col; j++) {
				if (tipo == 1) {
					resultado[i][j] = matrizA[i][j] + matrizB[i][j];
				} else {
					resultado[i][j] = matrizA[i][j] - matrizB[i][j];
				}
				
			}
		}
		return resultado;
	}
	
	
}
