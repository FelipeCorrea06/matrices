package com.matrices.Servicio_Matrices.service.model;

public class ProcesarMatrices {
	
	private int [][] matriz;
	
	public String[] procesarMatriz(String matrices) {
		String replace1 = matrices.replace("[[[", "[");
		String replace2 = replace1.replace("]]]", "]");
		String replace3 = replace2.replace("]],[[", "]-[");
		String [] matriz = replace3.split("-");
		return matriz;
	}
	
	public String[] generarMatriz(String matrix) {
		String replace1 = matrix.replace("],[", "]-[");
		String replace2 = replace1.replace("[", "");
		String replace3 = replace2.replace("]", "");
		String [] vect = replace3.split("-");
		return vect;
	}
	
	public int[][] convertirMatriz(String[] values) {
		int fila=values.length, col=0;
		String[] arrayCol = values[0].split(",");
		col = arrayCol.length;
		
		this.matriz = new int [fila][col];
		//System.out.println(fila +"X"+col);
		for (int i = 0; i < fila; i++) {
			values[i] = values[i].replaceAll("\"", "");
			String[] array = values[i].split(",");
			for (int j = 0; j < col; j++) {
				this.matriz[i][j] = Integer.parseInt(array[j]);
			}
		}
		
		return this.matriz;
		
	}
	
}
