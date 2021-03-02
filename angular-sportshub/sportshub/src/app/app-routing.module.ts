import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrazioneComponent } from './registrazione/registrazione.component';
import { DatiUtenteComponent } from './dati-utente/dati-utente.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'registrazione', component: RegistrazioneComponent},
  {path: 'dati-utente', component: DatiUtenteComponent},
  {path: '', component: AppComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
