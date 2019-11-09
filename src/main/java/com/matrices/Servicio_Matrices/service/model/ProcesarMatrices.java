package com.matrices.Servicio_Matrices.service.model;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ProcesarMatrices {

	private double[][] matriz;

	public String[] procesarMatriz(String matrices) {
		String replace1 = matrices.replace("[[[", "[");
		String replace2 = replace1.replace("]]]", "]");
		String replace3 = replace2.replace("]],[[", "]_[");
		String[] matriz = replace3.split("_");
		return matriz;
	}

	public String[] generarMatriz(String matrix) {
		String replace1 = matrix.replace("],[", "]_[");
		String replace2 = replace1.replace("[", "");
		String replace3 = replace2.replace("]", "");
		String[] vect = replace3.split("_");
		return vect;
	}

	public double[][] convertirMatriz(String[] values) {
		int fila = values.length, col = 0;
		String[] arrayCol = values[0].split(",");
		col = arrayCol.length;

		this.matriz = new double[fila][col];
		// System.out.println(fila +"X"+col);
		for (int i = 0; i < fila; i++) {
			values[i] = values[i].replaceAll("\"", "");
			String[] array = values[i].split(",");
			for (int j = 0; j < col; j++) {
				this.matriz[i][j] = response(array[j]);
			}
		}

		return this.matriz;

	}

	public double response(String operation) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		double mirelo = 0.0;
		try {
			Object result = engine.eval(operation);
			mirelo = new Double(result.toString());
		} catch (ScriptException se) {
			System.out.println(se);
		}

		return mirelo;
	}
}
