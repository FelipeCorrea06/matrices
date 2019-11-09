package com.matrices.Servicio_Matrices.service.model;

public class MatrizDeterminante {
	
	
	public String hallarDeterminante(String matrices) {
		
		ProcesarMatrices procesar = new ProcesarMatrices();
		String resultado;
		
		String [] matriz = procesar.procesarMatriz(matrices);
		String [] matriz1 = procesar.generarMatriz(matriz[0]);
		double  [][] matrizA = procesar.convertirMatriz(matriz1);
		
		resultado = String.valueOf(MatrizDeterminante.determinante(matrizA));
		return resultado;
	}
	
	/**
     * Calcula el determinante de la matriz. Para ello coge la primera fila y se
     * va multiplicando cada coeficiente por el determinante de la matriz de
     * orden n-1 que resulta de suprimir la fila y columna del coeficiente. Hay
     * que ir alternando los signos. Ver
     *
     * @param matriz
     * @return
     */
	public static double determinante(double[][] matriz) {
		assert matriz != null;
		assert matriz.length > 0;
		assert matriz.length == matriz[0].length;

		double determinante = 0;

		int filas = matriz.length;
		int columnas = matriz[0].length;

		// Si la matriz es 1x1, el determinante es el elemento de la matriz
		if ((filas == 1) && (columnas == 1)) {
			return matriz[0][0];
		}

		int signo = 1;

		for (int columna = 0; columna < columnas; columna++) {
			// Obtiene el adjunto de fila=0, columna=columna, pero sin el signo.
			double [][] submatriz = getSubmatriz(matriz, filas, columnas, columna);
			determinante = determinante + signo * matriz[0][columna] * determinante(submatriz);
			signo *= -1;
		}

		return determinante;
	}

	/**
     * Obtiene la matriz que resulta de eliminar la primera fila y la columna
     * que se pasa como parámetro.
     *
     * @param matriz Matriz original
     * @param filas Numero de filas de la matriz original
     * @param columnas Numero de columnas de la matriz original
     * @param columna Columna que se quiere eliminar, junto con la fila=0
     * @return Una matriz de N-1 x N-1 elementos
     */
	public static double[][] getSubmatriz(double[][] matriz, int filas, int columnas, int columna) {
		double[][] submatriz = new double[filas - 1][columnas - 1];
		int contador = 0;
		for (int j = 0; j < columnas; j++) {
			if (j == columna) {
				continue;
			}
			for (int i = 1; i < filas; i++) {
				submatriz[i - 1][contador] = matriz[i][j];
			}
			contador++;
		}
		return submatriz;
	}
}
