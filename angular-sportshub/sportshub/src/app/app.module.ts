import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrazioneComponent } from './registrazione/registrazione.component';
import { DatiUtenteComponent } from './dati-utente/dati-utente.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CambioDatiComponent } from './cambio-dati/cambio-dati.component';
import { CambioPwdComponent } from './cambio-pwd/cambio-pwd.component';
import { ListaCentriComponent } from './lista-centri/lista-centri.component';
import { SportOfCentroComponent } from './sport-of-centro/sport-of-centro.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrazioneComponent,
    DatiUtenteComponent,
    HomeComponent,
    NavbarComponent,
    CambioDatiComponent,
    CambioPwdComponent,
    ListaCentriComponent,
    SportOfCentroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
