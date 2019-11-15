import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { MatricesService } from './services/matrices.service';
import Swal from 'sweetalert2';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: [ './app.component.css' ]
})
export class AppComponent {
	constructor(private service: MatricesService) {}

	valFila = [];
	matriz = [ [] ];
	matrizResultado = [ [] ];
	matrices = [];
	visible = 0;
	operacion = '';
	determinante = '0';

	student = [
		{
			name: 'Luis Felipe Melo Delgado',
			profession: 'Analista y Desarrollador',
			description:
				'Analista y desarrollador de software, amante de los deportes acuaticos, nadador olympico en charcos y lavaderos.. fiel amante de las tortillas de doña ama!!!',
			photo: 'pipe.jpg',
			job: 'Front-End y Back-End',
			social: '@InfernalRec',
			red: 'Twitter'
		},
		{
			name: 'Luis Felipe Correa Reina',
			profession: 'Analista Funcional (El vigilante, el de los tintos,etc...)',
			description: '',
			photo: 'correa.jpeg',
			job: 'Back-End',
			social: '@pipeespipe97',
			red: 'Instagram'
		},
		{
			name: 'José Carlos Avila',
			profession: 'Auxiliar de Sistemas',
			description:
				'Desarrollador PHP, javascript, jquery Diseñador de DB MySQL, PostgreSQL. Ciclista empedernido.',
			photo: 'jose_castro.jpeg',
			job: 'Back-End',
			social: 'jcavila44@misena.edu.co',
			red: 'E-mail'
		}
	];

	x = 1;
	y = 1;

	addRow() {
		this.y = this.matriz[0].length;
		let newRow = this.valFila;

		let long = newRow.length;

		if (this.y == 0) {
			this.matriz[0] = newRow.length > 0 ? newRow : [ '0' ];
			this.valFila = [];
			return;
		}

		if (newRow.length > this.y) {
			this.matriz = this.matriz.map((fila) => {
				return this.fillArray(fila, long);
			});
		} else if (newRow.length < this.y) {
			newRow = this.fillArray(newRow, this.y);
		}
		this.matriz.push(newRow);
		this.valFila = [];
	}

	fillArray(array: Array<string>, long: number): Array<string> {
		let arrayLength = array.length;
		for (let index = 0; index < Math.abs(long - arrayLength); index++) {
			array.push('0');
		}
		return array;
	}

	deleteData() {
		this.valFila = [];
		this.matriz = [ [] ];
		this.matrices = [];
		this.matrizResultado = [ [] ];
		this.determinante = '';
		this.visible = 0;
	}

	addMatriz() {
		this.matrices.push(this.matriz);
		this.matriz = [ [] ];
		// console.log(this.matrices);
	}

	sumarMatriz() {
		this.visible = 1;
		this.operacion = 'la Suma';
		let resp = this.validarDimension(1);
		if (resp === true) {
			this.service.postSumarMatrices(this.matrices).subscribe((result: any) => {
				this.matrizResultado = result;
			});
		} else {
			let mensaje = 'No se pueden sumar las matrices, porque sus dimensiones no son iguales.';
			this.mostrarMensajeError(mensaje);
		}
	}

	restarMatriz() {
		this.visible = 1;
		this.operacion = 'la Resta';
		let resp = this.validarDimension(2);
		if (resp === true) {
			this.service.postRestarMatrices(this.matrices).subscribe((result: any) => {
				this.matrizResultado = result;
			});
		} else {
			let mensaje = 'No se pueden restar las matrices, porque sus dimensiones no son iguales.';
			this.mostrarMensajeError(mensaje);
		}
	}

	inversaMatriz() {

		
		this.operacion = 'la Inversa';
		
		this.visible = 1;

		let resp = this.validarDimension(4);
		this.calcularDeterminante();
		if (this.determinante !== '0' && resp !== false) {
			this.service.postInversaMatrices(this.matrices).subscribe((result: any) => {
				this.matrizResultado = result;
			});
			this.visible = 1;
		} else {
			this.visible = 0;
			let mensaje = '';
			if (this.determinante === '0') {
				mensaje = 'La matriz no tiene inversa';
				this.mostrarMensajeSuccess(mensaje);
			} else {
				mensaje = 'No se pueden calcular la inversa de la  matriz, porque sus dimensiones no son iguales.';
				this.mostrarMensajeError(mensaje);
			}
		}
	}

	multiplicarMatriz() {
		this.visible = 1;
		this.operacion = 'la Multiplicación';
		let resp = this.validarDimension(3);
		if (resp === true) {
			this.service.postMultiplicarMatrices(this.matrices).subscribe((result: any) => {
				this.matrizResultado = result;
			});
		} else {
			let mensaje =
				'No se pueden multiplicar las matrices, porque sus dimensiones no cumplen con el criterio permitido.';
			this.mostrarMensajeError(mensaje);
		}
	}

	determinanteMatriz() {
		this.operacion = 'el Determinante';
		let resp = this.calcularDeterminante();
		if (resp === false) {
			let mensaje = 'No se pueden calcular el determinante de la  matriz, porque sus dimensiones no son iguales.';
			this.mostrarMensajeError(mensaje);
		} else {
			this.visible = 1;
		}
	}

	calcularDeterminante() {
		let resp = this.validarDimension(5);
		if (resp === true) {
			this.service.postDeterminanteMatrices(this.matrices).subscribe((result: any) => {
				console.log(result);
				this.determinante = '' + result;
			});
		}
		return resp;
	}

	validarDimension(type: number) {
		let cantFila = this.matrices[0].length;
		let cantCol = this.matrices[0][0].length;
		//console.log('fila: ' + cantFila + ' col: ' + cantCol);
		let cantFila2 = 0;
		let cantCol2 = 0;
		if (type !== 4 && type !== 5) {
			cantFila2 = this.matrices[1].length;
			cantCol2 = this.matrices[1][0].length;
		}

		//console.log('fila2: ' + cantFila2 + ' col2: ' + cantCol2);
		// sumar y restar
		if (type === 1 || type === 2) {
			if (cantFila !== cantFila2 || cantCol !== cantCol2) {
				return false;
			} else {
				return true;
			}
			// multiplicación
		} else if (type === 3) {
			if (cantCol !== cantFila2) {
				return false;
			} else {
				return true;
			}
			// inversa y determinante
		} else if (type === 4 || type === 5) {
			if (cantFila !== cantCol) {
				return false;
			} else {
				return true;
			}
		}
	}

	mostrarMensajeError(mensaje: string) {
		Swal.fire({
			title: 'Error!',
			text: mensaje,
			type: 'error',
			confirmButtonText: 'Aceptar'
		});
	}

	mostrarMensajeSuccess(mensaje: string) {
		Swal.fire({
			title: 'Resultado!',
			text: mensaje,
			type: 'success',
			confirmButtonText: 'Aceptar'
		});
	}
}
