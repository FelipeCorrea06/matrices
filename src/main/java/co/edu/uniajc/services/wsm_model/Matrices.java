package co.edu.uniajc.services.wsm_model;

import java.util.Scanner;

public class Matrices {
	private int cant_matrices;
	private int tam_fila;
	private int tam_colu;
	private float valor;
	private float matriz[][];
	
	
	
	public Matrices(int cant_matrices, int tam_fila, int tam_colu, float valor, float matriz[][]) {
		super();
		this.cant_matrices = cant_matrices;
		this.tam_fila = tam_fila;
		this.tam_colu = tam_colu;
		this.valor = valor;
		this.matriz = matriz;
	}
	
	public Matrices() {}
	
	//int tam_fila, int tam_col
	public void crearMatriz() {
		this.tam_colu = 3;
		this.tam_fila = 3;
		
		for (int i = 0; i < tam_fila; i++) {
			for (int j = 0; j < 3; j++) {
				Scanner nombreMatriz = new Scanner(System.in);
				valor = nombreMatriz.nextInt();
				matriz[i][j] = this.valor;
			}
			
		}
		
		for (int i = 0; i < tam_fila; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("Valores:"+ matriz[i][j] );
			}
			System.out.println("Valores:"+ matriz[i]);
		}
		
	}
	
	
	public int getCant_matrices() {
		return cant_matrices;
	}
	public void setCant_matrices(int cant_matrices) {
		this.cant_matrices = cant_matrices;
	}
	public int getTam_fila() {
		return tam_fila;
	}
	public void setTam_fila(int tam_fila) {
		this.tam_fila = tam_fila;
	}
	public int getTam_colu() {
		return tam_colu;
	}
	public void setTam_colu(int tam_colu) {
		this.tam_colu = tam_colu;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

	public float[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(float[][] matriz) {
		this.matriz = matriz;
	}
	
	
}
