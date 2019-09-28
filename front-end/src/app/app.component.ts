import { Component } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: [ './app.component.css' ]
})
export class AppComponent {
	items: MenuItem[];
	activeItem: MenuItem;

	ngOnInit() {
		this.items = [
			{ id: '0', label: 'Matrices', icon: 'fa fa-fw fa-th' },
			{ id: '1', label: 'Documentación', icon: 'fa fa-fw fa-book' },
			{ id: '2', label: 'Información del Sistema', icon: 'fa fa-fw fa-info-circle' },
			{ id: '3', label: 'Acerca De', icon: 'fa fa-fw fa-address-card' }
		];

		this.activeItem = this.items[0];
	}

	visible = 0;
	valFila = [];
	matriz = [ [] ];
	matrices = [];

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
			description: 'Hermano de PHP',
			photo: '',
			job: 'Back-End',
			social: 'jcavila44@misena.edu.co',
			red: 'E-mail'
		}
	];

	x = 1;
	y = 1;

	viewData(num: string) {
		this.visible = parseInt(num, 10);
	}

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
	}

	addMatriz() {
		this.matrices.push(this.matriz);
		this.matriz = [ [] ];
		console.log(this.matrices);
	}
}
