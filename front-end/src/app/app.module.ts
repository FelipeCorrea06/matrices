import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { ChipsModule } from 'primeng/chips';
import { ButtonModule } from 'primeng/button';
import { TabMenuModule } from 'primeng/tabmenu';
import { FieldsetModule } from 'primeng/fieldset';
import { CardModule } from 'primeng/card';

@NgModule({
	declarations: [ AppComponent ],
	imports: [
		BrowserModule,
		AppRoutingModule,
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
