package com.matrices.Servicio_Matrices.service;

import org.springframework.stereotype.Service;

import com.matrices.Servicio_Matrices.service.model.MatrizSumaResta;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class MatrizService {
	
	public String[] calcularInversa(String matriz[]) {
		return matriz;
	}
	
	public int[][] calcularSuma(String matrices) {
		MatrizSumaResta matrizSumar = new MatrizSumaResta();
		return matrizSumar.sumarYRestarMatriz(matrices, 1);
	}
	
	public int[][] calcularResta(String matrices) {
		MatrizSumaResta matrizRestar = new MatrizSumaResta();
		return matrizRestar.sumarYRestarMatriz(matrices, 2);
	}
	
	public String[] calcularMultiplicacion(String matriz[]) {
		return matriz;
	}
	
	public String[] calcularDeterminante(String matriz[]) {
		return matriz;
	}
	
}
