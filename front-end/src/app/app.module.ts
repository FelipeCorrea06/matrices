import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ChipsModule } from 'primeng/chips';
import { ButtonModule } from 'primeng/button';
import { TabMenuModule } from 'primeng/tabmenu';
import { FieldsetModule } from 'primeng/fieldset';
import { CardModule } from 'primeng/card';
import { MatrixPrinterComponent } from './matrix-printer/matrix-printer.component';

@NgModule({
	declarations: [ AppComponent, MatrixPrinterComponent ],
	imports: [
		BrowserModule,
		AppRoutingModule,
		HttpClientModule,
		FormsModule,
		ChipsModule,
		ButtonModule,
		TabMenuModule,
		FieldsetModule,
		BrowserAnimationsModule,
		CardModule
	],
	providers: [],
	bootstrap: [ AppComponent ]
})
export class AppModule {}
