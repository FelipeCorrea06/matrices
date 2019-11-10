package com.matrices.Servicio_Matrices.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matrices.Servicio_Matrices.service.MatrizService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@RestController
@RequestMapping("/matriz")
public class MatrizController {
	
	@Autowired
	private MatrizService matrizService;
	
	@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
	@PostMapping(path="/inversa")
	public double[][] inversaMatriz(@RequestBody String matrices) {
		return matrizService.calcularInversa(matrices);
	}

	@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
	@PostMapping(path="/sumar")
	public double[][] sumarMatriz(@RequestBody String matrices) {
		return matrizService.calcularSuma(matrices);
	}
	
	@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
	@PostMapping(path="/restar")
	public double[][] restarMatriz(@RequestBody String matrices) {
		return matrizService.calcularResta(matrices);
	}
	
	@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
	@PostMapping(path="/multiplicar")
	public double[][] multiplicarMatriz(@RequestBody String matrices) {
		return matrizService.calcularMultiplicacion(matrices);
	}
	
	@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
	@PostMapping(path="/determinante")
	public String determinanteMatriz(@RequestBody String matrices) {
		return matrizService.calcularDeterminante(matrices);
	}
	
}
