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
	
	public JsonArray calcularSuma(JsonArray matrices) {
		MatrizSumaResta matrizSumar = new MatrizSumaResta();
		return matrizSumar.sumarMatriz(matrices);
	}
	
	public String[] calcularResta(String matriz[]) {
		return matriz;
	}
	
	public String[] calcularMultiplicacion(String matriz[]) {
		return matriz;
	}
	
	public String[] calcularDeterminante(String matriz[]) {
		return matriz;
	}
	
}
