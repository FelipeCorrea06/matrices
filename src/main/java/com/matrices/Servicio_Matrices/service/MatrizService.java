package com.matrices.Servicio_Matrices.service;

import org.springframework.stereotype.Service;

import com.matrices.Servicio_Matrices.service.model.MatrizDeterminante;
import com.matrices.Servicio_Matrices.service.model.MatrizInversa;
import com.matrices.Servicio_Matrices.service.model.MatrizMultiplicar;
import com.matrices.Servicio_Matrices.service.model.MatrizSumaResta;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class MatrizService {
	
	public int[][] calcularInversa(String matriz) {
		MatrizMultiplicar matrizMulti = new MatrizMultiplicar();
		return matrizMulti.multiplicarMatriz(matriz);
	}
	
	public int[][] calcularSuma(String matrices) {
		MatrizSumaResta matrizSumar = new MatrizSumaResta();
		return matrizSumar.sumarYRestarMatriz(matrices, 1);
	}
	
	public int[][] calcularResta(String matrices) {
		MatrizSumaResta matrizRestar = new MatrizSumaResta();
		return matrizRestar.sumarYRestarMatriz(matrices, 2);
	}
	
	public int[][] calcularMultiplicacion(String matriz) {
		MatrizInversa inversa = new MatrizInversa();
		return inversa.inversaMatriz(matriz);
	}
	
	public String calcularDeterminante(String matriz) {
		MatrizDeterminante determinante = new MatrizDeterminante();
		return determinante.hallarDeterminante(matriz);
	}
	
}
