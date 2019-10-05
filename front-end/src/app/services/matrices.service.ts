import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
	providedIn: 'root'
})
export class MatricesService {
	constructor(private http: HttpClient) {}

	postSumarMatrices(data: any) {
		return this.http.post('http://localhost:9898/matriz/sumar', JSON.stringify(data));
	}

	postRestarMatrices(data: any) {
		return this.http.post('http://localhost:9898/matriz/restar', JSON.stringify(data));
	}

	postDeterminanteMatrices(data: any) {
		return this.http.post('http://localhost:9898/matriz/determinante', JSON.stringify(data));
	}

	postInversaMatrices(data: any) {
		return this.http.post('http://localhost:9898/matriz/inversa', JSON.stringify(data));
	}

	postMultiplicarMatrices(data: any) {
		return this.http.post('http://localhost:9898/matriz/multiplicar', JSON.stringify(data));
	}
}
